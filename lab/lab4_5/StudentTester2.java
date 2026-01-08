package lab4_5;

/**
 * StudentTester2 contains a main method to test a Student object that
 * has an Address object as an instance variable.
 * 
 * The tester constructs Address and Student objects, and prints the results
 * via the Student toString method.
 */
public class StudentTester2 {
  public static void main(String[] args) {
    // tests Address constructor
    Address myAddress = new Address("123 Main St", "Rochester", "MN", 55904);
    
    // tests Student constructor
    Student myStudent = new Student("Bob Hope", 11, 3.87, 6, "bhope@rochesterschools.org", myAddress);
    
    // tests toString method
    System.out.println(myStudent); 
  }
}
