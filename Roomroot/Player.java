package Roomroot;

import java.util.ArrayList;

import Roomroot.Action.Type;

public class Player extends Entity {
    public static ArrayList<Location> path = new ArrayList<>();

    public final String name;
    public int level = 0;
    private int xp = 0;
    public final Max hp = new Max(100);
    public final Max mp = new Max(100);
    public int def = 0;
    public int con = 0, mag = 0;
    public Location loc;

    public ArrayList<Item> inventory = new ArrayList<>();
    public Item weapon;

    public ArrayList<Monster> targets;
    private Entity target;

    public Player(String name) {
        this.name = name;
    }


    @Override
    public ArrayList<Action> getActions() {
        ArrayList<Action> actions = new ArrayList<>();
        // Location
        if (Roomroot.status == Roomroot.Status.passive) {
            actions.addAll(this.loc.getActions());
        }
        // In Combat!
        if (Roomroot.status == Roomroot.Status.combat) {
            // Choose Enemy Action --------------------------------------------------------------
            ArrayList<Action> enemyChoice = new ArrayList<>();
            for (Monster m : targets) {
                if (m.isAlive()) {
                    enemyChoice.add(new Action(Type.CHOOSE, m.toString(), m) {
                        @Override
                        public String execute(Player player) {
                            player.setTarget(getTargetEntity());
                            Roomroot.pl("Target set to "+m);
                            return "Target set to "+m;
                        }
                    });
                }
            }
            actions.add(new Action(enemyChoice, "Choose Target"));

            // Weapon Actions --------------------------------------------------------------------
            if (weapon!=null) {
                ArrayList<Action> weaponActions = weapon.getActions();
                if (weaponActions.size()>1) {
                    ArrayList<Action> attackActions = new ArrayList<>();
                    for (Action a : weaponActions) {
                        attackActions.add(new Action(this, target, a, weapon));
                    }
                    actions.add(new Action(attackActions, "Choose "+weapon+" Action"));
                } else {
                    actions.add(new Action(this, target, weaponActions.get(0), weapon)
                        .setName(weapon+": Use "+weaponActions.get(0))); // TODO: chec kif this works
                }
            }

        }

        // Inventory Actions ----------------------------------------------------------------
        ArrayList<Action> equipActions = new ArrayList<>();
        ArrayList<Action> useActions = new ArrayList<>();
        for (Item i : inventory) {
            equipActions.add(new Action(Type.EQUIP, i)); // Equip Action

            if (i.getActions().size()>1) {
                ArrayList<Action> itemActions = new ArrayList<>();
                for (Action a : i.getActions()) {
                    itemActions.add(new Action(this, this, a, i));
                }
                useActions.add(new Action(itemActions, i+" ("+i.getActions().size()+")", true));
            } else {
                useActions.add(new Action(this, this, i.getActions().get(0), i)
                    .setName(i+": "+i.getActions().get(0)));
            }
        }
        Action equipAction = new Action(equipActions, "Equip Weapon", true);
        Action useAction = new Action(useActions, "Use Item", true);

        actions.add(new Action("View Inventory", equipAction, useAction) {
            @Override
            public String execute(Player player) {
                ArrayList<Item> itemsScanned = new ArrayList<>();
                ArrayList<Integer> itemsCount = new ArrayList<>();

                for (int i = 0; i < player.inventory.size(); i++) { // TODO: playtest
                    Item item = player.inventory.get(i);
                    if (itemsScanned.contains(item)) {
                        int ci = itemsScanned.indexOf(item);
                        itemsCount.set(ci, itemsCount.get(ci)+1);
                    } else {
                        itemsScanned.add(item);
                        itemsCount.add(1);
                    }
                }

                Roomroot.pl("---- Your Inventory ----");
                for (int i = 0; i < itemsScanned.size(); i++) {
                    Item item = itemsScanned.get(i);
                    String line = "("+(i+1)+")\t "+item.toInventoryString();
                    if (item.description!=null) {
                        line+=" : "+item.description;
                    }
                    if (itemsCount.get(i)>1) {line+=" ("+itemsCount.get(i)+")";}
                    if (i!=itemsScanned.size()-1) {line+="\n";}
                    Roomroot.p(line);
                }
                Roomroot.pl("\n------------------------");
                return "Inventory Actions:\n";
            }
        }) ;
        
        actions.add(new Action(Type.CUSTOM, "Suicide") {
            @Override
            public String execute(Player player) {
                player.hp.dec(666666);
                return "You have commited suicide.";
            }
        });

        return actions;
    }

    @Override
    public String[] getStatus() {
        String[] statuses = {
            "Your Health: "+hp,
            "Your Mana: "+mp
        };
        return statuses;
    }

    @Override
    public boolean isAlive() {
        return this.hp.v()>0;
    }
    @Override
    public String atDeath() {
        return "You died.";
    }
    
    @Override
    public void changeHP(int health) {
        this.hp.add(Math.max(health-def, 0));
    }

    public String regenerateMP() {
        if (mp.full()) {return "";}
        double tenthLevel = ((double) level)/10.0;
        int regMP = (int)Math.ceil((tenthLevel+1.0)*mp.v()/(tenthLevel+1.0+mp.max-mp.v()));
        if (regMP>mp.max-mp.v()) {regMP=mp.max-mp.v();}
        changeMP(regMP);
        return "You regenerated "+regMP+" Mana!";
    }

    @Override
    public void changeMP(int mana) {
        this.mp.add(mana);
    }

    public static void addLocationToPath(Location location) {
        Player.path.add(location);
    }

    public void setTarget(Entity target) {
        this.target = target;
    }
    @Override
    public Entity getTarget() {
        return this.target;
    }

    public String addXP(int axp) {
        this.xp+=axp;
        String output="";
        while (xp>=level*(level+1)/2+1) {
            this.level++;
            output+="You leveled up!\n";
        }
        if (!output.equals("")) {output+="You are now level "+level+"\n";}
        return output;
    }

    public int getLevel() {
        return this.level;
    }

    public void equip(Item weapon) {
        this.weapon = weapon;
    }

    @Override
    public String toString() {
        String s = "You";
        if (!hp.full()) {
            if (hp.empty()) {s+=" (Dead)";} else {s+=" ("+hp+")";}
        }
        return s;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Player;
    }
}