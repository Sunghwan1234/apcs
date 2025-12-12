package Roomroot;

import java.util.ArrayList;

/** All rooms in the game Roomroot. */
public class Location implements Thing {
    public static ArrayList<Location> map = new ArrayList<>();
    public static int discoveredLocations = 0;


    public String name;
    private ArrayList<Location> passages = new ArrayList<>();
    public boolean discovered = false;
    public boolean locked = false;
    public boolean visible = true;

    public Entity[] entities;

    public Location(String type) {
        map.add(this);

        String[] sl = {"ale","nuo","bel","cao","bnu","pho","ghi","ard","fri","sni","gho","who","cru","jan","las","vei","kos","qou","zma","xil","yni","fud"};
        int r = (int)(Math.random()*3+2);
        this.name = "";
        for (int i=0;i<r;i++) {
            this.name += sl[(int) (Math.random()*(sl.length-1))];
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
    public void visit() {
        if (!this.discovered) {
            //Roomroot.p("Visiting Location "+name); //debug
            this.discovered=true;
            discoveredLocations++;

            int passageCount = (int)(Math.random()*4+1);
            //Roomroot.pl(" | With Passages: "+passageCount); //debug
            for (int i=0;i<passageCount;i++) {
                if (Math.random()<0.25 && map.size()>1) {
                    Location Existingloc = map.get((int) (Math.random()*map.size()));
                    this.addPassage(Existingloc);
                    if (Math.random()<0.9) {
                        //Roomroot.p(">> ");
                        Existingloc.addPassage(this);
                    }
                    continue;
                }
                this.addPassage(new Location(this));
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
        

        return things;
    }

    public ArrayList<Action> getActions() {
        ArrayList<Action> actions = new ArrayList<>();

        ArrayList<Action> moveActions = new ArrayList<>();
        for (int i=0;i<passages.size();i++) {
            if (passages.get(i).visible && !passages.get(i).locked) {
                moveActions.add(new Action(passages.get(i)));
            }
        }
        actions.add(new Action(moveActions, "Move"));
        /* 
        for (int i=0;i<this.entities.length;i++) {
            if (entities[i].isAlive()) {
                actions.addAll(entities[i].getActions());
            }
        }
        */
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
        return this.name;
    }
}