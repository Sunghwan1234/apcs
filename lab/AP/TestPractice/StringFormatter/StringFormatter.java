package AP.TestPractice.StringFormatter;

import java.util.List;

/** 
 * StringFormatter contains class (static) methods to manipulate and evaluate lists of 
 * strings.
 */
public class StringFormatter {  
  /** 
   * Returns the total number of letters in wordList.
   * Precondition: wordList contains at least two words, consisting of letters
   *               only.
   * 
   * @param wordList the list to be evaluated
   */
  public static int totalLetters(List<String> wordList)
  {
    int l=0;
    for (String s : wordList) {
      l+=s.length();
    }
    return l;
  }
  
  
  /** 
   * Returns the basic gap width when wordList is used to produce
   * a formatted string of formattedLen characters.
   * Precondition: wordList contains at least two words, consisting of letters
   *               only.
   *               formattedLen is large enough for all the words and gaps.
   * 
   * @param wordList     the list to be evaluated
   * @param formattedLen the length of the result of formatting wordList
   * @return the basic gap width when wordList is used to produce
   *         a formatted string of formattedLen characters
   */
  public static int basicGapWidth(List<String> wordList, int formattedLen)
  {
    int tl = totalLetters(wordList);
    int left = formattedLen-tl;
    int gaps = wordList.size()-1;
    int div = left/gaps;
    int mod = left%gaps; //leftoverSpaces
    return div;
  }
  
  
  /** 
   * Returns the number of leftover spaces when wordList is used to produce
   * a formatted string of formattedLen characters.
   * Preconditions: wordList contains at least two words, consisting of letters
   *                only.
   *                formattedLen is large enough for all the words and gaps.
   * 
   * @param wordList     the list to be evaluated
   * @param formattedLen the length of the result of formatting wordList
   * @return the number of leftover spaces when wordList isused to produce
   *         a formatted string of formattedLen characters
   */
  public static int leftoverSpaces(List<String> wordList, int formattedLen) {
    int numLetters = totalLetters(wordList);
    int leftovers = (formattedLen - numLetters)%(wordList.size()-1);
    return leftovers;
  }
  
  /** 
   * Returns a formatted string consisting of the words in wordList separated by
   * spaces.
   * Preconditions: The wordList contains at least two words, consisting of letters
   *                only.
   *                formattedLen is large enough for all the words and gaps.
   * Postcondition: All words in wordList appear in teh formatted string.
   *  - The words appear in the same order as in wordList.
   *  - The number of spaces between words is determined by basicGapWidth and the
   * distribution of leftoverSpaces from left to right, as described in the
   * question.
   * 
   * @param wordList     the list to be evaluated
   * @param formattedLen the length of the result of formatting wordList
   * @return a formatted string consisting of the words in wordList separated by spaces
   * 
   */
  public static String format(List<String> wordList, int formattedLen)
  {
    int lo = leftoverSpaces(wordList, formattedLen);
    int bgw = basicGapWidth(wordList, formattedLen);
    String bg = "";
    for (int i=0;i<bgw;i++) {
        bg+=" ";
    }
    String o = "";
    for (String s : wordList) {
      o+=s+bg;
      if (lo>0) {
        o+=" ";
        lo--;
      }
    }
    return o;
  }
  
  
}
