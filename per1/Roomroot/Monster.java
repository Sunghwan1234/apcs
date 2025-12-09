package Roomroot;

import java.util.ArrayList;

public class Monster implements Entity {
    String name;
    int hp_max, hp, mana, mana_max;

    public Entity(String type) {

    };


    @Override
    public ArrayList<Action> getActions() {
        return null;
    }

    @Override
    public boolean isAlive() {return this.hp>0;}
    
    @Override
    public String retStatus() {
        return "HP: "+hp+"/"+hp_max;
    }
    
}
