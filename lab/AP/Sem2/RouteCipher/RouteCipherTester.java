package lab.AP.Sem2.RouteCipher;

/**
 * RouteCipherTester contains a main method to test a RouteCipher object.
 * 
 * The tester creates a new RouteCipher object, invokes the fillBlock and
 * encryptMessage methods, and prints the results.
 */
public class RouteCipherTester {
  public static void main(String[] args) {
    RouteCipher partA = new RouteCipher(3, 5);
    partA.fillBlock("Meet at noon");
    System.out.println(partA);
    
    partA.fillBlock("Meet at midnight");
    System.out.println(partA);
    
    RouteCipher partB = new RouteCipher(2, 3);
    System.out.println(partB.encryptMessage(""));
    
    System.out.println(partB.encryptMessage("Meet at midnight"));
  }
}