import java.util.Scanner;

public class Flip {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Input: ");
        String userIn = scanner.next();
        String userFront = userIn.substring(0,userIn.length()/2);
        String userBack = userIn.substring(userIn.length()/2,userIn.length());
        
        String[] out = {
          userBack+userFront
        };
        

        System.out.println();
        for (int i = 0; i < out.length; i++) {
            System.out.println(out[i]);
        }
    }
}