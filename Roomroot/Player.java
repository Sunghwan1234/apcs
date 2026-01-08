package Roomroot;

import java.util.ArrayList;

public class Player implements Entity {
    public static ArrayList<Location> path = new ArrayList<>();

    private String name;
    public int level = 0;
    public Max hp = new Max(100);
    public Max mana = new Max(100);
    public int con = 0, mag = 0;
    public Location loc;

    private ArrayList<Monster> targets;

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
        return hp.v()>0;
    }


    @Override
    public String[] getStatus() {
        String[] statuses = {
            "Your Health: "+hp+"/"+hp.max,
            "Your Mana: "+mana+"/"+mana.max
        };
        return statuses;
    }

    public static void addLocationToPath(Location location) {
        Player.path.add(location);
    }

    public void setTargets(ArrayList<Monster> targets) {
        this.targets = targets;
    }
    public ArrayList<Monster> getTargets() {
        return this.targets;
    }

    public int getLevel() {
        return level;
    }

    @Override
    public String toString() {
        return name+" [Lv"+level+"]";
    }
}