package AP.TestPractice.RouteCipher;

import java.util.Set;

/**
 * A route cipher fills a 2D array with a message that encrypted.
 */
public class RouteCipher {
  /** 
   * A two-dimensional array of single-character string, instantiated in the 
   * constructor.
   */
  private String[][] letterBlock;
  
  /** The number of rows of letterBlock, set by the constructor. */
  private int numRows;
  
  /** The number of columns of letterBlock, set by the constructor. */
  private int numCols;
  
  /** 
   * Initializes instance variables numRows and numCols.
   * Instantiates letterBlock to rows x cols.
   * Not included in the original AP question.
   * 
   * @param numRows the rows in the two-dimensional array
   * @param numCols the columns in the two-dimensional array
   */
  public RouteCipher(int numRows, int numCols) {
    this.numRows = numRows;
    this.numCols = numCols;
    letterBlock = new String[numRows][numCols];
  }
  
  /** 
   * Places a string into letterBlock in row-major order.
   * Postconditions:
   *   if str.length() < numRows * numCols, "A" is placed in each unfilled cell
   *   if str.length() > numRows * numCols, trailing characters are ignored]
   * 
   * @param str the string to be processed
   */
  public void fillBlock(String str)
  {
    int c = 0;
    for (int row=0;row<numRows;row++) {
      for (int col=0;col<numCols;col++) {
        if ((c!=str.length())) {
          letterBlock[row][col] = str.substring(c,c+1);
          c++;
        } else {
          letterBlock[row][col] = "A";
        }
      }
    }
    System.err.println(toString());
  }
  
  
  /** 
   * Extracts encrypted string from letterBlock in column-major order.
   * Precondition: letterBlock has been filled
   * Not implemented in the original AP question.
   * 
   * @return the encrypted string from letterBlock
   */
  private String encryptBlock() {  
    String output =  "";
    for (int col = 0; col < letterBlock[0].length; col++) {
      for (int row = 0; row < letterBlock.length; row++) {
        output += letterBlock[row][col];
      }
    }
    return output;
  }
  
  /** 
   * Encrypts a message.
   * 
   * @param message the string to be encrypted
   * @return the encrypted message;
   *         if message is the empty string, returns the empty string
   */
  public String encryptMessage(String message)
  {
    if (message.equals("")) {return "";}
    String s = "";
    for (int i=0;i<=Math.ceil(message.length()/(numRows*numCols));i++) {
      fillBlock(message.substring(i*(numRows*numCols),Math.min(message.length(),(i+1)*(numRows*numCols))));
      s+=encryptBlock();
    }
    return s;
  }
  
  
  /** 
   * Returns a string representation of the letterBlock.
   * Not included in the original AP question.
   * 
   * @return a string representation of the object
   */
  public String toString() {
    String output = "";
    for (String[] row : letterBlock) {
      for (String item : row) {
        output += item + "\t";
      }
      output += "\n";
    }
    return output;
  }
}
