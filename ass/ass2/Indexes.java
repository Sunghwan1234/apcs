import java.util.Scanner;

public class Indexes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input: ");
        String userIn = scanner.next();

        System.out.print("First word: ");
        String firstWord = scanner.next();

        System.out.print("Second word: ");
        String secondWord = scanner.next();

        int firstIndex = userIn.indexOf(firstWord);
        int secondIndex = userIn.indexOf(secondWord);

        System.out.println("The index of first word is "+firstIndex+", not "+(firstIndex+1));
        System.out.println("The index of second word is "+secondIndex+", not "+(secondIndex+1));
        System.out.println("The length of the input is "+userIn.length());
        System.out.println("The combined length of the words are "+(firstWord.length()+secondWord.length()));
    }
}