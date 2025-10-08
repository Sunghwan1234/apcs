import java.util.Scanner;
import java.lang.Math;

public class LessSmartTest {
    public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);

      int q1 = askI(scanner,"1+1=");
      int q2 = askI(scanner,"!(8^(2/3))=");
      int correct=0;
      if (q1==2) {
        correct+=1;
      }
      if (q2==24) {
        correct+=2;
      }
      String[] grades = {"D","C","B","A"};
      pl(grades[correct]);

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