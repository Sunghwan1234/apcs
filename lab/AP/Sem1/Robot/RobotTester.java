package AP.Robot;

/**
 * RobotTester contains a main method to test a Robot object.
 * 
 * The tester constructs a Robot object, invokes the clearHall
 * method, and prints the results.
 */
public class RobotTester {
  public static void main(String[] args) {
    int[] jetsonsHall = {1, 1, 2, 2};
    Robot Rosie = new Robot(jetsonsHall, 1, true);
    System.out.println(Rosie.clearHall());
  }
}
