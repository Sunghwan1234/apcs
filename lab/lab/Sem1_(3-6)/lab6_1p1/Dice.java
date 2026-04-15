package lab6_1p1;

import java.util.Scanner;

/** 
 * Dice objects can be rolled and picked.
 */
public class Dice {
  // instance variables
  private int numSides = -1;
  private int faceValue = -1;
  private boolean picked = true;
  
  /**
   * Default constructor initializes number of sides to 6, the face value to 1, and
   * sets status to unpicked.
   */
  public Dice() {
    numSides = 6; 
    faceValue = 1;
    picked = false;
  }
  
  /**
   * Overloaded constructor initializes number of sides to parameter (initiates while 
   * loop to repeatedly ask user for input if parameter is greater than 100 or less than 4),
   * the face value to 1, and sets status to unpicked.
   */
  public Dice(int numSides) {
    Scanner userInput = new Scanner(System.in);
    while (numSides > 100 || numSides < 4) {
      System.out.println("Oops.  Choose a number of sides for your die from 4 to 100.");
      numSides = userInput.nextInt();
    }
    this.numSides = numSides;
    faceValue = 1;
    picked = false;
  }
  
  /**
   * Returns number on the die.
   *
   * @return  the value that is face up on the die
   */
  public int getFaceValue() {
    return faceValue;
  }
  
  /**
   * Returns true if the die is picked (saved to be counted in scoring); false otherwise.
   *
   * @return  true if the die is picked;
   *          false otherwise
   */
  public boolean getStatus() {
    return picked;
  }
  
  /** 
   * Changes the status of the die to true.
   */
  public void pick() {
    picked=true;
  } 
  
  /**
   * Changes the status of the die to false.
   */
  public void unpick() {
    picked=false;
  }
  
  /**
   * Changes the number on the die to a random integer 
   * between 1 and the number of sides of the die.
   */
  public void roll() {
    faceValue=(int)(Math.random()*numSides+1);
  }
    
}
