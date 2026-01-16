package Roomroot;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class Item implements Thing {
    
    public String name, description;
    public int level = 0;

    public ArrayList<Action> actions = new ArrayList<>();

    public static final HashMap<String, Item> ITEMS = new HashMap<>();
    static {
        ITEMS.put("Health Potion", new Item("Health Potion", new ArrayList<Action>(){{
            add(new Action("Health Potion", "Restores 50 health", Action.HEAL, 50, 0));
        }}));
        ITEMS.put("Mana Potion", new Item("Mana Potion", new ArrayList<Action>(){{
            add(new Action("Mana Potion", "Restores 50 mana", Action.HEALMANA, 0, 50));
        }}));
        ITEMS.put("Wand", new Item("Wand", new ArrayList<Action>(){{
            add(new Action("Fireball", "Shoots a burst of fire", Action.DAMAGE, 25, 10));
        }}));
    }
    public Item(String name) {
        this.name = name;
    }
    public Item(String name, ArrayList<Action> actions) {
        this.name = name;
        this.actions = actions;
    }
    public Item(String name, String description, ArrayList<Action> actions) {
        this.name = name;
        this.description = description;
        this.actions = actions;
    }
    

    @Override
    public ArrayList<Action> getActions() {
        ArrayList<Action> itemActions = actions;
        return itemActions;
    }

    public String toString() {
        return this.name;
    }
}