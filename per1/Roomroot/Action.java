package Roomroot;

/** Base of all actions. */
public class Action {
    public enum act {
        move,
        damage,
        use
    }

    public act type;

    public Action(act type) {
        this.type = type;
    }

}