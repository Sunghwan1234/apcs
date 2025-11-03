package lab4_2p2;

/**
 * NumberPairTester contains a main method to test NumberPair objects.
 * 
 * The tester constructs two NumberPair objects, invokes the isMadeOfInts,
 * calculateArithmeticMean, getNum2(), calculateHypotenuse, and toString
 * methods, and prints the results.
 */
public class NumberPairTester {
  public static void main(String[] args) {
    // tests constructor
    NumberPair pair1 = new NumberPair(-6.5, 12);
    // tests isMadeOfInts method
    System.out.println("This pair is made of ints: " + pair1.isMadeOfInts());
    // tests calculateArithmeticMean method
    System.out.println(pair1.calculateArithmeticMean() + "\n");
    
    // tests constructor
    NumberPair pair2 = new NumberPair(pair1.getNum2(), 5); // gets pair1 num2 for pair2 num1
    // tests isMadeOfInts method
    System.out.println("This pair is made of ints: " + pair2.isMadeOfInts());
    // tests calculateGeometricMean method
    System.out.println(pair2.calculateGeometricMean());
    // tests calculateHypotenuse method
    System.out.println(pair2.calculateHypotenuse() + "\n");
    
    // tests toString method
    System.out.println(pair1 + "\n" + pair2);
  }
  
}
