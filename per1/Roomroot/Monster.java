package Roomroot;

import java.util.ArrayList;

public class Monster implements Entity {
    public String name, type;
    private int level;
    private int hp_max=100, hp=100, mana_max=0, mana=0, damage=10;

    public int chance;
    public Monster(Player player) {
        Monster[] monsters = {
            new Monster("Goblin", 3, 10, 0, 5),
            new Monster("Bully Goblin", 5, 10, 0 ,5),
            new Monster("Troll", 7, 10, 0, 5),
            new Monster("Orc", 10, 100, 0, 25)
        };

        while (type==null) {
            Monster m = monsters[(int)(Math.random()*monsters.length)];
            if (Math.random()*(player.level+10) > m.level) {
                create(m);
            }
        }
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
    public void create(Monster m) {
        this.type=m.type;
        this.level=m.level;
        this.hp=m.hp;
        this.mana=m.mana;
        this.damage=m.damage;
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
    
}
