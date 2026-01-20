package AP.NumberCube;

/**
 * NumberCubeTester contains a main method to test two other class methods
 * involving number cubes.
 * 
 * The main method constructs a NumberCube object, invokes the getCubeTosses and
 * getLongestRun methods, and prints the results.
 */
public class NumberCubeTester {
  /**
   * Returns an array of the values obtained by tossing a number cube numTosses
   * times.
   * Precondition: numTosses > 0
   * 
   * @param cube      a numberCube
   * @param numTosses the number of tosses to be recorded
   * @return an array of numTosses values
   */
  public static int[] getCubeTosses(NumberCube cube, int numTosses) 
  {
    int[] array = new int[numTosses];

    for (int i=0; i<numTosses; i++) {
      array[i] = cube.toss();
    }

    return array;
  }


  /**
   * Returns the starting index of a longest run of two or more consecutive
   * repeated values in the array values.
   * Precondition: values.length > 0
   * 
   * @param values an array of integer values representing a series of number cube
   *               tosses
   * @return the starting index of a run of maximum size;
   *         -1 if there is no run
   */
  public static int getLongestRun(int[] values) 
  {
    int longestIndex = -1;
    int index = -1;
    int currentRunLen = 1;
    int longestRunLen = 1;

    int lastNum = 0;
    for (int i=0;i<values.length;i++) { 

      //System.out.print(":: "+values[i]);

      if (values[i] == lastNum) { // Same as last
        
        currentRunLen++;
        if (currentRunLen>longestRunLen) {
          longestRunLen=currentRunLen;
          longestIndex=index;
        }

        //System.out.print(" !: "+currentRunLen);

      } else {
        currentRunLen=1;
        index = i;
      }
      lastNum = values[i];
      //System.out.println();


      // for (int i=0;i<values.length;i++) { // This is one way to do it but inefficient.
      //   if (values[i] == values[i+1]) {
      //     longestRun++;
      //     //unfinished
      //   }
      // }
    }

    return longestIndex;
  }

  
  public static void main(String[] args) {
    // tests the getCubeTosses method
    NumberCube myCube = new NumberCube();
    int[] randomResult = getCubeTosses(myCube, 10);
    // prints the result of getCubeTosses method
    for (int i = 0; i < randomResult.length; i++) {
      System.out.print(randomResult[i] + ", ");
    }

    // tests the getLongestRun method and prints the results
    int[] exampleResult = { 1, 5, 5, 4, 3, 1, 2, 2, 2, 2, 6, 1, 3, 3, 5, 5, 5, 5 };
    System.out.println("\n" + getLongestRun(exampleResult)); // Should return 6 or 14

    int[] otherResult1 = { 1, 2, 3 };
    System.out.println(getLongestRun(otherResult1)); // Should return -1

    int[] otherResult2 = { 1, 2, 3, 3 };
    System.out.println(getLongestRun(otherResult2)); // Should return 2
  }

}
