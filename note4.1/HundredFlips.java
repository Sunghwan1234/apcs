/**
 * HundredFlips contains a main method to test a Coin object.
 * 
 * The tester constructs a Coin object and flips it NUM_FLIPS
 * times, printing the results by invoking the flip, isHeads,
 * and toString methods.
 */
public class HundredFlips {
  public static void main(String[] args) {
    final int NUM_FLIPS = 100;
    int heads = 0;
    int tails = 0;
    
    // creates the Coin object called myCoin
    Coin myCoin = new Coin("tails"); 
    
    // flips the coin NUM_FLIPS times
    for (int i = 0; i < NUM_FLIPS; i++) {
      myCoin.flip();
      if (myCoin.isHeads()) {
        heads++;
      } else {
        tails++;
      }
    }
    
    // tests the toString method
    System.out.println(myCoin + "\n");
    
    System.out.println("Number of heads: " + heads);
    System.out.println("Number of tails: " + tails);   
  }
}