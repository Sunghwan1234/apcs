package lab.lab.Sem2.lab8_2;

/**
 * RecursionTester contains three static recursive methods, as well as a main method to
 * test these recursive methods.
 * 
 * The tester calls each recursive method a number of times to test base and recursive
 * cases, and prints the results.
 */
public class RecursionTester {
  //------------------------------------------------------------------------------------
  // Problem 1: Greatest Common Factor
  //------------------------------------------------------------------------------------
  
  /**
   * Returns the greatest common factor of two integers.
   *
   * @param num1  the first num of which to find factors
   * @param num2  the second num of which to find factors
   * @return      the greatest common factor of the two parameters
   */
  public static int gcf(int num1, int num2) {
    if (num1==0) {
      return num2;
    } else if (num2==0) {
      return num1;
    } else if (num1>1) {
      return gcf(num2, num1%num2);
    } else {
      return num1;
    }
  }
  
  
  //------------------------------------------------------------------------------------
  // Problem 2: Reverse Substring
  //------------------------------------------------------------------------------------
  
  /** 
   * Returns the contents of String words with all characters in reverse order starting at index.
   *
   * @param words  the input string to be reversed
   * @param index  the index at which to begin reversing the remainder of the string
   * @return       the partially reversed string
   */
  public static String substringReverse(String words, int index) {
    if (1==words.length()) {return words;}
    if (index>words.length()-1) {index=words.length()-1;}
    return words.substring(0,index)+reverse(words.substring(index));
  }
  public static String reverse(String words) {
    if (words.length()<=1) {return words;}
    return words.substring(words.length()-1)+reverse(words.substring(0,words.length()-2));
  }
  
  
  //------------------------------------------------------------------------------------
  // Problem 3: Insert commas in number
  //------------------------------------------------------------------------------------
  
  /**
   * Returns a string representation of num with commas in appropriate places
   *
   * @param num  the integer to be revised
   * @return     a string representation of the number, with additional commas
   */
  public static String commas(int num) {
    if (num<1000) {return ""+num;}
    String n=num+"";
    return commas(num/1000)+","+n.substring(n.length()-3,n.length());
  }
  
  
  //------------------------------------------------------------------------------------
  // Main Method: test all methods here
  //------------------------------------------------------------------------------------
  
  /**
   * Tests base and recursive cases for the above methods.
   * 
   * @param args  not used
   */
  public static void main(String[] args) {
   /* Tests base cases for Problem 1 */
   System.out.println("Base cases for Example 1:");
   System.out.println(gcf(1, 1));
   System.out.println(gcf(1, 2));
   System.out.println(gcf(2, 1) + "\n");
   /* Tests successive (non-base) cases for Problem 1 */
   System.out.println("Successive (non-base) cases for Example 1:");
   System.out.println(gcf(18, 24));
   System.out.println(gcf(24, 18));
   System.out.println(gcf(10, 40));
   System.out.println(gcf(40, 10));
   System.out.println(gcf(575, 10000));
   System.out.println(gcf(10000, 575) + "\n");
    
   /* Tests base cases for Problem 2 */
   System.out.println("Base cases for Example 2:");
   System.out.println(substringReverse("A", 0));
   System.out.println(substringReverse("B", 1));
   System.out.println(substringReverse("CD", 0));
   System.out.println(substringReverse("EF", 1));
   System.out.println(substringReverse("GH", 2) + "\n");
   /* Tests successive (non-base) cases for Problem 2 */
   System.out.println("Successive (non-base) cases for Example 2:");
   System.out.println(substringReverse("This is weird.", 2));
   System.out.println(substringReverse("This is really weird.", 10) + "\n");
    
   /* Tests base cases for Problem 3 */ 
   System.out.println("Base cases for Example 3:");
   System.out.println(commas(1));
   System.out.println(commas(21));
   System.out.println(commas(321) + "\n");
   /* Tests successive (non-base) cases for Problem 3 */
   System.out.println("Successive (non-base) cases for Example 3:");
   System.out.println(commas(54321));
   System.out.println(commas(7654321));
   System.out.println(commas(1000));
   System.out.println(commas(30040005));
   System.out.println(commas(987654321));
  }
  
}