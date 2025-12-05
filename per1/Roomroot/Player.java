
public class Player implements Entity {
    public String name;
    public int hp_max=100; public int hp=100;
    public int mana=100; public int mana_max=100;

    

    public Player(String name) {
        this.name = name;
    }
}