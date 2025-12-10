package Roomroot;

import java.util.ArrayList;

/** All rooms in the game Roomroot. */
public class Location implements Thing {
    public static ArrayList<Location> map = new ArrayList<>();


    public String name;
    public ArrayList<Location> passages;
    public boolean discovered = false;
    public boolean locked = false;

    public Entity[] entities;

    public Location() {
        String[] sl = {"ale","nuo","bel","cao","bnu","pho","ghi","ard","fri","sni","gho","who","cru","jan","las","vei","kos","qou","zma","xil","yni","fud"};
        this.name = "";
        for (int i=0;i<(int)(Math.random()*3+2);i++) {
            this.name += sl[(int) (Math.random()*(sl.length-1))];
        }
        this.name = this.name.substring(0,1).toUpperCase()+this.name.substring(1);

        passages = new ArrayList<>();
        for (int i=0;i<(int)(Math.random()*3+1);i++) {
            if (Math.random()<0.3 && map.size()>0) {
                Location loc = map.get((int) (Math.random()*map.size()));
                passages.add(loc);
                if (Math.random()<0.9) {
                    loc.passages.add(this);
                }
                continue;
            }
            passages.add(new Location(this));
        }

    }
    /** For creating NEW passage locations. */
    private Location(Location passage) {
        this();
        this.passages.add(passage);
        if (Math.random()<0.1) {
            this.locked=true;
        }
    }
    

    public ArrayList<String> getDescription() {
        ArrayList<String> things = new ArrayList<>();



        return things;
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