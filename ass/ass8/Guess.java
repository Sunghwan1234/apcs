import java.util.Scanner;
import java.lang.Math;

public class Guess {
    public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      int i = 0;
      System.out.println("high bound >0");
      while (i<=0) {
        i = scanner.nextInt();
      }
      System.out.println("low bound <0");
      int l = 0;
      while (l>=0) {
        l = scanner.nextInt();
      } 
      int r = (int) (Math.random()*(i-l+1)+l);
      System.out.println("guess between "+l+" and "+i);
      i = 0;
        int g=0;
      while (!(i==r)) {
        i = scanner.nextInt();
        if (i>r) {
          System.out.println("high");
        } else if (i<r) {
          System.out.println("low");
        }
        g+=1;
      }
      System.out.println("Took you "+g);

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