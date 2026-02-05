package lab.AP.Sem2.Successors;

/**
 * SuccessorsTester contains a main method to test a Successors object.
 * 
 * The tester creates a 2D array, invokes the findPosition and getSuccessorArray
 * methods on this array, and prints the results.
 */
public class SuccessorsTester {
  public static void main(String[] args) {
    int[][] twoDArray = {{15, 5, 9, 10},
                         {12, 16, 11, 6},
                         {14, 8, 13, 7}};
     
    // tests findPosition method
    Position pos1 = Successors.findPosition(8, twoDArray);
    System.out.println(pos1);
    
    Position pos2 = Successors.findPosition(17, twoDArray);
    System.out.println(pos2 + "\n");
    
    // tests gestSuccessorArray method
    Position[][] twoDSuccessorArray = Successors.getSuccessorArray(twoDArray);
    
    // prints successor array
    for (int row = 0; row < twoDArray.length; row++) {
      for (int col = 0; col < twoDArray[0].length; col++) {
        System.out.print(twoDSuccessorArray[row][col] + "\t");
      }
      System.out.println();
    }
  }
}