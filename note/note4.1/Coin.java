/**
 * A coin can be flipped to show heads or tails.
 */
public class Coin {
  private String faceValue = null;
  
  /** Constructs a coin object.
    * @param aFaceValue  the initial face value of this coin
    */ 
  public Coin(String aFaceValue) {
    faceValue = aFaceValue;
  }
  
  /** Flips the coin. */
  public void flip() {
    if ((int) (Math.random() * 2) == 0) {
      faceValue = "tails";
    } else {
      faceValue = "heads";
    }
  }
  
  /** Checks to see if faceValue is heads.
    * @return  true if it is heads;
    *          false otherwise
    */
  public boolean isHeads() {
    return faceValue.equals("heads");
  }
  
  /** Returns text depicting the face value of this coin.
    * @return  string representation of the object
    */
  public String toString() {
    return "The coin is " + faceValue + " up.";
  }
}