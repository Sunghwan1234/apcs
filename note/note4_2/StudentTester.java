
/**
 * StudentTester contains a main method to test a Student object.
 * 
 * The tester constructs a Student object, invokes the addClass, getClasses, getEnergy,
 * dropClass, advanceGrade, getGrade, getName, getGpa, getClasses, getEmail, and
 * toString methods, and prints the results.
 */
public class StudentTester {
  public static void main(String[] args) {
    Student bob = new Student("Bob Hope", 11, 3.87, 6, "1234567@rochesterschools.org");  // tests constructor
    
    // tests addClass, getClasses, and getEnergy methods
    bob.addClass(1); 
    System.out.println("Number of classes: " + bob.getClasses() + ", Energy: " + bob.getEnergy());
    
    // tests dropClass, getClasses, and getEnergy methods
    bob.dropClass(1); 
    System.out.println("\nNumber of classes: " + bob.getClasses() + ", Energy: " + bob.getEnergy());
    
    // tests advanceGrade, getGrae, and getEnergy methods
    bob.advanceGrade(); 
    System.out.println("\nGrade level: " + bob.getGrade() + ", Energy: " + bob.getEnergy());
    
    // tests accessor methods
    System.out.println("\n" + bob.getName());
    System.out.println(bob.getGrade());
    System.out.println(bob.getGpa());
    System.out.println(bob.getClasses());
    System.out.println(bob.getEmail());
    System.out.println(bob.getEnergy());
    
    System.out.println("\n" + bob); // tests toString method
  }
}