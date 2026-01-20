package AP.FrogSimulation;

import java.util.Scanner;

/**
 * A frog simulation is comprised of a goal distance and maximum number of hops
 * to reach this distance.
 */
public class FrogSimulation {
  /** Distance, in inches, from the starting position to the goal. */
  private int goalDistance;

  /** Maximum number of hops allowed to reach the goal. */
  private int maxHops;

  // extra variables for implementation of hopDistance method
  private int exampleNum = -1;
  private int randomHopIndex = 0;

  /**
   * Constructs a FrogSimulation where dist is the distance, in inches, from the
   * starting position to the goal, and numHops is the maximum number of hops
   * allowed to reach the goal.
   * Preconditions: dist > 0; numHops > 0
   * 
   * @param dist    the distance, in inches, from the starting position to the
   *                goal
   * @param numHops the maximum number of hops allowed to reach the goal
   */
  public FrogSimulation(int dist, int numHops) {
    goalDistance = dist;
    maxHops = numHops;
  }

  /**
   * Returns an integer representing the distance, in inches, to be moved when the
   * frog hops. Input from the user of 1-5 will recreate the scenarios given in
   * Examples 1-5 in the lab description. Input from the user of 6 or more will
   * randomly generate 1000 hop distances, to be used with the runSimulations
   * method.
   * Not implemented in the original AP question.
   * 
   * @return a integer distance, in inches, of the next hop of the frog
   */
  private int hopDistance() {
    if (exampleNum == -1) {
      Scanner userInput = new Scanner(System.in);
      System.out.println("What example would you like to simulate? (Type a number 1-6.)");
      System.out.print("Examples 1-5 are taken from the lab directions.");
      System.out.println(" Example 6 is for random siumlations.");
      exampleNum = userInput.nextInt();
    }

    int[] example = null;
    if (exampleNum == 1) {
      int[] exampleElements = { 5, 7, -2, 8, 6 };
      example = exampleElements;
    } else if (exampleNum == 2) {
      int[] exampleElements = { 6, 7, 6, 6 };
      example = exampleElements;
    } else if (exampleNum == 3) {
      int[] exampleElements = { 6, -6, 31 };
      example = exampleElements;
    } else if (exampleNum == 4) {
      int[] exampleElements = { 4, 2, -8 };
      example = exampleElements;
    } else if (exampleNum == 5) {
      int[] exampleElements = { 5, 4, 2, 4, 3 };
      example = exampleElements;
    } else {
      int[] exampleElements = new int[400*maxHops];
      for (int i = 0; i < exampleElements.length; i++) {
        exampleElements[i] = (int) (Math.random() * 45 - 10);
      }
      example = exampleElements;
    }

    int output = example[randomHopIndex];
    randomHopIndex = (randomHopIndex+1) % example.length;
    return output;
  }

  /**
   * Simulates a frog attempting to reach the goal as described in part (a).
   * Returns true if the frog successfully reached or passed the goal during the
   *              simulation;
   *         false otherwise.
   * 
   * @return true if the frog has reached or passed the goal;
   *         false otherwise
   */
  public boolean simulate() 
  {
    System.out.println("Started Hopping! Best of luck.");
    int pos=0;
    int hops=0;
    while (!(pos<0 || hops>=maxHops)) {
      int hopDist = hopDistance();
      //System.out.print("Hop "+(hops+1)+": Hopping "+pos+" + "+hopDist+" | ");
      pos+=hopDist;
      if (pos>=goalDistance) {
        System.out.println("Hopping finished in "+(hops+1)+" Hops! "+pos+" >= "+goalDistance);
        return true;
      } else {
        hops++;
      }
    }
    if (pos<0) {
      System.err.println(" Pos ("+pos+") Negative!");
    } else {
      System.err.println("Took too long: "+maxHops+" Hops (Total "+pos+")");
    }
    return false;
  }

  
  /**
   * Runs num simulations and returns the proportion of simulations in which the
   * frog successfully reached or passed the goal.
   * Precondition: num > 0
   * 
   * @param num the number of simulations to run
   * @return the proportion of successful simulations, given as a decimal
   */
  public double runSimulations(int num) 
  {
    System.out.println("Starting Simulation Amount: "+num);
    System.out.println(" Goal "+goalDistance+" | Max "+maxHops);
    boolean[] results = new boolean[num];
    double ratio = 0;
    for (int i=0;i<num;i++) {
      System.out.println("Simulation "+(i+1)+" >>>>>>>>>>>>>>>");
      results[i] = simulate();
      if (results[i]) {ratio++;}
      System.out.println("Finished!! "+(i+1)+" <<<<<<<<<<<<<<< "+results[i]+" << rhi"+randomHopIndex);
    }
    ratio/=num;
    return ratio;
  }


}
