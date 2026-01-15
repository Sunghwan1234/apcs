package Roomroot;

import java.util.ArrayList;

/** For things that are alive. */
public interface Entity extends Thing {

    public boolean isAlive();
    /** Get a full list of Strings representing the entity's status. */
    public String[] getStatus();
    public String toString();
    /** Set the target of the entity to another entity. */
    public void setTarget(Entity target);
}
