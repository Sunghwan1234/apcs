package Roomroot;

import java.util.ArrayList;

public class Monster implements Entity {
    int hp_max, hp, mana, mana_max;


    @Override
    public ArrayList<Action> getActions() {
        return null;
    }

    @Override
    public boolean isAlive() {return this.hp>0;}
    
}
