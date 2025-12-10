package Roomroot;

import java.util.ArrayList;

public class Monster implements Entity {
    String name;
    int hp_max, hp, mana, mana_max;

    public Monster(String type) {

    };


    @Override
    public ArrayList<Action> getActions() {
        return null;
    }

    @Override
    public boolean isAlive() {return this.hp>0;}
    
    @Override
    public String[] getStatus() {
        String[] statuses = {
            name+"'s Health: "+hp+"/"+hp_max,
            name+"'s Mana: "+mana+"/"+mana_max
        };
        return statuses;
    }
    
}
