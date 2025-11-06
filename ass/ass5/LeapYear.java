import java.util.Scanner;
import java.lang.Math;

public class LeapYear {
    public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      
      int year = (int)askD(scanner,"Input: ");
      if (year<1582) {
        pl("Year must be 1582 or later.");
      } else if (year%4==0 && (!(year%100==0) || year%400==0)) {
        pl(year+" is a leap year.");
      } else {
        pl(year+" is not a leap year.");
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