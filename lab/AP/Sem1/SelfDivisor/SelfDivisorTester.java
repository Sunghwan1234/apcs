package AP.SelfDivisor;
/**
 * SelfDivisorTester contains a main method to test SelfDivisor class methods.
 * 
 * The tester invokes the isSelfDivisor and firstNumSelfDivisors methods, and
 * prints the results.
 */
public class SelfDivisorTester {
  public static void main(String[] args) {
    System.out.println(SelfDivisor.isSelfDivisor(128));
    System.out.println(SelfDivisor.isSelfDivisor(26) + "\n");
    
    int[] test0 = SelfDivisor.firstNumSelfDivisors(10, 3);
    for (int i = 0; i < test0.length; i++) {
      System.out.print(test0[i] + " ");
    }
    System.out.println();
    
    int[] test1 = SelfDivisor.firstNumSelfDivisors(20, 4);
    for (int i = 0; i < test1.length; i++) {
      System.out.print(test1[i] + " ");
    }
  }
}
