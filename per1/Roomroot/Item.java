package Roomroot;

import java.util.ArrayList;

public class Item implements Thing {
    
    String name;

    public Item(String name) {
        this.name = name;
    }

    public Item(String name, ArrayList<Action> actions) {
        this.name = name;

    }
    

    @Override
    public ArrayList<Action> getActions() {
        return new ArrayList<>();
    }

    public String toString() {
        return this.name;
    }
}