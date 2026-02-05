package lab.AP.Sem2.Successors;

/**
 * A position contains the row and column of an element.
 * The only aspect of this class in the original AP question is the constructor.
 */
public class Position {
  private int row = -1;
  private int col = -1;

  /**
   * Initializes row and column of this position.
   * Not implemented in the original AP question.
   * 
   * @param r the row of the position
   * @param c the column of the position
   */
  public Position(int r, int c) {
    row = r;
    col = c;
  }

  /**
   * Returns the row of this position.
   * 
   * @return the row of this position
   */
  public int getRow() {
    return row;
  }

  /**
   * Returns the column of this position.
   * 
   * @return the column of this position
   */
  public int getCol() {
    return col;
  }

  /**
   * Returns the row and column of this position as a string.
   *
   * @return a string representation of the object
   */
  public String toString() {
    return "(" + row + ", " + col + ")";
  }

}