package lab.lab.Sem2.lab7_ABC;

/**
 * DeckeTester contains a main method to test a Deck object.
 * 
 * The tester constructs a Deck object, invokes the deal, toString, and isEmpty
 * methods, and prints the results.
 */
public class DeckTester {
  public static void main(String[] args) {
    String[] ranks = {"A", "B", "C"};
    String[] suits = {"Giraffes", "Lions"};
    int[] pointValues = {2, 1, 6};
    Deck myDeck = new Deck(ranks, suits, pointValues);
    System.out.println(myDeck + "\n--------------------------------\n");
    
    // deals one card
    myDeck.deal();
    System.out.println(myDeck + "\n--------------------------------\n");
    
    // deals remaining five cards
    while (!myDeck.isEmpty()) {
      System.out.println(myDeck.deal());
    }
    System.out.println(myDeck + "\n--------------------------------\n");
    
    // attempts to deal a card from an empty deck
    System.out.println(myDeck.deal());
  }
  
}