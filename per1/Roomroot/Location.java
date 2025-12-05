public class Location {
    public String name;
    public Location[] passages;
    public boolean locked = false;

    public Entity[] entities;

    public Location(String name, Location[] passages) {
        this.name=name; this.passages=passages;
    }
    public Location(String name, Location passages, Entity[] entities) {
        Location(name,passages);
        this.entities = entities;
    }

    
}