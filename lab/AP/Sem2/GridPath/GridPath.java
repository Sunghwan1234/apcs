package lab.AP.Sem2.GridPath;

/**
 * GridPath contains methods to find the smallest neighbor and to traverse
 * a path through a 2D array.
 */
public class GridPath {
  /** Initialized in the constructor with distinct values that never change */
  private int[][] grid;

  /**
   * Instantiates 2D grid int array.
   * Not included in the original AP question.
   * 
   * @param grid the 2D array
   */
  public GridPath(int[][] grid) {
    this.grid = grid;
  }

  /**
   * Returns the Location representing a neighbor of the grid element at row and
   * col, as described in part (a).
   * Preconditions: row is a valid row index and col is a valid column index in grid.
   *                row and col do not specify the element in the last row and last
   *                    column of grid.
   * 
   * @param row the row to be assessed
   * @param col the column to be assessed
   * @return the Location of the smaller value of the right or lower neighbor,
   *         if it exists.
   */
  public Location getNextLoc(int row, int col)
  {
    if ((col+1>=grid[row].length) || !(row+1>=grid.length) && (grid[row+1][col]<grid[row][col+1])) {
      return new Location(row+1, col);
    } else {
      return new Location(row, col+1);
    }
  }


  /**
   * Computes and returns the sum of all values on a path through grid, as
   * described in part (b).
   * Preconditions: row is a valid row index and col is a valid column index in grid.
   *                row and col do not specify the element in the last row and last
   *                    column of grid.
   * 
   * @param row the row at the start of the path
   * @param col the column at the start of the path
   * @return the sum of the values on the path
   */
  public int sumPath(int row, int col) 
  {
    int sum=0;
    Location cLoc = new Location(row, col);
    while (!(cLoc.getRow()==grid.length-1 && cLoc.getCol()==grid[row].length-1)) {
      sum+=grid[cLoc.getRow()][cLoc.getCol()];
      cLoc=getNextLoc(cLoc.getRow(), cLoc.getCol());
      //System.out.println(">>"+cLoc.getRow()+","+cLoc.getCol());
    }
    return sum+grid[cLoc.getRow()][cLoc.getCol()];
  }

  
}