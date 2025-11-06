import java.util.Scanner;
import java.lang.Math;

/*
The first number must not be a 0
The fourth number must not be a 0 or a 1
The first three numbers must not contain 8s or 9s
*/

public class GuessNumber {
    public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      // guessing game
      int number = (int)(Math.random()*3+1); // number from 1 to 3
      int guess = 0;
      System.out.println("Guess a number from 1 to 3");
      guess = scanner.nextInt();
      if (guess == number) {
        System.out.println("You guessed right!");
      } else {
        if (guess < number) {
          System.out.println("You guessed low! The number was " + number);
        } else if (guess > number) {
          System.out.println("You guessed high! The number was " + number);
        } else {
          System.out.println("You guessed wrong! The number was " + number);
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