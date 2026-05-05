package lab.lab.Sem2.lab7_ABC;

/**
 * CardTester contains a main method to test Card objects.
 * 
 * The tester constructs three Card objects, invokes the getRank,
 * getSuit, getPointValue, toString, and matches methods, and
 * prints the results.
 */
public class CardTester {
  public static void main(String[] args) {
    Card myCard1 = new Card("Ace", "Spades", 1);
    Card myCard2 = new Card("Two", "Hearts", 2);
    Card myCard3 = new Card("Ace", "Spades", 1);
    
    System.out.println(myCard1.getRank());
    System.out.println(myCard1.getSuit());
    System.out.println(myCard1.getPointValue() + "\n");
    
    System.out.println(myCard2 + "\n");
    
    System.out.println(myCard1.matches(myCard2));  // prints/returns false
    System.out.println(myCard1.matches(myCard3));  // prints/returns true
  }
  
}