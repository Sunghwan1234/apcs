package Roomroot;

import java.util.ArrayList;

/** All rooms in the game Roomroot. */
public class Location implements Thing {
    public static ArrayList<Location> map = new ArrayList<>();


    public String name;
    public ArrayList<Location> passages;
    public boolean discovered = false;
    public boolean locked = false;
    public boolean visible = true;

    public Entity[] entities;

    public Location() {
        map.add(this);

        String[] sl = {"ale","nuo","bel","cao","bnu","pho","ghi","ard","fri","sni","gho","who","cru","jan","las","vei","kos","qou","zma","xil","yni","fud"};
        int r = (int)(Math.random()*3+2);
        this.name = "";
        for (int i=0;i<r;i++) {
            this.name += sl[(int) (Math.random()*(sl.length-1))];
        }
        this.name = this.name.substring(0,1).toUpperCase()+this.name.substring(1);

        int passageCount = (int)(Math.random()*3+1);
        passages = new ArrayList<>();
        for (int i=0;i<passageCount;i++) {
            if (Math.random()<0.3 && map.size()>0) {
                Location Existingloc = map.get((int) (Math.random()*map.size()));
                passages.add(Existingloc);
                if (Math.random()<0.9) {
                    Existingloc.passages.add(this);
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
        if (Math.random()<0.1) {
            this.visible=false;
        }
    }
    

    public ArrayList<String> getDescription() {
        ArrayList<String> things = new ArrayList<>();

        int passageCount=0; int lockedCount=0;
        for (int i=0;i<passages.size();i++) {
            if (passages.get(i).visible) {
                if (passages.get(i).locked) {
                    lockedCount++;
                } else {
                    passageCount++;
                }
            }
        }
        things.add("There are "+passageCount+" passages from here.");
        if (lockedCount>0) {
            things.add("There are also "+lockedCount+" locked passages.");
        }
        

        return things;
    }

    public ArrayList<Action> getActions() {
        ArrayList<Action> actions = new ArrayList<>();

        for (int i=0;i<passages.size();i++) {
            if (passages.get(i).visible && !passages.get(i).locked) {
                actions.add(new Action(passages.get(i)));
            }
        }



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