/**
 * A character can change its name, stamina, strength, current room, and may die.
 */
public interface Character {
  // Though not used in this example, this is how you can declare a constant in an interface.
  public static final int K = 1000;
  
  // The following abstract methods MUST be implemented in any class that implements (uses) this interface.
  
  /**
   * Initializes or revises name.
   * 
   * @param newName  the new name
   */
  public void setName(String newName);
  
  /**
   * Returns the name.
   * 
   * @return  the name
   */
  public String getName();
  
  
  /**
   * Adds an amount of stamina.
   * 
   * @param addition  the amount of stamina to be added
   * @return          the total amount of stamina
   */
  public int addStamina(int addition);
  
  /**
   * Decreases an amount of stamina.
   * 
   * @param deletion  the amount of stamina to be removed
   * @return          the total amount of stamina
   */
  public int decreaseStamina(int deletion);
  
  /**
   * Returns the current amount of stamina.
   * 
   * @return  the current amount of stamina
   */
  public int getStamina();
  
  
  /**
   * Adds an amount of strength.
   * 
   * @param addition  the amount of strength to be added
   * @return          the total amount of strength
   */
  public int addStrength(int addition);
  
  /**
   * Decreases an amount of strength.
   * 
   * @param deletion  the amount of strength to be removed
   * @return          the total amount of strength
   */
  public int decreaseStrength(int deletion);
  
  /**
   * Returns the current amount of strength.
   * 
   * @return  the current amount of strength
   */
  public int getStrength();
  
  
  /**
   * Sets the character's current room.
   * 
   * @param newCurrentRoom  the revised current room
   */
  public void setCurrentRoom(int newCurrentRoom);
  
  /**
   * Returns the character's current room.
   * 
   * @return  the character''s current room
   */
  public int getCurrentRoom();
  
  
  /**
   * Returns whether the character is dead or alive.
   * 
   * @return  true if the character is dead;
   *          false otherwise
   */
  public boolean isDead();
  
  /**
   * Sets the character's living status.
   * 
   * @param dead  true if the character is dead;
   *              false otherwise
   */
  public void setDead(boolean dead);
  
}