package labSb;

/**
 * ScoreboardTester contains a main method to test Scoreboard objects.
 * 
 * The tester constructs Scoreboard objects, invokes the recordPlay 
 * method, and prints the results via the getScore method.
 */
public class ScoreboardTester {
  public static void main(String[] args) {
    Scoreboard game = new Scoreboard("Red", "Blue");
    System.out.println(game.getScore());
    game.recordPlay(1);
    System.out.println(game.getScore());
    game.recordPlay(0);
    System.out.println(game.getScore());
    System.out.println(game.getScore());
    game.recordPlay(3);
    System.out.println(game.getScore());
    game.recordPlay(1);
    game.recordPlay(0);
    System.out.println(game.getScore());
    game.recordPlay(0);
    game.recordPlay(4);
    game.recordPlay(0);
    System.out.println(game.getScore());
    Scoreboard match = new Scoreboard("Lions", "Tigers");
    System.out.println(match.getScore());
    System.out.println(game.getScore());
  }
}