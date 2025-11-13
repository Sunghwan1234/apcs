package lab.lab4_5;

/**
 * AddressTester contains a main method to test an Address object.
 * 
 * The tester constructs an Address object, invokes the getStreet, getCity,
 * getState, getZipCode, setStreet, setCity, setState, setZipCode, and
 * toString methods, and prints the results.
 */
public class AddressTester {
  public static void main (String[] args) {
    // tests constructor
    Address home = new Address("123 Main St.", "Rochester", "MN", 55904);
    
    // tests accessor methods
    System.out.println(home.getStreet());
    System.out.println(home.getCity());
    System.out.println(home.getState());
    System.out.println(home.getZipCode());
    
    // tests mutator methods
    home.setStreet("1600 Pennsylvania Ave. NW");
    home.setCity("Washington");
    home.setState("D.C.");
    home.setZipCode(20500);

    // tests toString method
    System.out.println("\n" + home);
  }
}