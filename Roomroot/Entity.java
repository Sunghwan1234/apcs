package Roomroot;

/** For things that are alive. */
public abstract class Entity implements Thing {
    public Max hp;
    public Max mana;
    public String name;

    public Entity target;

    /** Return HP>0 */
    public boolean isAlive() {
        return hp.v()>0;
    };

    public void damage(int damage) {
        this.hp.dec(damage);
    };

    /** Get a full list of Strings representing the entity's status. */
    abstract String[] getStatus();
    /** Set the target of the entity to another entity. */
    public void setTarget(Entity target) {
        this.target = target;
    };
}
