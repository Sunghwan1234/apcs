package Roomroot;

public class Monsters {
    public static final Monster
    GOBLIN = new Monster("Goblin", 3, 10, 0, 5),
    BULLY_GOBLIN = new Monster("Bully Goblin", 5, 10, 0 ,5),
    TROLL = new Monster("Troll", 7, 10, 0, 5),
    ORC = new Monster("Orc", 10, 100, 0, 25)
    ;
    public static final Monster[] monsters = {
        GOBLIN,
        BULLY_GOBLIN,
        TROLL,
        ORC
    };
}
