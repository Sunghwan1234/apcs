package note4_2p2;

/**
 * DogTester contains a main method to test a Dog object.
 * 
 * The tester constructs two Dog objects, invokes the bark, isPuppy,
 * feed, and toString methods, and prints the results.
 */
public class DogTester {
  public static void main(String[] args) {
    Dog myDog = new Dog();
    myDog.bark();
    int totalPuppies = 0;
    int totalFullGrownDogs = 0;
    if (myDog.isPuppy()) {
      totalPuppies++;
    } else {
      totalFullGrownDogs++;
    }
    System.out.println(myDog + "\n");
    
    Dog yourDog = new Dog("Labrador", 6, 70, "yellow", "Spot");
    yourDog.feed(4);
    if (yourDog.isPuppy()) {
      totalPuppies++;
    } else {
      totalFullGrownDogs++;
    }
    System.out.println(yourDog);
    
    System.out.println("\nThe total number of puppies is " + totalPuppies);
    System.out.println("The total number of full grown dogs is " + totalFullGrownDogs);
  }
}
