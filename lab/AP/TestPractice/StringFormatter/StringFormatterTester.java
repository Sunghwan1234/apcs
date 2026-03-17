package AP.TestPractice.StringFormatter;

import java.util.ArrayList;

/**
 * StringFormatterTester contains a main method to test static StringFormatter methods.
 * 
 * The tester populates ArrayLists, invokes the format method, and prints the results.
 */
public class StringFormatterTester {
  public static void main(String[] args) {
    int stringLength = 20;
    
    // tests Example 1
    // output should be:"AP  COMP  SCI  ROCKS"
    ArrayList<String> list1 = new ArrayList<>();
    list1.add("AP");
    list1.add("COMP");
    list1.add("SCI");
    list1.add("ROCKS");
    System.out.println(StringFormatter.format(list1, stringLength) + "\n");
    
    // tests Example 2
    // output should be:"GREEN  EGGS  AND HAM"
    ArrayList<String> list2 = new ArrayList<>();
    list2.add("GREEN");
    list2.add("EGGS");
    list2.add("AND");
    list2.add("HAM");
    System.out.println(StringFormatter.format(list2, stringLength) + "\n");
    
    // tests Example 3
    // output should be:"BEACH           BALL" (11 spaces between words)
    ArrayList<String> list3 = new ArrayList<>();
    list3.add("BEACH");
    list3.add("BALL");
    System.out.println(StringFormatter.format(list3, stringLength));
  }
  
}