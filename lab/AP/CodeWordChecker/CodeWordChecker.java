package AP.CodeWordChecker;

public class CodeWordChecker implements StringChecker {
  private int min=6, max=20;
  private String except;

  public CodeWordChecker(int min, int max, String except) {
    this.min=min; this.max=max; this.except=except;
  }
  public CodeWordChecker(String except) {
    this.except=except;
  }

  @Override
  public boolean isValid(String str) {
    return !str.contains(except) && str.length()>=min && str.length()<=max;
  }
  
}
