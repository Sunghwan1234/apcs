package AP.wordMatch;

/**
 * A word match contains a secret word that may be guessed.
 */
public class WordMatch {
  /** The secret string. */
  private String secret;
  
  /**
   * Constructs a WordMatch object with the given string of lowercase letters.
   * Not implemented in the original AP question.
   *
   * @param word the secret word to be guessed
   */
  public WordMatch(String word) {
    secret = word;
  }
  
  /**
   * Returns a score for guess, as described in part (a).
   * Precondition: 0 < guess.length() <= secret.length()
   *
   * @param guess the current guess
   * @return a score for guess
   */
  public int scoreGuess(String guess)
  {
    int count=0;
    if (secret.contains(guess)) {
      for (int i=0;i<=secret.length()-guess.length();i++) {
        if (secret.substring(i,i+guess.length()).equals(guess)) {
          count++;
        }
        //System.out.println(secret.substring(i,i+guess.length()));
      }
      return count*guess.length()*guess.length();
    } else {
      return 0;
    }
  }
  
  
  /**
   * Returns the better of two guesses, as determined by scoreGuess and the rules 
   * for a tie-breaker that are descibed in part (b).
   * Precondition: guess1 and guess2 contain all lowercase letters.
   *               guess1 is not the same as guess2.
   *
   * @param guess1 the first guess to be compared
   * @param guess2 the second guess to be compared
   * @return guess1 or guess2, whichever is better
   */
  public String findBetterGuess(String guess1, String guess2)
  {
    int score1 = scoreGuess(guess1);
    int score2 = scoreGuess(guess2);
    if (score1==score2) {
      if (guess1.compareTo(guess2)>1) {
        return guess1;
      } else {
        return guess2;
      }
    } else {
      if (score1>score2) {
        return guess1;
      } else {
        return guess2;
      }
    }
  }
  
  
}
