package lab.AP.Sem2.Crossword;

/**
 * A crossword contains black and white squares with some white squares
 * following a numbering system.
 */
public class Crossword {
  /**
   * Each element is a Square object with a color(black or white) and a number.
   * puzzle[r][c] represents the square in row r, column c.
   * There is at least one row in the puzzle.
   */
  private Square[][] puzzle = null;

  /**
   * Constructs a crossword puzzle grid.
   * Precondition: There is at least one row in blackSquares
   * Postcondition:
   * - The crossword puzzle grid has the same dimensions as blackSquares
   * - The Square object at row r, column c in the crossword puzzle grid is black
   *   if and only if blackSquares[r][c] is true
   * - The squares in the puzzle are labeled according to the crossword labeling
   *   rule
   * 
   * @param blackSquares the 2D array of elements to determine if the
   *                     corresponding puzzle element is also black
   */
  public Crossword(boolean[][] blackSquares) 
  {
    this.puzzle = new Square[blackSquares.length][blackSquares[0].length];
    int n=1;
    for (int row=0;row<puzzle.length;row++) {
      for (int col=0;col<puzzle[row].length;col++) {
        if (toBeLabeled(row, col, blackSquares)) {
          puzzle[row][col] = new Square(blackSquares[row][col], n);
          n++;
        } else {
          puzzle[row][col] = new Square(blackSquares[row][col], 0);
        }
      }
    }
  }


  /**
   * Implements the crossword puzzle numbering system.
   * The square at row r, column c is black if and only if blackSquares[r][c]
   * is true.
   * Precondition: r and c are valid indexes in blackSquares.
   * 
   * @param r            the row to be labeled
   * @param c            the column to be labeled
   * @param blacksquares the 2D array containing corresponding elements that are
   *                     black
   * @return true if the square at row r, column c should be labeled with a
   *         positive number; false otherwise.
   */
  private boolean toBeLabeled(int r, int c, boolean[][] blackSquares)
  {
    return !blackSquares[r][c]&&(r==0||blackSquares[r-1][c]||c==0||blackSquares[r][c-1]);
  }

  /**
   * Returns the puzzle.
   * Not included in the original AP question.
   *
   * @return this puzzle
   */
  public Square[][] getPuzzle() {
    return puzzle;
  }

}