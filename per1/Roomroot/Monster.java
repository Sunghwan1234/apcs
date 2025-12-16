package Roomroot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.List;

public class Monster implements Entity {
    private static final int equalProbability = 90;

    private static Map<String, Monster> MONSTERS = new HashMap<>();

    public String name, type;
    private int level;
    private int hp_max=100, hp=100, mana_max=0, mana=0, damage=10;
    private ArrayList<Action> actions;

    private Player target;

    public Monster() {
        MONSTERS.put("Goblin",          new Monster("Goblin", 3, 10, 0, 5));
        MONSTERS.put("Bully Goblin",    new Monster("Bully Goblin", 5, 10, 0 ,5));
        MONSTERS.put("Troll",           new Monster("Troll", 7, 10, 0, 10));
        MONSTERS.put("Orc",             new Monster("Orc", 10, 100, 0, 25));
    }

    public Monster(Monster m) {
        
    }

    public Monster(String type, int level, int hp, int mana, int damage) {
        c_basic(type, level, hp, mana, damage);
    }
    public void c_basic(String type, int level, int hp, int mana, int damage) {
        this.type=type;
        this.level=level;
        this.hp=hp;
        this.mana=mana;
        this.damage=damage;
    }

    public static String getRandom(Player player) {
        while (true) {
            String m_name = getRandomKey(MONSTERS);
            Monster m = MONSTERS.get(m_name);
            if (100*Math.random() < equalProbability + Math.abs(Math.pow(player.level-m.level,3))) {
                return m_name;
            }
        }
    }
    public static Monster getMonster(String type) {
        return new Monster(MONSTERS.get(type));
    }

    public static <K, V> K getRandomKey(Map<K, V> map) {
        if (map.isEmpty()) {
            return null;
        }

        // 1. Convert the keySet to an ArrayList
        List<K> keysAsList = new ArrayList<>(map.keySet());

        // 2. Generate a random index
        // Use ThreadLocalRandom for a good random number generator
        int randomIndex = ThreadLocalRandom.current().nextInt(keysAsList.size());

        // 3. Get the key at the random index
        return keysAsList.get(randomIndex);
    }

    @Override
    public ArrayList<Action> getActions() {
        if (this.actions==null) {
            if (this.damage>0) {
                ArrayList<Action> actions = new ArrayList<>();
                actions.add(new Action(Action.ATT, this, null, null));
            }
        }
        return this.actions;
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

    public static ArrayList<String> getMonsterNames(ArrayList<Monster> monsters) {
        ArrayList<String> names = new ArrayList<>();
        for (int i=0;i<monsters.size();i++) {
            names.add(monsters.get(i).toString());
        }
        return names;
    }

    public void setTarget(Player target) {
        this.target = target;
    }

    public String toString() {
        return this.type+" (Level "+this.level+")";
    }
    
}
