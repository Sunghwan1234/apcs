package Roomroot;

import java.util.ArrayList;

public class Monster implements Entity {
    public String name, type;
    private int level;
    private int hp_max=100, hp=100, mana_max=0, mana=0, damage=10;

    public int chance;
    public Monster(Player player) {
        Monster[] monsters = {
            new Monster("Goblin",3),
            new Monster("Bully Goblin", 5),
            new Monster("Troll", 7),
            new Monster("Orc", 10)
        };

        while (type==null) {
            Monster m = monsters[(int)(Math.random()*monsters.length)];
            if (Math.random()*(player.level+10) > m.level) {type=m.name;}
        }

    }

    public Monster(String type) {
        this.name = type;
        switch (type) {
            case "Goblin":      c_basic(10,0,5); break;
            case "Bully Goblin":c_basic(25,0,10); break;
            case "Troll":       c_basic(50,0,15); break;
            case "Orc":         c_basic(100,0,25); break;
            default: break;
        }
    };

    public Monster(String type, int level) {
        this.type=type;
        this.level=level;
    }

    private void c_basic(int hp, int mana, int damage) {
        this.hp_max = hp;
        this.hp = hp;
        this.mana_max = mana;
        this.mana = mana;
        this.damage = damage;
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
