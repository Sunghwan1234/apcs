package Roomroot;

import java.util.ArrayList;

/** All rooms in the game Roomroot. */
public class Location implements Thing {
    public static ArrayList<Location> map = new ArrayList<>();
    public static int discoveredLocations = 0;

    private String type = "Default";
    private String name;
    private ArrayList<Location> passages = new ArrayList<>();
    public boolean discovered = false;
    public boolean locked = false;
    public boolean visible = true;

    public ArrayList<Thing> things = new ArrayList<>();
    public ArrayList<Monster> monsters = new ArrayList<>();

    public Location(String type) {
        map.add(this);

        this.type = type;

        String[] sl = {"ael","nuo","bel","cao","bun","pho","ghi","ard","fri","sin","gho","who","cry","jan","las","vei","kos","qou","za","xu","yi","fu","bi","ne","la","ra","ze","lu","do","mo","te","ve"};
        int r = (int)(Math.random()*3+2);
        this.name = "";
        for (int i=0;i<r;i++) { // TODO: make these names better lol: non-duplicate names
            this.name += sl[(int) (Math.random()*sl.length)];
        }
        this.name = this.name.substring(0,1).toUpperCase()+this.name.substring(1);
    }
    /** For creating NEW passage locations. */
    private Location(Location passage) {
        this("Normal");
        this.addPassage(passage);
        if (Math.random()<0.1) {
            this.locked=true;
        }
        if (Math.random()<0.1) {
            this.visible=false;
        }
    }

    /** 
     * Activates the room when visited:
     * 
     * - Generates passages if undiscovered
     */
    public void visit(Player player) {
        if (!this.discovered) {this.discovered=true;
            discoveredLocations++;
            Player.addLocationToPath(this);

            int passageCount = (int)(Math.random()*4+1);
            double monsterSpawnChance=0.5;

            switch (this.type) {
                case "Spawn":
                    passageCount = 4; monsterSpawnChance=0; break;
                default:break;
            }
            //Roomroot.p("Visiting Location "+name); //debug
            //Roomroot.pl(" | With Passages: "+passageCount); //debug
            for (int i=0;i<passageCount;i++) {
                if ((Math.random()<0.25 && map.size()>3)) {
                    Location Existingloc = map.get((int) (Math.random()*map.size()));
                    this.addPassage(Existingloc);
                    if (Math.random()<0.9) { // 90% chance to add the destination back to the source
                        //Roomroot.p(">> ");
                        Existingloc.addPassage(this);
                    }
                    continue;
                }
                this.addPassage(new Location(this));
            }
            if (monsterSpawnChance>0) {
                Roomroot.debugLine("Spawning monsters");
                /* Monster Spawning */
                if (Math.random() < monsterSpawnChance) {
                    int amount = (int)(Math.random()*((player.level)/10+3)+1);
                    for (int i=0;i<amount;i++) {
                        //Roomroot.pl("Spawning Monster: "+m); //debug
                        this.monsters.add(Monster.getMonster(Monster.getRandom(player))); //TODO: did this fix?
                    }
                }
            }
        }
    }
    

    public ArrayList<String> getDescription() {
        ArrayList<String> things = new ArrayList<>();

        int passageCount=0; int lockedCount=0;
        for (int i=0;i<passages.size();i++) {
            if (passages.get(i).visible) {
                if (passages.get(i).locked) {
                    lockedCount++;
                } else {
                    passageCount++;
                }
            }
        }
        things.add("There are "+passageCount+" passages from here.");
        if (lockedCount>0) {
            things.add("There are also "+lockedCount+" locked passages.");
        }
        if (monsters.size()>0) {
            things.add("There are also "+monsters.size()+" monsters.");
        }
        
        return things;
    }

    public ArrayList<Action> getActions() {
        ArrayList<Action> actions = new ArrayList<>();

        if (Roomroot.status==Roomroot.Status.passive) {
            /* Movement */
            ArrayList<Action> moveActions = new ArrayList<>();
            for (int i=0;i<passages.size();i++) {
                if (passages.get(i).visible && !passages.get(i).locked) {
                    moveActions.add(new Action(passages.get(i)));
                }
            }
            actions.add(new Action(moveActions, "Move"));

            // Attack Monsters --------------------------------------------------
            if (this.monsters.size()>0) {
                if (this.monsters.size()>1) {
                    boolean canAttack=false;
                    ArrayList<Action> targetMonsterActions = new ArrayList<>();
                    for (Monster m : monsters) {
                        if (m.isAlive()) {canAttack=true;
                            targetMonsterActions.add(new Action(m, monsters));
                        }
                    }
                    if (canAttack) {
                        actions.add(new Action(targetMonsterActions, "Attack ("+monsters.size()+" "+monsters.get(0)+")", true));
                    }
                } else {
                    if (monsters.get(0).isAlive()) {
                        actions.add(new Action(monsters.get(0), monsters));
                    }
                }
            }
        }

        return actions;
    }

    public void addPassage(Location location) {
        if (!(this.passages.contains(location) || this.equals(location))) {
            this.passages.add(location);
            //Roomroot.pl("Location "+this+" Added Passaage to: "+location); //debug
        } else {
            //Roomroot.pl("Location "+this+" Did not add Passage to "+location); //debug
        }
    }

    public String toString() {
        String extention = "";
        if (Player.path.size()>0 && Player.path.get(0)==this) {
            extention+=" (Home)";
        }
        if (!discovered) {
            extention+=" (New)";
        }
        return this.name+extention;
    }
}