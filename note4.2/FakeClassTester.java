/**
 * FakeClassTester contains a main method to test FakeClass objects.
 * 
 * The tester constructs a FakeClass object, attempts to access public and private
 * instance variables, attempts to invoke the getPublicVariable, getPrivateVariable,
 * and saySomething methods, and prints the results.
 */
public class FakeClassTester {
  public static void main(String[] args) {
    // constructs a FakeClass object
    FakeClass myClass = new FakeClass(2, -4);
    
    // attempts to access the public variable
    System.out.println("public variable accessed directly: " + myClass.overt);
    System.out.println("public variable accessed via public method: " + myClass.getPublicVariable() + "\n");
    
    // attempts to access the private variable
//    System.out.println("private variable accessed directly: " + myClass.hidden);
    System.out.println("private variable accessed via public method: " + myClass.getPrivateVariable() + "\n");
    
    // attempts to access the private method
//    myClass.saySomething();
    
    // attempts to access the public method
    myClass.repeatedlySaySomething();
  }
}