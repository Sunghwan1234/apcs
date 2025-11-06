import java.util.Scanner;

public class Triangle {

    public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      double[][] points = new double[3][2];
      points[0][0] = askD(scanner, "Point1 x = ");
      points[0][1] = askD(scanner, "Point1 y = ");
      points[1][0] = askD(scanner, "Point2 x = ");
      points[1][1] = askD(scanner, "Point2 y = ");
      System.out.println("Distance = "+(Math.sqrt(Math.pow(points[1][0]-points[0][0],2)+Math.pow(points[1][1]-points[1][1],2))));
      points[2][0] = askD(scanner, "Point3 x = ");
      points[2][1] = askD(scanner, "Point3 y = ");
      System.out.println("Distance of p1-3 = "+dist(points[0],points[2]));
      System.out.println("Distance of p2-3 = "+dist(points[1],points[2]));
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
    public static double askD(Scanner scanner, String ask) {
      System.out.print(ask);
      double out = scanner.nextDouble();
      System.out.println();
      return out;
    }
}