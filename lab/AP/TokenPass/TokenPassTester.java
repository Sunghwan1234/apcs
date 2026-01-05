package AP.TokenPass;

/**
 * TokenPassTester contains a main method to test a TokenPass object.
 * 
 * The tester constructs a TokenPass object, invokes the getCurrentPlayer,
 * distributeCurrentPlayerTokens, and toString methods, and prints the results.
 */
public class TokenPassTester {
  public static void main(String[] args) {
    // tests initial setup
    TokenPass game1 = new TokenPass(4);
    System.out.println("Current player: " + game1.getCurrentPlayer());
    System.out.println("Initial setup:\n" + game1 + "\n");
    
    // tests distribution of tokens for current player
    game1.distributeCurrentPlayerTokens();
    System.out.print("Distribution of player " + game1.getCurrentPlayer());
    System.out.println("'s tokens:\n" + game1);
  }
}