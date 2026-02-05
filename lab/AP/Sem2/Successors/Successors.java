package lab.AP.Sem2.Successors;

/**
 * Successors contains static methods that can be used to analyze 2D arrays.
 */
public class Successors {
  /**
   * Returns the position of num in intArr;
   * returns null if no such element exists in intArr.
   * Precondition: intArr contains at least one row.
   * 
   * @param num    the integer to be searched for
   * @param intArr the array to be searched
   */
  public static Position findPosition(int num, int[][] intArr)
  {
    for (int row=0;row<intArr.length;row++) {
      for (int col=0;col<intArr[0].length;col++) {
        if (intArr[row][col]==num) {
          return new Position(row, col);
        }
      }
    }
    return null;
  }


  /**
   * Returns a 2D successor array as described in part (b) constructed
   * from intArr.
   * Precondition: intArr contains at least one row and contains 
   * consecutive values.
   * Each of these integers may be in any position in the 2D array.
   * 
   * @param intArr the array to be converted to a Position array showing the
   *               successor of each element
   */
  public static Position[][] getSuccessorArray(int[][] intArr)
  {
    Position[][] array = new Position[intArr.length][intArr[0].length];
    for (int row=0;row<intArr.length;row++) {
      for (int col=0;col<intArr[0].length;col++) {
        Position succesor = findPosition(intArr[row][col]+1, intArr);
        if (succesor!=null) {
          array[row][col] = succesor;
        } else {
          array[row][col] = null;
        }
      }
    }
    return array;
  }

  
}