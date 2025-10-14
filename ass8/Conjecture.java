import java.util.Scanner;
import java.lang.Math;

public class Conjecture {
    public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      long i = -1;
      int steps = 0;
      while (i!=0) {
        System.out.print("Pick a number >1, 0 will exit : ");
        while (i<0) {
          i = scanner.nextLong();
        }
        if (i==0) {break;}
        while (i>1) {
          System.out.print(i+" ");
          if (i%2==0) {
            i = i/2;
          } else {
            i = 3*i+1;
          }
          
          steps++;
        }
        System.out.print(i+" ");
        System.out.println("\nStepped "+steps+" times.");
        i = -1;
      }
      System.out.println("\nClosing.");
      scanner.close();
      return;
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