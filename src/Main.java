import java.util.Scanner;
import java.lang.Math;

/*
The first number must not be a 0
The fourth number must not be a 0 or a 1
The first three numbers must not contain 8s or 9s
*/

public class Main {
    public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      
      double x = askD(scanner,"Input: ");

      double f = x<2?3*x-4:Math.pow(x,2)/2;

      pl("Your coordinates are ("+x+", "+f+")");

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