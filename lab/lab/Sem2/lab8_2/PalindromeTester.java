package lab.lab.Sem2.lab8_2;

import java.util.Scanner;

/**
 * This class contains a main method to test to see if a word is a palindrome.
 */
public class PalindromeTester {
  public static void main(String args[]) {
    Scanner userInput = new Scanner(System.in);
    String methodType = "";
    
    while (!methodType.equals("quit")) {
      System.out.println("\nType \"boolean\" to check using the method that returns a boolean,");
      System.out.println("\"void\" to check using the method that returns void,");
      System.out.println("or \"quit\" to quit");
      methodType = userInput.next();
      
      if(methodType.equals("boolean")) {
        System.out.println("Type a word to find out if it is a palindrome.");
        String check = userInput.next();
        if (palindromeBoolean(check)) {
          System.out.println(check + " is a palindrome.");
        } else {
          System.out.println(check + " is not a palindrome.");
        } 
      } else if (methodType.equals("void")) {
        System.out.println("Type a word to find out if it is a palindrome.");
        String check = userInput.next();
        System.out.print(check);
        palindromeVoid(check);
      }
    }
  }
  
  /** 
   * Returns true if word is a palindrome, false otherwise.
   * 
   * @param word  the word to be checked
   * @return      true if word is a palindrome, false otherwise
   */
  public static boolean palindromeBoolean(String word)
  {
    if (word.length()<2) {return true;}
    return word.charAt(0)==word.charAt(word.length()-1) && palindromeBoolean(word.substring(1,word.length()-1));
  }
  
  
  /** 
   * Prints output designating if word is a palindrome.
   * 
   * @param word  the word to be checked
   */
  public static void palindromeVoid(String word)
  {
    if (word.length()<2) {
      System.out.println(" is a palindrome");
      return;
    }
    if (word.charAt(0)==word.charAt(word.length()-1)) {
      palindromeVoid(word.substring(1,word.length()-1));
    } else {
      System.out.println(" is not a palindrome");
    }
  }
  
  
}