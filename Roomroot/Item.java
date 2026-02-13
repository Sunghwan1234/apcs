package Roomroot;

import java.util.ArrayList;
import java.util.HashMap;

import Roomroot.Action.Type;

public class Item implements Thing, Comparable<Item> {
    
    public String name, description;
    public int level = 0;
    public int count = 1;

    public ArrayList<Action> actions = new ArrayList<>();

    private static final HashMap<String, Item> ITEMS = new HashMap<>();
    static {
        ITEMS.put("Health Potion", new Item("Health Potion", 
                new Action("Drink Health Potion", "Restores 50 health", Type.HEAL, 50, 0)));
        ITEMS.put("Mana Potion", new Item("Mana Potion", 
                new Action("Drink Mana Potion", "Recharges 50 mana", Type.RECHARGE, 0, 50)));
        ITEMS.put("Wand", new Item("Wand", 
                new Action("Fireball", "Shoots a burst of fire", Type.DAMAGE, 25, 10)));
    }
    public static Item getNew(String name) {
        Item mItem = ITEMS.get(name);
        Item item = new Item(mItem.name);
        item.description = mItem.description;
        item.actions = mItem.actions;
        item.level = mItem.level;
        item.count = mItem.count;
        return item;
    }
    public Item(String name) {
        this.name = name;
    }
    public Item(String name, ArrayList<Action> actions) {
        this.name = name; this.actions = actions;
    }
    public Item(String name, Action... actions) {
        this.name = name; setActions(actions);
    }
    public Item(String name, String description, ArrayList<Action> actions) {
        this.name = name; this.description = description; this.actions = actions;
    }
    public Item(String name, String description, Action... actions) {
        this.name=name; this.description=description; setActions(actions);
    }
    
    private void setActions(Action[] actions) {for (Action a : actions) {this.actions.add(a);}}

    @Override
    public ArrayList<Action> getActions() {
        ArrayList<Action> itemActions = actions;
        return itemActions;
    }

    public String toInventoryString() {
        String s = this.toString();
        if (Roomroot.player.getWeapon().equals(this)) {
            s+= " (Equipped)";
        }
        return s;
    }

    public String toString() {
        String s = this.name;
        if (this.level != 0) {
            s += " [Level "+this.level+"]";
        }
        return s;
    }
    @Override
    public int compareTo(Item o) {
        if (this.name==o.name && this.level==o.level && this.description==o.description) {
            return 0;
        } else {
            return -1;
        }
    }
}