package lab.AP.Sem2.ArrayTesterP2;

/**
 * ArrayTesterDriver contains a main method to test an ArrayTester object.
 * 
 * The driver constructs a variety of two-dimensional arrays, invokes the
 * static methods getColumn and isLatin on these arrays, and prints the results.
 */
public class ArrayTesterDriver {
  public static void main(String[] args) {
    int[][] arr2D = {{0, 1, 2},
                     {3, 4, 5},
                     {6, 7, 8},
                     {9, 5, 3}};
    int[] result = ArrayTester.getColumn(arr2D, 1);
    
    for (int i = 0; i < result.length; i++) {
      System.out.print(result[i] + ", ");
    }
    
    int[][] arr2D2 = {{1, 2, 3},
                      {2, 3, 1},
                      {3, 1, 2}};
    
    int[][] arr2D3 = {{10, 30, 20,  0},
                      { 0, 20, 30, 10},
                      {30,  0, 10, 20},
                      {20, 10,  0, 30}};
    
    int[][] arr2D4 = {{1, 2, 1},
                      {2, 1, 1},
                      {1, 1, 2}};
    
    int[][] arr2D5 = {{1, 2, 3},
                      {3, 1, 2},
                      {7, 8, 9}};
    
    int[][] arr2D6 = {{1, 2},
                      {1, 2}};
    
    System.out.println("\n" + ArrayTester.isLatin(arr2D2));
    System.out.println(ArrayTester.isLatin(arr2D3));
    System.out.println(ArrayTester.isLatin(arr2D4));
    System.out.println(ArrayTester.isLatin(arr2D5));
    System.out.println(ArrayTester.isLatin(arr2D6));
  }
}