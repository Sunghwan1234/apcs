import java.util.Scanner;

public class ReplaceFirst {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = ReplaceFirst.ask(scanner,"Input ");
        String word1 = ReplaceFirst.ask(scanner, "Word 1 ");
        String word2 = ReplaceFirst.ask(scanner, "Word 2 ");

        int wordIndex = input.indexOf(word1);
        String before = input.substring(0,wordIndex);
        String after = input.substring(wordIndex+word1.length(),input.length());

        ReplaceFirst.pl(before+word2+after);


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