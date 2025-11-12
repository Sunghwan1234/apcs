package lab.CombinedTable;

/**
 * A single table is comprised of a number of seats at this table, the height of this table,
 * and a decimal rating of the view from this table.
 */
public class SingleTable {
  private int numSeats = 0;
  private int height = 0;
  private double viewQuality = 0.0;
  
  /**
   * Constructs a single table with a given number of seats, table height, and a rating of the
   * view from this table.
   * Not included in the original AP question.
   * 
   * @param theNumSeats     the number of seats at this table
   * @param theHeight       the height of this table in centimeters
   * @param theViewQuality  a decimal rating of the view from this table
   */
  public SingleTable (int theNumSeats, int theHeight, double theViewQuality) {
    numSeats = theNumSeats;
    height = theHeight;
    viewQuality = theViewQuality;
  }
  
  /**
   * Returns the number of seats at this table.  The value is alwayes greater than or equal to 4.
   * Not implemented in the original AP question.
   * 
   * @return  the number of seats at this table
   */
  public int getNumSeats() {
    return numSeats;
  }
  
  /**
   * Returns the height of this table in centimeters.
   * Not implemented in the original AP question.
   *
   * @return  the height of this table in centimeters
   */
  public int getHeight() {
    return height;
  }
  
  /**
   * Returns the quality of the view from this table.
   * Not implemented in the original AP question.
   * 
   * @return  a decimal rating of the view from this table
   */
  public double getViewQuality() {
    return viewQuality;
  }
  
  /**
   * Sets the quality of the view from this table to value.
   * Not implemented in the original AP question.
   * 
   * @param value  the new rating of the view from this table
   */
  public void setViewQuality(double value) {
    viewQuality = value;
  }
}
