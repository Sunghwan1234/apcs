package AP.HiddenWord;

/**
 * HiddenWordTester contains a main method to test a HiddenWord object.
 *
 * The tester constructs a new HiddenWord object, repeatedly invokes the
 * getHint method, and prints the results.
 */
public class HiddenWordTester {
  public static void main(String[] args) {
    HiddenWord puzzle1 = new HiddenWord("HARPS");
    System.out.println(puzzle1.getHint("AAAAA"));
    System.out.println(puzzle1.getHint("HELLO"));
    System.out.println(puzzle1.getHint("HEART"));
    System.out.println(puzzle1.getHint("HARMS"));
    System.out.println(puzzle1.getHint("HARPS"));
    
    HiddenWord puzzle2 = new HiddenWord("ICEBERG");
    System.out.println("\n" + puzzle2.getHint("vacancy"));
    System.out.println(puzzle2.getHint("rabbits"));
    System.out.println(puzzle2.getHint("cabbage"));
    System.out.println(puzzle2.getHint("iceberg"));
  }
}
