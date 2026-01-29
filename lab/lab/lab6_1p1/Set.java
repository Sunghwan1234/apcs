package lab6_1p1;

/**
 * A Set is a collection of five dice. Each turn begins with a Set of five Dice.
 * A new Set is generated at the beginning of each turn.
 */
public class Set {
  // instance variable
  private Dice[] allDice = null;
  
  /**
   * Constructs five dice and instantiates and populates array with all five dice.
   */
  public Set() {
    Dice a = new Dice();
    Dice b = new Dice();
    Dice c = new Dice();
    Dice d = new Dice();
    Dice e = new Dice();
    
    Dice[] allDice = {a, b, c, d, e}; // declares, instantiates, and initializes a local array
    this.allDice = allDice; // passes the local array to the instance variable array
  }
  
  /**
   * Returns the die at the given index.
   *
   * @return  the die at the given index
   */
  public Dice getDice(int index) {
    return allDice[index];
  }
  
  /**
   * Sets the status of each dice in this set unpicked (not saved for scoring).
   * Used at the beginning of each turn to put all dice in play.
   * MUST use a for, for-each, or while loop
   */
  public void resetStatus() {
    for (Dice d : allDice) {
      d.unpick();
    }
  }
  
  /**
   * Rolls each of the unpicked (unsaved for scoring) dice in the hand.
   * MUST use a for, for-each, or while loop
   */
  public void roll() {
    for (Dice d : allDice) {
      if (!d.getStatus()) {d.roll();}
    }
  }
  
  /**
   * Returns the total of all five dice.
   * MUST use a for, for-each, or while loop
   * 
   * @return  the total of all dice in this set
   */
  public int total() {
    int total=0;
    for (Dice d : allDice) {
      total+=d.getFaceValue();
    }
    return total;
  } 
  
  /**
   * Returns the face values of all dice in the set.
   * 
   * @return  a string representation of the object
   */
  public String toString() {
    String output = "\nYour roll: ";
    for (Dice item : allDice) {
      output += item.getFaceValue() + ",  ";
    }
    return output;
  }
  
}
