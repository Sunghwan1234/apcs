import java.util.Scanner;

public class FtoCTemp {
  public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      
      System.out.print("Input F: ");
      double fDeg = scanner.nextDouble();
      
      double cDeg = (fDeg-32)/1.8;

      System.out.println();
      System.out.println("    ## Degrees Farenheit\n        is equal to\n    $$ Degrees Celsius".replace("##", ""+fDeg).replace("$$",""+cDeg));
  }
}