import java.util.Scanner;
import java.lang.Math;

public class Insurance {
    public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      
      int age = (int) (Math.random()*(99-16+1))+16;
      int carAccidents = (int) (Math.random()*(10-0+1))+0;
      int creditRating = (int)(Math.random()*(850-300+1))+300;

      if (age<25) {
        pl("This client is a potential risk due to age.");
      }
      if (carAccidents>1) {
        pl("This client is a potential risk due to previous accidents.");
      }
      if (creditRating<500) {
        pl("This client is a potential risk due to credit rating.");
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