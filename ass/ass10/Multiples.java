import java.util.Scanner; // Sunghwan In
import java.lang.Math;

public class Multiples {
    public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      while (true) {
        String string = "The numbers that are multiples of ";
        int min = askI(scanner,"Enter the minimum number (-1 to exit): ");
        if (min == -1) {
          break;
        }
        int max = askI(scanner,"Enter the maximum number: ");
        int multiple = askI(scanner,"Enter the multiple: ");
        boolean findMultiple = askI(scanner,"Find multiples? (1 for yes, 0 for no): ") == 1;

        string += multiple + " from " + min + " to " + max + " are ";

        for (int i = min; i <= max; i++) {
          if ((i % multiple == 0) == findMultiple) {
            string += i + " ";
          }
        }
        System.out.println(string);
      }
      

      scanner.close();
    }
    public static int len(int n) {
      return (int)(Math.log10(n)) + 1;
    }
    public static int digit(int n, int digit) {
      return (int)(n/Math.pow(10,digit))%10;
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