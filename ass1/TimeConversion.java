import java.util.Scanner;

public class TimeConversion {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Seconds: ");
        int userIn = scanner.nextInt();

        int secs = userIn % 60 ;
        int mins = (int) (Math.floor(userIn / 60) % 60);
        int hrs = (int) (Math.floor(userIn / 3600));

        String[] inp = {
          "There are ! hours, @ minutes, and # seconds in $ seconds."
        };
        String[][] replacers = {
          {"!", hrs + ""}, {"@", mins + ""},
          {"#", secs + ""}, {"$", userIn + ""}
        };
        String[] out = new String[inp.length];

        for (int i = 0; i < inp.length; i++) {
          out[i] = inp[i];
          
          for (int j = 0; j < replacers.length; j++) {
            out[i] = out[i].replace(replacers[j][0],replacers[j][1]);
            System.out.println(out[i]);
          }
        }

        System.out.println();
        for (int i = 0; i < out.length; i++) {
            System.out.println(out[i]);
        }
    }
}