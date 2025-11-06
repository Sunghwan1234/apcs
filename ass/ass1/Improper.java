import java.util.Scanner;

public class Improper {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Top of a fraction: ");
        int top = scanner.nextInt();
        System.out.print("Bottom of a fraction: ");
        int bottom = scanner.nextInt();

        int num = top / bottom;
        int fractionTop = top % bottom;

        String[] inp = {
          "##/@@ = $$ %%/@@"
        };
        String[][] replacers = {
          {"##", top + ""}, {"@@", bottom + ""},
          {"$$", num + ""}, {"%%", fractionTop + ""}
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