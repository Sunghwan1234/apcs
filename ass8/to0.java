import java.util.Scanner;
import java.lang.Math;

public class To0 {
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
        /*
         * abcd
         * a=i%1000
         * rep l/2
         * 0000 += d*1000 c*100 b*10 a
         * dcba
         * 
         * oh shet i searched it up and ts is NOT it
         * whatever
         */
        while (i>1 && steps<100) {
          long b = 0;
          int l = (int) Math.ceil(Math.log10(i)+0.001);
          for (int j = 1; j < l+1; j++) {
            b += (i%Math.pow(10,j)-i%Math.pow(10,j-1))/Math.pow(10,j-1) * Math.pow(10,l-j);
          }
          System.out.println(i+"-"+b+"="+Math.abs(i-b));
          i = Math.abs(i-b);
          steps++;
        }
        if (steps>=100) {
          System.out.println("Too many steps, stopping.");
        } else {
          System.out.println("\nStepped "+steps+" times.");
        }
        steps = 0;
        i=-1;
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