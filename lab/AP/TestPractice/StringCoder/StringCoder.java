package lab.AP.TestPractice.StringCoder;

import java.util.ArrayList;

/**
 * A string coder stores a string that can be encoded and decoded.
 */
public class StringCoder {
  private String masterString = null;
  
  /** 
   * Stores param as masterString.
   * Precondition: the master string contains all the letters of the alphabet
   * 
   * @param master the master string for the StringCoder
   */
  public StringCoder(String master)
  {  masterString = master;  }
  
  /** 
   * Returns the decoded string.
   * Precondition: parts.size() > 0
   * 
   * @param parts an ArrayList of string parts that are valid in the master string
   * @return the string obtained by concatenating the parts of the master string
   */
  public String decodeString(ArrayList<StringPart> parts)
  {
    String s = "";
    for (StringPart sp : parts) {
      s+=masterString.substring(sp.getStart(), sp.getStart()+sp.getLength());
    }
    return s;
  }
  
  
  /** 
   * Returns a StringPart object matching the beginning of param.
   * Precondition: all of the characters in str appear in the master string;
   *               str.length() > 0
   * Not implemented in the original AP question.
   * 
   * @param str the string to encode using the master string
   * @return a string part in the master string that matches the beginning of str.
   *         The returned string part has length at least 1.
   */
  private StringPart findPart(String str) {
    int i = str.length();
    while (i > 0) {
      if (masterString.indexOf(str.substring(0, i)) > -1) {
        return new StringPart(masterString.indexOf(str.substring(0, i)), i);
      }
      i--;
    }
    return null;
  }
  
  /** 
   * Returns an Arraylist of StringPart objects that can be combined.
   * Precondition: all of the characters in word appear in the master string;
   *               word.length() > 0
   * 
   * @param word the string to be encoded
   * @return an ArrayList of string parts of the master string that can be 
   *         combined to create word
   */
  public ArrayList<StringPart> encodeString(String word)
  {
    ArrayList<StringPart> stringParts = new ArrayList<StringPart>();
    while (word.length()>0) {
      StringPart find = findPart(word.substring(0,word.length()));
      if (find!=null) {
        stringParts.add(find);
        word = word.substring(find.getLength(), word.length());
      }
    }
    return stringParts;
  }
  
  public static void pl(Object o) {
      System.out.println(o);
    }
}