package Phrase;

/**
 * A phrase can be searched to find an occurrence of a given string within.
 */
public class Phrase {
  private String currentPhrase;
  
  /** 
   * Constructs a new Phrase object by initializing instance variable.
   *
   * @param p the intital phrase
   */
  public Phrase(String p)
  {  currentPhrase = p; }
  
  /** 
   * Returns the index of the nth occurrence of parameter in the phrase.
   * Precondition:  str.length() > 0 and n > 0
   * Postcondition: the current phrase is not modified
   * Not implemented in the original AP question.
   * 
   * @param str the string to be searched for
   * @param n   the nth occurence of str
   * @return the index of the nth occurrent of str in the current phrase;
   *         -1 if the nth occurrence does not exist
   */
  public int findNthOccurrence(String str, int n) {  
    int count = 0;
    int ans = -1;
    for (int i = 0; i < currentPhrase.length(); i++) {
      if (i + str.length() < currentPhrase.length()) {
        if (currentPhrase.substring(i, i+str.length()).equals(str)) {
          count++;
          if (count == n) {
            ans = i;
          }
        }
      }
    }
    return ans;
  }
  
  /** 
   * Modifies the current phrase by replacing the nth occurrence of str with repl.
   * If the nth occurrence does not exist, the current phrase is unchanged.
   * Precondition: str.length() > 0 and n > 0
   * 
   * @param str  the string to be searched for
   * @param n    the nth occurence of str
   * @param repl the string to replace str
   */
  public void replaceNthOccurrence(String str, int n, String repl) 
  {
    int occ = findNthOccurrence(str, n);
    if (occ<0) {return;}
    currentPhrase = currentPhrase.substring(0,occ)+repl+currentPhrase.substring(occ+str.length());
  }
  
  
  /** 
   * Returns the index of the last occurrence of parameter in the phrase.
   * Precondition:  str.length() > 0
   * Postcondition: the current phrase is not modified.
   * 
   * @param str the string to be searched for
   * @return Returns the index of the last occurrence of str in the current
   *         phrase;
   *         -1 if str is not found.
   */
  public int findLastOccurrence(String str) {
    for (int i = currentPhrase.length()-1; i >=0; i--) {
      if (i + str.length() < currentPhrase.length()) {
        if (currentPhrase.substring(i, i+str.length()).equals(str)) {
          return i;
        }
      }
    }
    // why the FUCK would you use findNthOccurrence, waste of CPU
    return -1;

    
  }
  
  
  /** 
   * Returns a string containing the current phrase.
   * 
   * @return  a string representation of the object
   */
  public String toString()
  {  return currentPhrase;  }
  
}