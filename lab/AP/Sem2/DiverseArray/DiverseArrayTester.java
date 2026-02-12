/**
 * DiverseArrayTester contains a main method to test a DiverseArray object.
 * 
 * The tester constructs a 1D array, invokes the arraySum method, and prints the result.
 * The tester constructs two 2D arrays, invokes the rowSums and isDiverse methods, 
 * and prints the results.  
 */
public class DiverseArrayTester {
  public static void main(String[] args) {
    int[] oneDArray = {1, 3, 2, 7, 3};
    
    // tests arraySum method
    System.out.println(DiverseArray.arraySum(oneDArray) + "\n");
    
    int[][] twoDArray = {{1,  3,  2,  7,  3},
                         {10, 10, 4,  6,  2},
                         {5,  3,  5,  9,  6},
                         {7,  6,  4,  2,  1}};
    
    // tests rowSums method
    int[] twoDSumArray = DiverseArray.rowSums(twoDArray);
    
    for(int row = 0; row < twoDArray.length; row++) {
        System.out.print(twoDSumArray[row] + "\t");
      }
    
    // tests isDiverse method
    System.out.println("\n\n" + DiverseArray.isDiverse(twoDArray));
    
    int[][] twoDArray2 = {{1,  1 , 5,  3,  4},
                          {12, 7,  6,  1,  9},
                          {8,  11, 10, 2,  5},
                          {3,  2,  3,  0,  6}};
    
    System.out.println("\n" + DiverseArray.isDiverse(twoDArray2));
  }
}