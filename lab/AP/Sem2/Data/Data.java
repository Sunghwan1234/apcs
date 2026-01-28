package AP.Sem2.Data;

/**
 * Data contains contains methods that repopulate and analyze two-dimensional
 * arrays.
 */
public class Data {
  public final int MAX;
  private int[][] grid;

  /**
   * Initializes MAX and instantiates grid.
   * Not included in the original AP question.
   * 
   * @param MAX  the maximum value of any element in grid
   * @param rows the number of rows in grid
   * @param cols the number of columns in grid
   */
  public Data(int MAX, int rows, int cols) {
    this.MAX = MAX;
    grid = new int[rows][cols];
  }

  /**
   * Initializes MAX and instantiates grid.
   * Not included in the original AP question.
   * 
   * @param MAX  the maximum value of any element in grid
   * @param grid the initial values of grid
   */
  public Data(int MAX, int[][] grid) {
    this.MAX = MAX;
    this.grid = grid;
  }

  /**
   * Fills all elements of grid with randomly generated values, as described in
   * part (a).
   * Preconditions: grid is not null.
   *                grid has at least one element.
   */
  public void repopulate() 
  {
    for (int row=0;row<grid.length;row++) {
      for (int col=0;col<grid[row].length;col++) {
        int i=0;
        while (i%100==0) {
          i=(int)(Math.random()*(MAX/10)+1)*10;
        }
        grid[row][col] = i;
      }
    }
  }


  /**
   * Returns the number of columns in grid that are in increasing order, as
   * described in part (b).
   * Preconditions: grid is not null.
   *                grid has at least one element.
   * 
   * @return the number of columns in grid that are increasing
   */
  public int countIncreasingCols() 
  {
    int incCols = 0;
    for (int col=0;col<grid[0].length;col++) {
      incCols++;
      for (int row=0;row<grid.length-1;row++) {
        if (grid[row][col]>grid[row+1][col]) {
          incCols--;
          break;
        }
      }
    }
    return incCols;
  }

  
  /**
   * Returns a string representation of the object.
   * Not included in the original AP question.
   * 
   * @return a string representation of grid
   */
  public String toString() {
    String output = "";
    for (int[] row : grid) {
      for (int item : row) {
        output += item + "\t";
      }
      output += "\n";
    }
    return output;
  }

}