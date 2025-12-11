package AP.Trio;
/**
 * TrioTester contains a main method to test Trio objects.
 * 
 * The tester constructs and fills two Trio objects, invokes the getName and getPrice
 * methods, and prints the results.
 */
public class TrioTester {
  public static void main(String[] args) {
    Sandwich cheeseburger = new Sandwich("Cheeseburger", 2.75);
    Sandwich clubSandwich = new Sandwich("Club Sandwich", 2.75);
    Salad spinachSalad = new Salad("Spinach Salad", 1.25);
    Salad coleslaw = new Salad("Coleslaw", 1.25);
    Drink orangeSoda = new Drink("Orange Soda", 1.25);
    Drink cappuccino = new Drink("Cappuccino", 3.5);
    
    // Tests constructor - should compile
    Trio trio1 = new Trio(cheeseburger, spinachSalad, orangeSoda);
    Trio trio2 = new Trio(clubSandwich, coleslaw, cappuccino);
    
    // Tests constructor - should NOT compile - comment out to run
   //Trio badTrio1 = new Trio(spinachSalad, cheeseburger, orangeSoda); // Compile-time error
    //rio badTrio2 = new Trio(cheeseburger, spinachSalad, coleslaw); // Compile-time error

    // Tests getName method
    System.out.println(trio1.getName());  // Should be: Cheeseburger/Spinach Salad/Orange Soda Trio
    System.out.println(trio2.getName());  // Should be: Club Sandwich/Coleslaw/Cappuccino Trio
    
    // Tests getPrice method
    System.out.println(trio1.getPrice());  // Should be: 4.0
    System.out.println(trio2.getPrice());  // Should be: 6.25
  }
}
