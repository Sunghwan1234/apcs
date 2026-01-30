package lab.AP.Sem2.SumOrSame;

/**
 * A game that involves
 */
public class SumOrSameGame {
  private int[][] puzzle = null;

  /**
   * Creates a two-dimensional array and fills it with example integers,
   * to be used to test results.
   * Not included in the original AP question.
   * 
   * @param puzzle the sample (test) puzzle
   */
  public SumOrSameGame(int[][] puzzle) {
    this.puzzle = puzzle;
  }

  /**
   * Creates a two-dimensional array and fills it with random integers,
   * as described in part (a).
   * 
   * @param numRows the number of rows in this game
   * @param numCols the number of columns in this game
   *                Precondition: numRows > 0; numCols > 0
   */
  public SumOrSameGame(int numRows, int numCols) 
  {
    puzzle = new int[numRows][numCols];
    for (int r=0;r<puzzle.length;r++) {
      for (int c=0;c<puzzle[r].length;c++) {
        puzzle[r][c]=(int)(Math.random()*9+1);
      }
    }
  }


  /**
   * Identifies and clears an element of puzzle that can be paired with
   * the element at the given row and column, as described in part (b).
   * 
   * @param row the row of the element to be compared with
   * @param col the column of the element to be compared with
   *            Preconditions: row and col are valid row and column indices in
   *            puzzle.
   *            The element at the given row and column is between 1 and 9,
   *            inclusive.
   * @return true if a comparable element has been found,
   *         false otherwise.
   */
  public boolean clearPair(int row, int col) 
  {
    int match = puzzle[row][col];
    for (int r=row;r<puzzle.length;r++) {
      for (int c=0;c<puzzle[r].length;c++) {
        if ((match==puzzle[r][c] || match+puzzle[r][c]==10)) {
          puzzle[row][col]=0;
          puzzle[r][c]=0;
          return true;
        }
      }
    }
    return false;
  }


  /**
   * Returns a string illustrating the values of the puzzle in grid form.
   * Not included in the original AP question.
   * 
   * @return a string representation of the object
   */
  public String toString() {
    String output = "";
    for (int[] row : puzzle) {
      for (int item : row) {
        output += item + "\t";
      }
      output += "\n";
    }
    return output;
  }

}