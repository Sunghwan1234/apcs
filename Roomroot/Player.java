package Roomroot;

import java.util.ArrayList;

import Roomroot.Action.Type;

public class Player implements Entity {
    public static ArrayList<Location> path = new ArrayList<>();

    private String name;
    public int level = 0;
    public Max hp = new Max(100);
    public Max mp = new Max(100);
    public int con = 0, mag = 0;
    public Location loc;

    public ArrayList<Item> inventory = new ArrayList<>();
    private Item weapon = null;

    public Entity target;

    public Player(String name) {
        this.name = name;
    }


    @Override
    public ArrayList<Action> getActions() {
        ArrayList<Action> actions = new ArrayList<>();
        if (Roomroot.status == Roomroot.stat.passive) {
            actions.addAll(this.loc.getActions());
        }

        if (Roomroot.status == Roomroot.stat.combat) {
            actions.add(Action.attackGroup(Monster.aggroGroup)); // TODO: make this work ig
        }

        actions.add(new Action(Type.INV)) ;
        
        actions.add(new Action(Type.INSTAKILL));

        return actions;
    }

    @Override
    public boolean isAlive() {
        return hp.v()>0;
    }


    @Override
    public String[] getStatus() {
        String[] statuses = {
            "Your Health: "+hp+"/"+hp.max,
            "Your Mana: "+mp+"/"+mp.max
        };
        return statuses;
    }

    public static void addLocationToPath(Location location) {
        Player.path.add(location);
    }

    public void setTarget(Entity target) {
        this.target = target;
    }
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
        //return name+" [Lv"+level+"]";
        return "You";
    }
}