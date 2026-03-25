package lab.AP.TestPractice.StringCoder;

import java.util.ArrayList;

/**
 * StringCoderTester contains a main method to test a StringCoder object.
 * 
 * The tester constructs a StringCoder object, invokes the encodeString and 
 * decodeString methods, and prints the results.
 */
public class StringCoderTester{
  public static void main(String[] args) {
    String master = "sixtyzipperswerequicklypickedfromthewovenjutebag";
    StringCoder myStringCoder = new StringCoder(master);
    
    ArrayList<StringPart> myPartsList = myStringCoder.encodeString("overeager");
    for (StringPart item : myPartsList) {
      System.out.println(item + " " + master.substring(item.getStart(), item.getStart() + item.getLength()));
    }
    
    System.out.println(myStringCoder.decodeString(myPartsList));
  }
}