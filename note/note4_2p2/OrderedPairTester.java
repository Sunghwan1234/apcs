package note4_2p2;

/**
 * OrderedPairTester contains a main method to test an OrderedPair object.
 * 
 * The tester constructs an OrderedPair, invokes the getXCoordinate,
 * setXCoordinate, getYCoordinate, setYCoordinate, findQuadrant,
 * isOnAxis, and toString methods, and prints the results.
 */
public class OrderedPairTester {
  public static void main(String[] args) {
    OrderedPair point1 = new OrderedPair(2.5, -3.4);
    System.out.println("The x-value is " + point1.getXCoordinate());
    System.out.println("The y-value is " + point1.getYCoordinate());
    System.out.println("The quadrant is " + point1.findQuadrant());
    System.out.println("T/F This point is on an axis: " + point1.isOnAxis());
    System.out.println(point1 + "\n"); // Tests toString method
    
    point1.setXCoordinate(-9);
    point1.setYCoordinate(0);
    System.out.println("The quadrant is " + point1.findQuadrant());
    System.out.println("T/F This point is on an axis: " + point1.isOnAxis());
    System.out.println(point1 + "\n");
  }
}