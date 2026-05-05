package lab.lab.Sem2.lab7_ABC;

import java.util.List;
import java.util.ArrayList;

/** 
 * The Deck class represents a shuffled deck of cards.
 * It provides several operations, including initialize, shuffle, deal, and check if empty.
 */
public class Deck {
  
  /** cards contains all the cards in the deck.
    */
  private List<Card> allCards = null;
  
  /** size is the number of not-yet-dealt cards.
    * Cards are dealt from the top (highest index) down.
    * The next card to be dealt is at size - 1.
    */
  private int numUndealtCards = 0;
  
  
  /** 
   * Creates a new <code>Deck</code> instance.
   * Instantiates allCards instance variable as an ArrayList of Card objects.
   * Pairs each element of ranks with each element of suits, constructs one of the corresponding card,
   *    and adds it to allCards.
   * Sets numUndealtCards.
   * Shuffles cards.
   *
   * @param ranks is an array containing all of the card ranks
   * @param suits is an array containing all of the card suits
   * @param values is an array containing all of the card point values
   */
  public Deck(String[] ranks, String[] suits, int[] values) {
    allCards = new ArrayList<Card>();
    for (String suit : suits) {
      for (int i=0;i<ranks.length;i++) {
        allCards.add(new Card(ranks[i],suit,values[i]));
      }
    }
    numUndealtCards=allCards.size();

    // shuffle();
  }
  
  
  /**
   * Determines if this deck is empty (no undealt cards).
   * 
   * @return true if this deck is empty, false otherwise
   */
  public boolean isEmpty() {
    return numUndealtCards==0;
  }
  
  
  /** 
   * Accesses the number of undealt cards in this deck.
   * 
   * @return the number of undealt cards in this deck
   */
  public int getNumUndealtCards() {
    return numUndealtCards;
  }
  
  
  /** 
   * Randomly permutes the given collection of cards and resets the size to represent the entire deck.
   */
  public void shuffle() {
    /* *** TO BE IMPLEMENTED IN 7.D LAB *** */
  }
  
  
  /** 
   * Deals a card from this deck.
   * 
   * @return the card just dealt, or null if all the cards have been previously dealt.
   */
  public Card deal() {
    if (numUndealtCards==0) {numUndealtCards--;return null;}
    return allCards.get(--numUndealtCards);
  }
  
  
  /** 
   * Generates and returns a string representation of this deck.
   * 
   * @return a string representation of this deck
   */
  @Override
  public String toString() {
    String output = "Number of undealt cards = " + numUndealtCards + "\nUndealt cards: \n";
    
    for (int k = numUndealtCards - 1; k >= 0; k--) {
      output = output + allCards.get(k);
      if (k != 0) {
        output = output + ", ";
      }
      if ((numUndealtCards - k) % 2 == 0) {
        // Insert carriage returns so entire deck is visible on console
        output = output + "\n";
      }
    }
    
    output = output + "\nDealt cards: \n";
    for (int k = allCards.size() - 1; k >= numUndealtCards; k--) {
      output = output + allCards.get(k);
      if (k != numUndealtCards) {
        output = output + ", ";
      }
      if ((k - allCards.size()) % 2 == 0) {
        // inserts carriage returns so entire deck is visible on console
        output = output + "\n";
      }
    }
    
    output = output + "\n";
    return output;
  }
  
}