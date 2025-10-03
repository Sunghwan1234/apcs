import java.util.Scanner;

public class Sphere {

    public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      System.out.print("Radius = ");
      double r = scanner.nextDouble();
      System.out.println("Volume = "+(4.0/3.0*r*r*r*3.14159));
      System.out.println("Surface Area = "+(4.0*r*r*3.14159));
      System.out.print("Height = ");
      double h = scanner.nextDouble();
      System.out.println("Volume = "+(r*r*3.14159*h));
      System.out.println("Surface Area = "+(r*r*3.14159*2+2*3.14159*r*h));
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
}