package AP.MultiPractice;

public class MultPractice implements StudyPractice {
  private int x,y;

  public MultPractice(int x, int y) {
    this.x=x; this.y=y;
  }

  public String getProblem() {
    return x+" TIMES "+y;
  }
  public void nextProblem() {y++;}
}
