package Roomroot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

import java.util.List;

public class Monster implements Entity {
    private static final int equalProbability = 90;

    private static Map<String, Monster> MONSTERS = new HashMap<>();

    static {
        MONSTERS.put("Goblin",          new Monster("Goblin", 3, 10, 0, 5));
        MONSTERS.put("Bully Goblin",    new Monster("Bully Goblin", 5, 10, 0 ,5));
        MONSTERS.put("Troll",           new Monster("Troll", 7, 10, 0, 10));
        MONSTERS.put("Orc",             new Monster("Orc", 10, 100, 0, 25));
    }

    /** A group of monsters get aggro'ed together. */
    //public static ArrayList<Monster> aggroGroup;

    public String name, type;
    private int level = 0;
    public Max hp = new Max(100);
    public Max mp = new Max(0);
    private int damage = 10;
    private ArrayList<Action> actions = new ArrayList<>();
    //private ArrayList<ExAction> xactions;

    private Entity target;

    public Monster() {}

    public Monster(Monster m) {
        this.type=m.type;
        this.level=m.level;
        this.hp=m.hp;
        this.mp=m.mp;
        this.damage=m.damage;
    }
    public Monster(String type, int level, int hp, int mana, int damage) {
        c_basic(type, level, hp, mana);
        this.actions.add(new Action(this, damage));
    }
    public Monster(String type, int level, int hp, int mana, Action... actions) {
        c_basic(type, level, hp, mana);
        for (Action a : actions) {this.actions.add(a);}
    }
    public void c_basic(String type, int level, int hp, int mana) {
        this.type=type; this.level=level; this.hp.set(hp); this.mp.set(mana);
    }
    /** STATIC Get a random monster. */
    public static String getRandom(Player player) {
        while (true) {
            String m_name = getRandomKey(MONSTERS);
            Monster m = MONSTERS.get(m_name);
            if (100*Math.random() < equalProbability + Math.abs(Math.pow(player.level-m.level,3))) { // ERR
                //Roomroot.pl("GetRandom: "+m_name);
                return m_name;
            }
        }
    }
    public static <K, V> K getRandomKey(Map<K, V> map) {
        if (map.isEmpty()) {return null;}
        // 1. Convert the keySet to an ArrayList
        List<K> keysAsList = new ArrayList<>(map.keySet());
        // 2. Generate a random index: Use ThreadLocalRandom for a good random number generator
        int randomIndex = ThreadLocalRandom.current().nextInt(keysAsList.size());
        // 3. Get the key at the random index
        return keysAsList.get(randomIndex);
    }
    public static Monster getMonster(String type) {
        return new Monster(MONSTERS.get(type));
    }

    @Override
    public ArrayList<Action> getActions() {
        if (this.actions.size()==0) {
            this.actions.add(new Action(this, damage)); // TODO: check if this fixes no action in m getaction
        }
        return this.actions;
    }
    
    @Override
    public String[] getStatus() {
        String line1 = this.getSimpleString()+"'s Health: "+hp+"/"+hp.max;
        if (this.mp.max>0) {
            line1 += " | Mana: "+mp+"/"+mp.max;
        }
        String[] statuses = {
            line1
        };
        return statuses;
    }

    public static ArrayList<String> getMonsterNames(ArrayList<Monster> monsters) {
        ArrayList<String> names = new ArrayList<>();
        for (int i=0;i<monsters.size();i++) {
            names.add(monsters.get(i).toString());
        }
        return names;
    }

    public void setTarget(Entity target) {
        this.target = target;
    }

    public String getSimpleString() {
        return this.type+" [Level "+this.level+"]";
    }

    public String toString() {
        String str = this.type+" [Level "+this.level+"]";
        if (!this.hp.full()) {
            str += " ("+hp.v()+"/"+hp.max+")";
        }
        return str;
    }

    @Override
    public boolean isAlive() {
        return this.hp.v()>0;
    }

    @Override
    public void damage(int damage) {
        this.hp.dec(damage);
    }

    
}
