package AP.HiddenWord;

public class HiddenWord {
  private String word;

  public HiddenWord(String word) {
    this.word = word.toUpperCase();
  }

  public String getHint(String guess) {
    if (guess.length()!=word.length()) {
      return "INVALID";
    }
    guess = guess.toUpperCase();
    String out="";
    for (int i=0;i<word.length();i++) {
      if (word.contains(guess.substring(i,i+1))) {
        if (word.charAt(i)==guess.charAt(i)) {
          out+=word.charAt(i);
        } else {
          out+="+";
        }
      } else {
        out+="*";
      }
    }
    return out;
  }

}
