package AP.FrogSimulation;

/**
 * FrogSimulationTester contains a main method to test a number of frog simulations.
 * 
 * The tester constructs a FrogSimulation object, invokes the simulate method,
 * and prints the results.
 */
public class FrogSimulationTester {
  public static void main(String[] args) {
    FrogSimulation sim = new FrogSimulation(1000, 100);
    // To test siumulate method with examples from the lab directions, enter
    // a number 1-5 when asked for the example to simulate.
    //System.out.println(sim.simulate());
    
    // To test runSiumlations method, uncomment the following line, and 
    // enter "6" when asked for the example to simulate.
    System.out.println("Winning Ratio: "+sim.runSimulations(1000));
  }
}