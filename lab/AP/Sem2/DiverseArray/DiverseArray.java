/**
 * DiverseArray contains three static methods to evaluate 1D and 2D arrays.
 */
public class DiverseArray {
  /**
   * Returns the sum of the entries in the one-dimensional array arr.
   * 
   * @param arr the 1D array to be evalutated
   * @return the sum of the entries in the one-dimensional array arr
   */
  public static int arraySum(int[] arr) 
  {
    int sum=0;
    for (int i : arr) {sum+=i;}
    return sum;
  }
  
  
  /** 
   * Returns a one-dimensional array in which the entry at index k is the sum of
   * the entries of row k of the two-dimensional array arr2D.
   * 
   * @param arr2D the 2D array to be evaluated
   * @return a 1D array containing the sums of each row of param
   */
  public static int[] rowSums(int[][] arr2D)
  {
    int[] sums = new int[arr2D.length];
    for (int row=0;row<arr2D.length;row++) {
      sums[row] = arraySum(arr2D[row]);
    }
    return sums;
  }
  
  
  /**
   * Determines if a 2D array is diverse. It is diverse if and only if each row
   * has a different sum.
   * 
   * @param arr2d the 2D array to be evaluated
   * @return true  if all rows in arr2D have different row sums;
   *         false otherwise
   */
  public static boolean isDiverse(int[][] arr2D)
  {
    int[] sums = rowSums(arr2D);
    for (int i=0;i<sums.length;i++) {
      for (int n=0;n<sums.length;n++) {
        if (i!=n&&sums[i]==sums[n]) {
          return false;
        }
      }
    }
    return true;
  }
  
  
}