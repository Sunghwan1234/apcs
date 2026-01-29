package lab5;

import java.util.Scanner;

public class LetterMatches {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String word = scanner.nextLine();
    String word2 = scanner.nextLine();

    int matches=0;
    String couplets="";
    for (int c=0;c<word.length()-1;c++) {
      String couplet = word.substring(c,c+2);
      //p(couplet);
      for (int i=0;i<word2.length()-1;i++) {
        if (word2.substring(i,i+2).equals(couplet)) {
          matches++;
          couplets+=couplet+" ";
        }
      }
    }
    System.out.println(matches);
    p(couplets);

    scanner.close();
  }
  public static void p(Object o) {
      System.out.println(o);
  }
}
