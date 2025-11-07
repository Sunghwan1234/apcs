package lab.dogwalker;

/**
 * DogWalkTester contains a main method to test a DogWalker object.
 * 
 * The tester constructs a DogWalker and invokes the walkDogs and dogWalkShift
 * methods, and prints the results.
 */
public class DogWalkerTester {
  public static void main(String[] args) {
    int[] dogs = { 0, 0, 0, 0, 0, 10, 2, 10, 2, 2, 7, 5,
                   6, 9, 4, 3, 10, 4, 6, 7, 3, 2, 1, 0 };
    DogWalkCompany corporate = new DogWalkCompany(dogs);
    DogWalker turner = new DogWalker(3, corporate);

    // Part (a) tests
    System.out.println("10 dogs available at hour 5. Dogs walked: " + turner.walkDogs(5)); // should be 3
    System.out.println("2 dogs available at hour 6. Dogs walked: " + turner.walkDogs(6)); // should be 2

    // Part (b) tests
    System.out.println("\nTotal pay for shift from 7 to 10, inclusive: " + turner.dogWalkShift(7, 10)); // should be 59
  }
}
