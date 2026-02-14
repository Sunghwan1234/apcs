package Roomroot;

import java.util.ArrayList;

import Roomroot.Action.Type;

public class Player extends Entity {
    public static ArrayList<Location> path = new ArrayList<>();

    public final String name;
    public int level = 0;
    public Max hp = new Max(100);
    public Max mp = new Max(100);
    public int con = 0, mag = 0;
    public Location loc;

    public ArrayList<Item> inventory = new ArrayList<>();
    private Item weapon = null;

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
            ArrayList<Action> enemyChoice = new ArrayList<>();
            for (Monster m : targets) {
                enemyChoice.add(new Action(Type.CHOOSE, m.toString(), m) {
                    @Override
                    public String execute(Player player) {
                        player.setTarget((Entity) this.target);
                        Roomroot.pl("Target set to "+m.toString());
                        return "Target set.";
                    }
                });
            }
            actions.add(new Action(enemyChoice, "Choose Target"));

            if (weapon!=null) {
                ArrayList<Action> weaponActions = weapon.getActions();
                if (weaponActions.size()==1) {
                    actions.add(new Action(this, target, weaponActions.get(0), weapon+": Use "+weaponActions.get(0)));
                } else {
                    ArrayList<Action> attackActions = new ArrayList<>();
                    for (Action a : weapon.getActions()) {
                        attackActions.add(new Action(this, target, a));
                    }
                    actions.add(new Action(attackActions, "Choose "+weapon+" Action"));
                }
            }

        }

        // Inventory Actions ----------------------------------------------------------------
        ArrayList<Action> equipActions = new ArrayList<>();
        ArrayList<Action> useActions = new ArrayList<>();
        for (Item i : inventory) {
            equipActions.add(new Action(Type.EQUIP, i));
            if (i.getActions().size()>1) {
                useActions.add(new Action(this, this, i.getActions().get(0)));
            } else {
                ArrayList<Action> itemActions = new ArrayList<>();
                for (Action a : i.getActions()) {
                    itemActions.add(new Action(this, this, a));
                }
                useActions.add(new Action(itemActions, i+" ("+i.getActions().size()+")", true));
            }
        }
        Action equipAction = new Action(equipActions, "Equip Weapon", true);
        Action useAction = new Action(useActions, "Use Item", true);

        actions.add(new Action("View Inventory", equipAction, useAction) {
            @Override
            public String execute(Player player) {
                Roomroot.pl("---- Your Inventory ----");
                for (int i = 0; i < player.inventory.size(); i++) {
                    Item item = player.inventory.get(i);
                    String line = "("+(i+1)+")\t "+item.toInventoryString();
                    if (item.description!=null) {
                        line+=" : "+item.description;
                    }
                    Roomroot.pl(line);
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
    public void damage(int damage) {
        //Roomroot.debugLine("Recieving Damage: "+damage);
        this.hp.dec(damage);
    }
    @Override
    public void heal(int hp) {
        this.hp.inc(hp);
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

    public int getLevel() {
        return level;
    }

    public void equip(Item weapon) {
        for (Item i : inventory) {
            if (i==weapon) {
                this.weapon = weapon;
            }
        }
    }
    public Item getWeapon() {
        return weapon;
    }

    @Override
    public String toString() {
        String s = "You";
        if (!hp.full()) {s+=" ("+hp+")";}
        return "You";
    }
}