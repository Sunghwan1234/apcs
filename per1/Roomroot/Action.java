package Roomroot;

import java.lang.reflect.Array;
import java.util.ArrayList;

/** Base of all actions. */
public class Action {
    public static final int MOVE=0, ATT=1, USE=2;

    public int type;
    public Object target;

    public String name;

    public Action(int type, Entity target, Entity executer, ArrayList<Object> params) {
        this.type = type;
        this.target = target;

    }
    public Action(Location loc) {
        this.type = Action.MOVE;
        this.target = loc;

        this.name = "Move to "+loc.name;

    }

    public void Execute(Entity executer) {
        switch (this.type) {
            case MOVE:
                if (executer instanceof Player) {
                    ((Player) executer).loc = (Location)this.target;
                }
                break;
        }
    }

    @Override
    public String toString() {
        return this.name;
    }
}