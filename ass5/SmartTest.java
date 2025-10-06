import java.util.Scanner;
import java.lang.Math;

public class SmartTest {
    public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);

      int points = 0;
      int a1 = askI(scanner,"4x-5=2x+7 , x="); // 2

      if (a1==2) {
        points+=1;
        int a2 = askI(scanner,"3(x-2)+4=10 , x="); // 0
        if (a2==0) {
          points+=3;
        } else {
          points-=3;
        }
      } else {
        points-=1;
      }
      double a3 = askD(scanner,"(Use 3.14) Area of a Circle with radius 4 = "); // 50.24
      if (Math.abs(a3-50.24)<0.01) {
        points+=3;
      } else {
        points-=3;
        int a4 = askI(scanner,"Area of a Rectangle with length 4 and width 6 = "); // 24
        if (a4==24) {
          points+=1;
        } else {
          points-=1;
        }
      }
      
      if (points>=0) {
        int a5 = askI(scanner,"Length of hypotenuse of a right triangle with legs 3 and 4 = "); // 5
        if (a5==5) {
          points+=2;
          double a6 = askD(scanner,"Length of Short side of a right triangle with hypotenuse length 6 and angle of 60  = "); // 3
          if (a6==3) {
            points+=4;
          } else {
            points-=4;
          }
        } else {
          points-=2;
        }
      }
      pl("Final points: "+points);

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