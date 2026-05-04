package lab.lab.Sem2.lab7_1;

/**
 * Direction used for all PacMan characters.
 */
public enum Direction {
     UP(), DOWN(), LEFT(), RIGHT();
    
    Direction opposite;
    Direction(){}

    static {
        UP.opposite=DOWN;
        DOWN.opposite=UP;
        LEFT.opposite=RIGHT;
        RIGHT.opposite=LEFT;
    }
}