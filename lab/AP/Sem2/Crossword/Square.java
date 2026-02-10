package lab.AP.Sem2.Crossword;

/**
 * A square is black or white and has a number.
 */
public class Square {
  private boolean black = false;
  private int num = 0;

  /**
   * Constructs one square of a crossword puzzle grid.
   * Implementation not shown in original AP question.
   * 
   * @param black the state of the color of the square
   * @param num   the number of the square
   * 
   *              Postcondition:
   *              - The square is black if and only if isBlack is true.
   *              - The square has number num.
   */
  public Square(boolean black, int num) {
    this.black = black;
    this.num = num;
  }

  /**
   * Returns true if and only if the square is black.
   * Not included in original AP Question.
   * 
   * @return true if square is black;
   *         false otherwise
   */
  public boolean isBlack() {
    return black;
  }

  /**
   * Returns the numerical value of the square.
   * Not included in the original AP question.
   * 
   * @return the numerical value of the square
   */
  public int getNum() {
    return num;
  }

}