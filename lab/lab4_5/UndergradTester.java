package lab4_5;

/**
 * UnderGradTester contains a main method to test UnderGrad objects.
 * 
 * The tester constructs four Undergrad objects, invokes the getName,
 * calculateAverage, addTest, and toString methods, and prints the results.
 */
public class UndergradTester {
  public static void main(String[] args) {
    Undergrad student1 = new Undergrad("Goldy"); // Tests constructor with one parameter
    System.out.println(student1.getName() + "'s average: " + student1.calculateAverage()); // Tests calculateAverage method
    student1.addTest(95); // Tests addTest method
    System.out.println(student1.getName() + "'s average: " + student1.calculateAverage() + "\n"); // Tests calculateAverage method
    
    Undergrad student2 = new Undergrad("Bucky", 85); // Tests constructor with two parameters
    System.out.println(student2.getName() + "'s average: " + student2.calculateAverage()); // Tests calculateAverage method
    student2.addTest(98); // Tests addTest method
    System.out.println(student2.getName() + "'s average: " + student2.calculateAverage() + "\n"); // Tests calculateAverage method
    
    Undergrad student3 = new Undergrad("Thundar", 88, 94); // Tests constructor with three parameters
    System.out.println(student3.getName() + "'s average: " + student3.calculateAverage()); // Tests calculateAverage method
    student3.addTest(95); // Tests addTest method
    System.out.println(student3.getName() + "'s average: " + student3.calculateAverage() + "\n"); // Tests calculateAverage method
    
    Undergrad student4 = new Undergrad("Sparty", 98, 88, 92); // Tests constructor with four parameters
    System.out.println(student4.getName() + "'s average: " + student4.calculateAverage()); // Tests calculateAverage method
    student4.addTest(100); // Tests addTest method
    System.out.println(student4.getName() + "'s average: " + student4.calculateAverage() + "\n"); // Tests calculateAverage method
    
    System.out.println(student4); // Tests toString method
  }
}
