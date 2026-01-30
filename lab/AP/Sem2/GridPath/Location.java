package lab.AP.Sem2.GridPath;

/**
 * A location is comprised of a row and column in a 2D array.
 */
public class Location {
  private int row = 0;
  private int col = 0;

  /**
   * Instantiates row and column of this location.
   * 
   * @param row the row of this location
   * @param col the column of this location
   */
  public Location(int row, int col) {
    this.row = row;
    this.col = col;
  }

  /**
   * Returns the row.
   * 
   * @return the current row
   */
  public int getRow() {
    return row;
  }

  /**
   * Returns the column.
   * 
   * @return the current column
   */
  public int getCol() {
    return col;
  }
}