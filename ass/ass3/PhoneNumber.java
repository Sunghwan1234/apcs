
import java.util.Scanner;
import java.lang.Math;

/*
The first number must not be a 0
The fourth number must not be a 0 or a 1
The first three numbers must not contain 8s or 9s
 */
public class PhoneNumber {

    public static void main(String[] args) {
        String rnum = "";
        for (int i = 0; i < 10; i++) {
            rnum += Integer.toString((int) Math.floor(Math.random() * 10));
        }
        while ((rnum.charAt(0) == 0 || rnum.charAt(3) == 0 || rnum.charAt(4) == 1 || rnum.substring(0, 3).contains("8") || rnum.substring(0, 3).contains("9"))) {
            rnum = "";
            for (int i = 0; i < 10; i++) {
                rnum += Integer.toString((int) Math.floor(Math.random() * 10));
            }

            pl(rnum);
            pl((rnum.charAt(4) == 0) ? "TRUE" : "FALSE");
        }
        pl(rnum);
        pl(rnum.substring(0, 3) + "-" + rnum.substring(3, 6) + "-" + rnum.substring(6, 10));

        //String[] out = {String.valueOf((Math.random())*1000)};
    }

    public static double dist(double[] p1, double[] p2) {
        return Math.sqrt(Math.pow(p2[0] - p1[0], 2) + Math.pow(p2[1] - p1[1], 2));
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
