import java.util.Scanner; // Sunghwan In
import java.lang.Math;

public class PoemReverse {
    public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);

      String poem = scanner.nextLine();
      int f = poem.length()-1;
      int lastSpace = poem.length();
      String rev = "";
      while (f>=0) {
        if (poem.charAt(f)==' ' || f==0) {
          if (f==0) {
            rev += poem.substring(f,lastSpace)+" ";
          } else {
          rev += poem.substring(f+1,lastSpace)+" ";
        }
          lastSpace = f;
          f--;
        }
        f--;
      }

      
      System.out.println(rev);
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