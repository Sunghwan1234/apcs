import java.util.Scanner;
import java.lang.Math;

/*
The first number must not be a 0
The fourth number must not be a 0 or a 1
The first three numbers must not contain 8s or 9s
*/

public class DoubleFlip {
    public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      
      boolean[] flips = {Math.random() < 0.5, Math.random() < 0.5}; // false is tails, true is heads

      System.out.println("Guess the coin flips! (0 for tails, 1 for heads). Guess two times: ");
      int guess1 = scanner.nextInt();
      System.out.println("Second guess: ");
      int guess2 = scanner.nextInt();
      boolean[] guesses = {guess1 == 1, guess2 == 1};
      if (guess1 != 0 && guess1 != 1) {
        pl("First guess invalid, must be 0 or 1");
      } else if (guess2 != 0 && guess2 != 1) {
        pl("Second guess invalid, must be 0 or 1");
      } else {
        if (flips[0] == guesses[0] && flips[1] == guesses[1]) {
            pl("You guessed both right!");
        } else if (flips[0] == guesses[0]) {
            pl("You guessed only the first right!");
        } else if (flips[1] == guesses[1]) {
            pl("You guessed only the second right!");
        } else {
            pl("You guessed both wrong!");
        }
      }
      


      scanner.close();
    }
    public static double dist(double[] p1,double[] p2) {
      return Math.sqrt(Math.pow(p2[0]-p1[0],2)+Math.pow(p2[1]-p1[1],2));
    }
    public static void pl(String p) {
      System.out.println(p);
    }
    public static void printOut(String[] out) {
      for (int i = 0; i < out.length; i++) {
            System.out.println(out[i]);
        }
    }
    public static String ask(Scanner scanner, String askString) {
      System.out.print(askString);
      String out = scanner.next();
      System.out.println();
      return out;
    }
    public static double askD(Scanner scanner, String ask) {
      System.out.print(ask);
      double out = scanner.nextDouble();
      System.out.println();
      return out;
    }
}