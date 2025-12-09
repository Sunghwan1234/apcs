public class Location {
    public static ArrayList<Location> locations = new ArrayList<>();


    public String name;
    public Location[] passages;
    public boolean discovered = false;
    public boolean locked = false;

    public Entity[] entities;

    public Location() {
        String[] sl = {""};
        this.name = "";
        for (int i=0;i<Math.random()*5;i++) {
            this.name += sl[(int) (Math.random()*(sl.length-1))];
        }
    }
    public Location(String name, Location[] passages) {
        this.name=name; this.passages=passages;

        locations.add(this);
        this.discovered = true;
    }
    public Location(String name, Location passages, Entity[] entities) {
        Location(name,passages);
        this.entities = entities;
    }

    public String toString() {
        return this.name;
    }   
}