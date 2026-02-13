package Roomroot;

/** For things that are alive. */
public abstract class Entity implements Thing {
    /** Return HP>0 */
    abstract boolean isAlive();

    abstract void damage(int damage);

    /** Get a full list of Strings representing the entity's status. */
    abstract String[] getStatus();
    /** Set the target of the entity to another entity. */
    abstract Entity getTarget();
    abstract void setTarget(Entity target);
}
