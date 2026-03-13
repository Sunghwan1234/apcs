package Roomroot;

import java.util.ArrayList;
import java.util.HashMap;

import Roomroot.Action.Type;

public class Item implements Thing, Comparable<Item> {
    public static int ids=0;
    private final int id;
    
    public String name, description;
    public int level = 0;
    public int count = 1;

    public int cooldown;
    public int cooldownTimer;

    public ArrayList<Action> actions = new ArrayList<>();

    private static final HashMap<String, Item> ITEMS = new HashMap<>(){{
        put("Health Potion", new Item("Health Potion", 
            new Action("Drink Health Potion", "Restores 50 health")
                .v("hp", 50).v("consume")
        ));
        put("Mana Potion", new Item("Mana Potion", 
            new Action("Drink Mana Potion", "Recharges 50 mana")
                .v("mp", 50).v("consume")
        ));
        put("Wand", new Item("Wand", 
            new Action("Fireball", "Shoots a burst of fire")
                .v("hp", -25).v("mp.exec", -10)
        ));
        put("Greatsword", new Item("Sword",
            new Action("Slash", "Slash the opponent").v("hp",-20),
            new Action("Super Swing", "Deal massive damage using 25 mana")
                .v("hp", -50).v("mp.exec",-25)
        ));
        put("Daggers", new Item("Daggers",
            new Action("Quickslash", "Slash the opponent two times")
                .v("hp",-12).v("hp",-12),
            new Action("Dual Pierce", "Puncture the opponent with both hands")
                .v("hp",-30).v("mp.exec", -15)
        ));
        put("Small Shield", new Item("Small Shield",
            new Action("Block", "Enter a defensive mode")
                .v("def.exec",5),
            new Action("Push Block", "Push the enemy while blocking")
                .v("def.exec", 3).v("hp",-5)
        ));
        put("Gloves", new Item("Gloves",
            new Action("Punch", "Throw a strong punch").v("hp",-10),
            new Action("Uppercut", "Knock the opponent's head").v("hp", -25).v("cooldown", 2)
        ));
    }};
    public static Item getNew(String name) {
        Item mItem = ITEMS.get(name);
        Item item = new Item(mItem.name); item.description = mItem.description;
        for (Action a : mItem.actions) {item.actions.add(a);}
        item.level = mItem.level;
        item.count = mItem.count;
        return item;
    }
    public Item(String name) {
        this.name = name;

        this.id=ids++;
    }
    public Item(String name, ArrayList<Action> actions) {
        this.name = name; this.actions = actions;
        this.id=ids++;
    }
    public Item(String name, Action... actions) {
        this.name = name; setActions(actions);
        this.id=ids++;
    }
    public Item(String name, String description, ArrayList<Action> actions) {
        this.name = name; this.description = description; this.actions = actions;
        this.id=ids++;
    }
    public Item(String name, String description, Action... actions) {
        this.name=name; this.description=description; setActions(actions);
        this.id=ids++;
    }
    
    private void setActions(Action[] actions) {for (Action a : actions) {this.actions.add(a);}}

    @Override
    public ArrayList<Action> getActions() {
        ArrayList<Action> itemActions = actions;
        return itemActions;
    }

    public String toInventoryString() {
        String s = this.toString();
        if (Roomroot.player.weapon.equals(this)) {
            s+= " (Equipped)";
        }
        return s;
    }

    public String inspect() {
        String inspectActions="";
        for (Action a : this.actions) {
            inspectActions+="|\t"+a;
            if (a.vars.containsKey("hp")) {
                int var_hp = a.vars.get("hp");
                if (var_hp>0) {
                    inspectActions+="\n|\t Heal "+var_hp+"HP of Target";
                } else {
                    inspectActions+="\n|\t Deal "+-var_hp+"DMG to Target";
                }
            }
            if (a.vars.containsKey("mp")) {
                int var_mp = a.vars.get("mp");
                if (var_mp>0) {
                    inspectActions+="\n|\t Regenerate "+var_mp+"MP of Target";
                } else {
                    inspectActions+="\n|\t Remove "+-var_mp+"MP to Target";
                }
            }
            if (a.vars.containsKey("def.exec")) { // probably change Increase to smth cooler
                inspectActions+="\n|\t Increase "+a.vars.get("def.exec")+"Def";
            }
            if (a.vars.containsKey("mp.exec")) {
                inspectActions+="\n|\t Consume "+a.vars.get("mp.exec")+"MP";
            }

            inspectActions+="\n";
        }
        return inspectActions;
    }

    @Override
    public String toString() {
        String s = this.name;
        if (this.level != 0) {
            s += " [Level "+this.level+"]";
        }
        return s;
    }
    @Override
    public int compareTo(Item o) {
        if (
            this.name==o.name && 
            this.level==o.level && 
            this.description==o.description &&
            this.actions.equals(o.actions)
        ) {
            return 0;
        } else {
            return -1;
        }
    }
    @Override
    public boolean equals(Object obj) {
        Roomroot.debugLine(this+"="+obj+"? "+this.compareTo((Item) obj)); // TODO: debug
        if (obj instanceof Item) {
            return 0==this.compareTo((Item) obj);
        }
        return false;
    }
}