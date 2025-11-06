import java.util.Scanner; // Sunghwan In
import java.lang.Math;

public class MultTable {
    public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      int min = askI(scanner,"Enter the minimum number: ");
      int max = askI(scanner,"Enter the maximum number: ");
      String s = "";
      for (int i=min;i<=max;i++) {
        for (int j=min;j<=max;j++) {
          s += i*j + "\t";
        }
        s += "\n";
      }
      System.out.println(s);
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
      return out;
    }
    public static int askI(Scanner scanner, String ask) {
      System.out.print(ask);
      int out = scanner.nextInt();
      return out;
    }
    public static double askD(Scanner scanner, String ask) {
      System.out.print(ask);
      double out = scanner.nextDouble();
      System.out.println();
      return out;
    }
}