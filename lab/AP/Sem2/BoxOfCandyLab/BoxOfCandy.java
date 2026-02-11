/**
 * A box of candy is comprised of a two-dimensional grid of Candy objects,
 * which may each be null.
 */
public class BoxOfCandy {
  /** box contains at least one row and is initialized in the constructor */
  private Candy[][] box;
  
  /**
   * Instantiates box two-dimensional array.
   * Not included in the original AP question.
   * 
   * @param box the two-dimensional array of Candy objects
   */
  public BoxOfCandy(Candy[][] box) {
    this.box = box;
  }
  
  /**
   * Moves one piece of candy in column col, if necessary and possible, so that
   * the box element in row 0 of column col contains a piece of candy, as
   * described in part (a). Returns false if there is no piece of candy in
   * column col and returns true otherwise.
   * Precondition: col is a valid column index in box.
   * 
   * @param col the column to move candy in
   * @return true if candy is moved; false otherwise
   */
  public boolean moveCandyToFirstRow(int col) 
  {
    if (box[0][col]!=null) {return true;}
    for (int row=1;row<box.length;row++) {
      if (box[row][col]!=null) {
        box[0][col]=box[row][col];
        box[row][col]=null;
        return true;
      }
    }
    return false;
  }
  
  
  /**
   * Removes from box and returns a piece of candy with flavor specified by the
   * parameter, or returns null if no such piece is found, as described in part (b).
   * 
   * @param flavor the flavor of candy to be removed
   * @return true if candy is removed; false otherwise
   */
  public Candy removeNextByFlavor(String flavor)
  {
    for (int row=box.length-1;row>=0;row--) {
      for (int col=0;col<box[row].length;col++) {
        if (box[row][col]!=null) {
          if (box[row][col].getFlavor()==flavor) {
            Candy candy = box[row][col];
            box[row][col] = null;
            return candy;
          }
        }
      }
    }
    return null;
  }
  
  
}