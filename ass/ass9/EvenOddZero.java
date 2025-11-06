import java.util.Scanner; // Sunghwan In
import java.lang.Math;

public class EvenOddZero {
    public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);

      int even=0; int odd=0; int zero=0;
      
      int num = scanner.nextInt();
      for (int i=0;i<Math.floor(Math.log10(num))+1;i++) {
        int digit = (int) (num/Math.pow(10,i)%10);
        //System.out.println(digit);
        if (digit==0) {
          zero++;
        } else if (digit%2==0) {
          even++;
        } else {
          odd++;
        }
      }
      System.out.print("Odd: "+odd+"\t");
      for (int i=0;i<odd;i++) {
        System.out.print("*");
      }
      System.out.print("\nEven: "+even+"\t");
      for (int i=0;i<even;i++) {
        System.out.print("*");
      }
      System.out.print("\nZero: "+zero+"\t");
      for (int i=0;i<zero;i++) {
        System.out.print("*");
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