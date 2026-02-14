package Roomroot;

/** For things that are alive. */
public abstract class Entity implements Thing {
    /** Return HP>0 */
    public abstract boolean isAlive();

    public abstract Max getHP();
    //public abstract void heal(int hp);
    public abstract Max getMP();
    /** Get a full list of Strings representing the entity's status. */
    public abstract String[] getStatus();
    /** Set the target of the entity to another entity. */
    public abstract Entity getTarget();
    public abstract void setTarget(Entity target);

    public abstract String atDeath();
}
