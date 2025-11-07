package lab.lab4_2p2;

public class CompoundWord {
  private String word1, word2;
  public CompoundWord(String word1, String word2) {
    this.word1 = word1;
    this.word2 = word2;
  }
  public String get1() {
    return word1;
  }
  public String get2() {
    return word2;
  }
  public void set1(String i) {
    word1=i;
  }
  public void set2(String i) {
    word2=i;
  }
  public int findTotalLength() {
    return word1.length()+word2.length();
  }
  public void swapWords() {
    String i=word1;
    word1=word2;
    word2=i;
  }
  @Override
  public String toString() {
    return word1+word2;
  }
}
