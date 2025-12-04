package lab.game;

/**
 * GameTester contains a main method to test the Game class.
 * 
 * The tester constructs a Game object, invokes the getScore and playManyTimes methods,
 * and prints the results.
 */
public class GameTester {
  public static void main(String[] args) {
    Game myGame = new Game();
    for (int i = 0; i < 4; i++) {
      System.out.println("Game " + (i + 1) + ": " + myGame.getScore());
    }
    
    System.out.println("\nHighest score earned (computed scores 75, 50, 90, 20): " + myGame.playManyTimes(4));
  }
}
