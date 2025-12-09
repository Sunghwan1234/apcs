package AP.apline;

/**
 * APLineTester contains a main method to test APLine objects.
 * 
 * The tester constructs two APLine objects, invokes the getSlope, isOnLine, and
 * toString methods, and prints the results.
 */
public class APLineTester {
  public static void main(String[] args) {
    APLine line1 = new APLine(5, 4, -17);
    double slope1 = line1.getSlope(); // slope1 is assigned -1.25
    System.out.println(slope1);
    boolean online1 = line1.isOnLine(5, -2); // true because 5(5) + 4(-2) + (-17) = 0
    System.out.println(online1 + "\n");
    
    APLine line2 = new APLine(-25, 40, 30);
    double slope2 = line2.getSlope(); // slope2 is assigned 0.625
    System.out.println(slope2);
    boolean onLine2 = line2.isOnLine(5, -2); // false because -25(5) + 40(-2) + 30 != 0
    System.out.println(onLine2);
  }
}
