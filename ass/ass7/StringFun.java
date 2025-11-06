import java.util.Scanner;
import java.lang.Math;

public class StringFun {
    public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      String input="enter";
      while (input.length()>0) {
        System.out.print("Input: ");
        input = scanner.nextLine();
        for (int i = 0; i<input.length(); i++) {
          for (int j = 0; j<i; j++) {
            System.out.print(" ");
          }
          pl(input.substring(i,i+1));
        }
        for (int i = input.length()-1;i>=0;i--) {
          for (int j = 0; j<i; j++) {
            System.out.print(" ");
          }
          pl(input.substring(i,i+1));
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
      String out = scanner.nextLine();
      System.out.println();
      return out;
    }
    public static int askI(Scanner scanner, String ask) {
      System.out.print(ask);
      int out = scanner.nextInt();
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