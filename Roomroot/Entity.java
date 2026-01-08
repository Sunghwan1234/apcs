package Roomroot;

import java.util.ArrayList;

/** For things that are alive. */
public interface Entity extends Thing {

    public boolean isAlive();
    /** Full Status */
    public String[] getStatus();
    public String toString();
}
