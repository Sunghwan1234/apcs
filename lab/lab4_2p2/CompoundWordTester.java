package lab.lab4_2p2;

/**
 * CompoundWordTester contains a main method to test a CompoundWord object.
 * 
 * The tester constructs a CompoundWord, invokes the findTotalLength,
 * swapWords, setFirstWord, setSecondWord, and toString methods, and
 * prints the results.
 */
public class CompoundWordTester {
  public static void main(String[] args) {
    CompoundWord myWord = new CompoundWord("hot", "dog");
    System.out.println("The length of this compound word is " + myWord.findTotalLength());
    System.out.println(myWord + "\n");
    
    myWord.swapWords();
    System.out.println(myWord + "\n");
    
    myWord.set2("house");
    System.out.println(myWord + "\n");
    
    myWord.set1(myWord.get2());
    System.out.println("The length of this compound word is " + myWord.findTotalLength());
    System.out.println(myWord);
  }
  
}
