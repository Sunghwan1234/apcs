/**
 * TwoCoins contains a main method to test two Coin objects.
 * 
 * The tester constructs two Coin objects, flips both of them,
 * and prints the results by invoking the flip and isHeads, and toString methods.
 */
public class TwoCoins {
  public static void main(String[] args) {
    // creates two Coin objects
    Coin myCoin1 = new Coin("heads"); 
    Coin myCoin2 = new Coin("tails"); 
    
    // flips both Coin objects and prints the results
    myCoin1.flip();
    myCoin2.flip();
    System.out.println("T/F: myCoin1 is heads.  Answer: " + myCoin1.isHeads());
    System.out.println("T/F: myCoin2 is heads.  Answer: " + myCoin2.isHeads());
    
    // flips both Coin objects again and prints the results
    myCoin1.flip();
    myCoin2.flip();
    System.out.println("\nAfter flip,");
    System.out.println("T/F: myCoin1 is heads. Answer: " + myCoin1.toString()); // invokes the toString method directly
    System.out.println("T/F: myCoin2 is heads. Answer: " + myCoin2); // invokes the toString method indirectly
  }
}