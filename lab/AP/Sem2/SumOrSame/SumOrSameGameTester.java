package lab.AP.Sem2.SumOrSame;

/**
 * SumOrSameGameTester contains a main method to test the SumOrSameGame class.
 * 
 * The tester constructs multiple games, invokes the clearPair method, and
 * prints the results.
 */
public class SumOrSameGameTester {
  public static void main(String[] args) {
    // tests part (a)
    SumOrSameGame game1 = new SumOrSameGame(4, 6);
    System.out.println("Tests for part (a)\n" + game1);

    SumOrSameGame game2 = new SumOrSameGame(5, 2);
    System.out.println(game2);

    // tests part (b)
    int[][] puzzle3 = { {0, 7, 9, 0}, {7, 4, 1, 6}, {8, 4, 1, 8} };
    SumOrSameGame game3 = new SumOrSameGame(puzzle3);
    System.out.println("Tests for part (b)\n" + game3.clearPair(0, 1) + "\n" + game3);

    int[][] puzzle4 = { {1, 2, 3, 4}, {5, 6, 7, 8}, {5, 4, 1, 2} };
    SumOrSameGame game4 = new SumOrSameGame(puzzle4);
    System.out.println(game4.clearPair(2, 2) + "\n" + game4);

    int[][] puzzle5 = { {8, 1, 0, 5}, {0, 4, 3, 6}, {3, 4, 5, 8} };
    SumOrSameGame game5 = new SumOrSameGame(puzzle5);
    System.out.println(game5.clearPair(1, 1) + "\n" + game5);

    int[][] puzzle6 = { {1 ,7, 9}, {2, 6, 5}, {4, 4, 4} };
    SumOrSameGame game6 = new SumOrSameGame(puzzle6);
    System.out.println(game6.clearPair(0, 2) + "\n" + game6);
  }
}