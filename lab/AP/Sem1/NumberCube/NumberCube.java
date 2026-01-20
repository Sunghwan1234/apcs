package AP.NumberCube;

/**
 * A number cube can be tossed to obtain a face value of 1 to 6.
 */
public class NumberCube {
  /**
   * Returns a face value of 1 to 6.
   * Not implemented in the original AP question.
   * 
   * @return  an integer value between 1 and 6, inclusive
   */
  public int toss() {
    return (int) (Math.random() * 6 + 1);
  }
  
}
