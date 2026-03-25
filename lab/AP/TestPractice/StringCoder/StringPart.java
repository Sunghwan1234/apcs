package lab.AP.TestPractice.StringCoder;

/**
 * A string part is represented by the starting index and the length of the string
 */
public class StringPart {
  /** The starting position of the substring in the master string. */
  private int startPosition = -1;
  /** The length of the substring in a master string. */
  private int length = -1;
  
  /** 
   * Constructs a StringPart object by storing params as instance variables.
   * Not implemented in the original AP question.
   * 
   * @param start   the starting position of the substring in a master string.
   * @param length  the length of the substring in a master string.
   */
  public StringPart(int start, int length) {
    startPosition = start;
    this.length = length;
  }
  
  /** 
   * Returns the starting positino of the substring in a master string.
   * Not implemented in the original AP question.
   * 
   * @return  the starting position of the substring in a master string
   */
  public int getStart() {
    return startPosition;
  }
  
  /** 
   * Returns the length of the substring in a master string.
   * Not implemented in the original AP question.
   * 
   * @return  the length of the substring in a master string
   */
  public int getLength() {
    return length;
  }
  
  /** 
   * Returns a string representation of the object.
   * Not included in the original AP question.
   * 
   * @return  a string representation of the object
   */
  public String toString() {
    return "" + startPosition + ", " + length;
  }
  
}