package AP.sign;

/**
 * SignTester contains a main method to test Sign objects.
 * 
 * The tester constructs multiple Sign objects, invokes the 
 * numberOfLines and getLines methods, and prints the results.
 */
public class SignTester {
  public static void main(String[] args) {
    Sign exampleOne = new Sign("Everything on sale, please come in", 15); 
    System.out.println("Example 1 number of lines: " + exampleOne.numberOfLines());
    System.out.println("Example 1 get lines: " + exampleOne.getLines());
    
    Sign exampleTwo = new Sign("Everything on sale, please come in", 17);
    System.out.println("\nExample 2 number of lines: " + exampleTwo.numberOfLines());
    System.out.println("Example 2 get lines: " + exampleTwo.getLines());
    
    Sign exampleThree = new Sign("Everything on sale, please come in", 40);
    System.out.println("\nExample 3 number of lines: " + exampleThree.numberOfLines());
    System.out.println("Example 3 get lines: " + exampleThree.getLines());    
    
    String str;
    int x;
    Sign sign1 = new Sign("ABC222DE", 3);
    x = sign1.numberOfLines();
    System.out.println("\nTable example sign1\nx: " + x);
    str = sign1.getLines();
    System.out.println("str: " + str);
    str = sign1.getLines();
    System.out.println("str: " + str);
    
    Sign sign2 = new Sign("ABCD", 10);
    x = sign2.numberOfLines();
    System.out.println("\nTable example sign2\nx: " + x);
    str = sign2.getLines();
    System.out.println("str: " + str);
    
    Sign sign3 = new Sign("ABCDEF", 6);
    x = sign3.numberOfLines();
    System.out.println("\nTable example sign3\nx: " + x);
    str = sign3.getLines();
    System.out.println("str: " + str);
    
    Sign sign4 = new Sign("", 4);
    x = sign4.numberOfLines();
    System.out.println("\nTable example sign4\nx: " + x);
    str = sign4.getLines();
    System.out.println("str: " + str);
    
    Sign sign5 = new Sign("AB_CD_EF", 2);
    x = sign5.numberOfLines();
    System.out.println("\nTable example sign5\nx: " + x);
    str = sign5.getLines();
    System.out.println("str: " + str);
  }
}
