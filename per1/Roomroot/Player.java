package Roomroot;

import java.util.ArrayList;

public class Player implements Entity {
    public static ArrayList<Location> path = new ArrayList<>();

    private String name;
    public int level = 0;
    public int hp_max=100, hp=100, hp_level=0;
    public int mana_max=100, mana=100, magic_level=0;
    public Location loc;
    

    public Player(String name) {
        this.name = name;
    }


    @Override
    public ArrayList<Action> getActions() {
        ArrayList<Action> actions = new ArrayList<>();
        actions.addAll(this.loc.getActions());
        actions.add(new Action(-100));

        return actions;
    }

    @Override
    public boolean isAlive() {
        return hp>0;
    }


    @Override
    public String[] getStatus() {
        String[] statuses = {
            "Your Health: "+hp+"/"+hp_max,
            "Your Mana: "+mana+"/"+mana_max
        };
        return statuses;
    }

    public static void addLocationToPath(Location location) {
        Player.path.add(location);
    }
    public int getLevel() {
        return level;
    }

    @Override
    public String toString() {
        return this.name;
    }
}