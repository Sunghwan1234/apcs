package Phrase;

/**
 * PhraseTester contains a main method to test Phrase objects.
 * 
 * The tester constructs five Phrase objects, invokes the replaceNthOccurrence
 * and findLastOccurrence methods, and prints the results, usually via the
 * toString method.
 */
public class PhraseTester {
  public static void main(String[] args) {
    
    Phrase phrase1 = new Phrase("A cat ate late.");
    phrase1.replaceNthOccurrence("at", 1, "rane");
    System.out.println(phrase1);
    
    Phrase phrase2 = new Phrase("A cat ate late.");
    phrase2.replaceNthOccurrence("at", 6, "xx");
    System.out.println(phrase2);
      
    Phrase phrase3 = new Phrase("A cat ate late.");
    phrase3.replaceNthOccurrence("bat", 2, "xx");
    System.out.println(phrase3);
    
    Phrase phrase4 = new Phrase("aaaa");
    phrase4.replaceNthOccurrence("aa", 1, "xx");
    System.out.println(phrase4);
    
    Phrase phrase5 = new Phrase("aaaa");
    phrase5.replaceNthOccurrence("aa", 2, "bbb");
    System.out.println(phrase5 + "\n");
    
    phrase1 = new Phrase("A cat ate late.");
    System.out.println(phrase1.findLastOccurrence("at"));
    System.out.println(phrase1.findLastOccurrence("cat"));
    System.out.println(phrase1.findLastOccurrence("bat"));
  }
}
