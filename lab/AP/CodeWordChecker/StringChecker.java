package AP.CodeWordChecker;

/**
 * A StringChecker validates a given string of text.
 */
public interface StringChecker {
  /** 
   * Returns true if str is valid.
   *
   * @param str  the string to be validated
   */
  boolean isValid(String str);
  
}
