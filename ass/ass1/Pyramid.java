import java.util.Scanner;

public class Pyramid {
  public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      
      System.out.print("Pyramid Sides: ");
      int sides = scanner.nextInt();
      
      int faces = sides+1;
      int points = sides+1;
      int edges = sides*2;
      
      String[] out = {
        "You input a pyramid with a base of ## sides.".replace("##",""+sides),
        "The computer says, \"This pyramid has $$ faces, @@ edges, and %% vertices.\"".replace("$$",faces+"").replace("@@",edges+"").replace("%%",points+"")
      };

      System.out.println();
      for (int i=0;i<out.length;i++) {
        System.out.println(out[i]);
      }
  }
}