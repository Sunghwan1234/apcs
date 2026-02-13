package Roomroot;

import java.util.ArrayList;

/** General interface for all existing things. */
public interface Thing {
    /** Get all actions of this Thing. All Things need actions available, either by themselves or executable by others. */
    public ArrayList<Action> getActions();
}