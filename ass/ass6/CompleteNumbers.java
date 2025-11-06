import java.util.Scanner;
import java.lang.Math;

public class CompleteNumbers {
    public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);

      int input = askI(scanner,"Input: ");
      int[] digits = new int[3];
      boolean[] even = new boolean[3];
      int countEven=0;
      int countOdd=0;
      for (int i=0;i<3;i++) {
        digits[i]=(input/(int)Math.pow(10,2-i))%10;
        even[i]=digits[i]%2==0;
        if (even[i]) {
          countEven+=1;
        } else {
          countOdd+=1;
        }
      }

      System.out.println(digits[0]+" "+digits[1]+" "+digits[2]);
      if (even[2]) {
        if (countEven==3) {
          pl(input+" is completely even");
        } else if (countEven==2) {
          pl(input+" is partially even");
        } else {
          pl(input+" is simply even");
        }
      } else {
        if (countOdd==3) {
          pl(input+" is completely odd");
        } else if (countOdd==2) {
          pl(input+" is partially odd");
        } else {
          pl(input+" is simply odd");
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