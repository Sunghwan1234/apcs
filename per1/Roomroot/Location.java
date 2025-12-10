package Roomroot;

import java.util.ArrayList;

/** All rooms in the game Roomroot. */
public class Location implements Thing {
    public static ArrayList<Location> locations = new ArrayList<>();


    public String name;
    public Location[] passages;
    public boolean discovered = false;
    public boolean locked = false;

    public Entity[] entities;

    public Location() {
        String[] sl = {"ale","nuo","bel","cao","bnu","pho","ghi","ard","fri","sni","gho","who","cru","jan","las","vei","kos","qou","zma","xil","yni","fud"};
        this.name = "";
        int rep = (int) Math.random()*3+2;
        for (int i=0;i<rep;i++) {
            this.name += sl[(int) (Math.random()*(sl.length-1))];
        }
        this.name = this.name.substring(0,1).toUpperCase()+this.name.substring(1);
    }
    public Location(String name, Location[] passages) {
        this.name=name; this.passages=passages;

        locations.add(this);
        this.discovered = true;
    }
    public Location(String name, Location[] passages, Entity[] entities) {
        this.name=name; this.passages=passages;
        this.entities = entities;

        locations.add(this);
        this.discovered = true;
    }

    public ArrayList<Action> getActions() {
        ArrayList<Action> actions = new ArrayList<>();
        for (int i=0;i<this.entities.length;i++) {
            if (entities[i].isAlive()) {
                actions.addAll(entities[i].getActions());
            }
        }

        return actions;
    }

    public String toString() {
        return this.name;
    }   
}