package gamelab5_3;

/**
 * A hero is a character who is the protagonist in the game.
 */
public class Hero implements Character, Comparable<Character> {
  // class variable
  private static int totalHeroes = 0;
  
  // instance variables
  private String name = null;
  private int stamina = -1; // Ranges from 0 to 10. If stamina reaches 0, hero dies.
  private int strength = -1; // Ranges from 0 to 10.
  private int currentRoom = -1;
  private boolean isDead = false;
  private String objective = null;
    
  /**
   * Initializes name, stamina, strength, and death status.  Also adds 1 to class
   * variable for total number of heroes.
   *
   * @param name      the name of this hero
   * @param strength  the initial strength of this hero
   */
  public Hero(String name, int strength) {
    this.name = name;
    stamina = 8;
    this.strength = strength;
    isDead = false;
    totalHeroes++;
  }
  
  // The next 12 methods implement the Character interface.  Note that the JavaDoc comments
  // are inherited from the interface and do not need to be rewritten here.
  
  public void setName(String name) {
    this.name = name;
  }
  
  public String getName() {
    return name;
  }
    
  
  public int addStamina(int addition) {
    stamina = stamina + addition;
    if (stamina > 10) {
      stamina = 10;
    }
    return stamina;
  }
  
  public int decreaseStamina(int deletion) {
    stamina = stamina - deletion;
    if (stamina < 0) {
      stamina = 0;
    }
    return stamina;
  }
  
  public int getStamina() {
    return stamina;
  }
  
  
  public int addStrength(int addition) {
    strength = strength + addition;
    if (strength > 10) {
      strength = 10;
    }
    return strength;
  }
  
  public int decreaseStrength(int deletion) {
    strength = strength - deletion;
    if (strength < 0) {
      strength = 0;
    }
    return strength;
  }
  
  public int getStrength() {
    return strength;
  }
  
  
  public void setCurrentRoom(int currentRoom) {
    this.currentRoom = currentRoom;
  }
  
  public int getCurrentRoom() {
    return currentRoom;
  }
  
  
  public boolean isDead() {
    if (stamina == 0) {
      isDead = true;
    }
    return isDead;
  }
  
  public void setDead(boolean x) {
    isDead = x;
  }
  
  // The remaining methods are not required by the Character interface, but distinguish a Hero
  // from other characters.
  
  /**
   * Sets the objective of the game for this hero.
   *
   * @param objective  the objective of the game for this hero
   */
  public void setObjective(String objective) {
    this.objective = objective;
  }
  
  /**
   * Returns the objective of the game.
   * 
   * @return  the objective of the game
   */
  public String getObjective() {
    return objective;
  }
  
  /**
   * Class method returns the total number of heroes.
   * 
   * @return  the total number of heroes
   */
  public static int getTotalHeroes() {
    return totalHeroes;
  }
  @Override
  public int compareTo(Character c) {
    if (this.strength < c.getStrength()) {
        return -1;
    } else if (this.strength == c.getStrength()) {
        return 0;
    } else {
        return 1;
    }
  }
  
}