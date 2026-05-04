package lab.lab.Sem2.lab7_1;

/**
 * A PacMan object is used to create any character in the PacMan series of
 * games, including Ms. PacMan and the ghosts.
 */
public class PacMan {
  private String name = null;
  private Direction facing = null;
  private int speed = -1;

  /**
   * Constructs a PacMan object by initializing instance variables.
   * 
   * @param name   the name of this character in the PacMan series of games
   * @param facing the direction this character is facing
   * @param speed  the speed of this character
   */
  public PacMan(String name, Direction facing, int speed) {
    this.name = name;
    this.facing = facing;
    this.speed = speed;
  }

  /**
   * Returns the name of this character.
   * 
   * @return the name of this character
   */
  public String getName() {
    return name;
  }

  /**
   * Sets the name of this character.
   * 
   * @param name the name of this character
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Returns the direction of this character.
   * 
   * @return the direction of this character
   */
  public Direction getFacing() {
    return facing;
  }

  /**
   * Sets the direction of this character.
   * 
   * @param facing the direction this character is facing
   */
  public void setFacing(Direction facing) {
    this.facing = facing;
  }

  /**
   * Returns the speed of this character.
   * 
   * @return the speed of this character
   */
  public int getSpeed() {
    return speed;
  }

  /**
   * Sets the speed of this character.
   * 
   * @param speed the speed of this character
   */
  public void setSpeed(int speed) {
    this.speed = speed;
  }

  /**
   * Returns a string containing the name, direction, and speed of this character.
   * 
   * @return a string representation of the object
   */
  public String toString() {
    return name + ", facing " + facing + ", at speed " + speed;
  }

}