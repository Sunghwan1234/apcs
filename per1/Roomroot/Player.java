package Roomroot;

import java.util.ArrayList;

public class Player implements Entity {
    public String name;
    public int hp_max=100; public int hp=100;
    public int mana=100; public int mana_max=100;
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
}