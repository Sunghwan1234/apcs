package Roomroot;

import Roomroot.Monsters;

import java.util.ArrayList;

public class Monster implements Entity {
    private static final int equalProbability = 90;

    public String name, type;
    private int level;
    private int hp_max=100, hp=100, mana_max=0, mana=0, damage=10;

    public Monster(Player player) {
        setSelf(getRandomMonster(player));
    }

    public Monster(String type, int level, int hp, int mana, int damage) {
        c_basic(type,level, hp, mana, damage);
    }
    public void c_basic(String type, int level, int hp, int mana, int damage) {
        this.type=type;
        this.level=level;
        this.hp=hp;
        this.mana=mana;
        this.damage=damage;
    }
    public void setSelf(Monster m) {
        this.type=m.type;
        this.level=m.level;
        this.hp=m.hp;
        this.mana=m.mana;
        this.damage=m.damage;
    }

    public static Monster getRandomMonster(Player player) {
        while (true) {
            Monster m = Monsters.monsters[(int)(Math.random()*Monsters.monsters.length)];
            if (100*Math.random() < equalProbability + Math.abs(Math.pow(player.level-m.level,3))) {
                return m;
            }
        }
    }

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

    public String toString() {
        return this.type;
    }
    
}
