package AP.StudentRecord;

/**
 * A student record contains a student's scores, as well as tools
 * to analyze the average of these scores, and the potential improvement
 * of the student.
 */
public class StudentRecord {
  private int[] scores; 
  
  /**
   * Instantiates array of student's scores.
   * Precondition: scores.length > 1
   * 
   * @param scores the scores of the student
   */
  public StudentRecord(int[] scores) {
    this.scores = scores;
  }
  
  /** 
   * Returns the average (arithmetic mean) of the values in scores
   * whose subscripts are between first and last, inclusive.
   * Precondition: 0 <= first <= last < scores.length
   * 
   * @return  the arithmetic mean of the scores at index first to last, inclusive
   */
  private double average(int first, int last)
  {
    int sum=0;
    for (int i=first; i<=last; i++) {
      sum+=scores[i];
    }
    return ((double)sum)/(last-first+1);
  }
  
  
  /**
   * Returns true if each successive value in scores is greater
   * than or equal to the previous value; otherwise, returns false.
   * 
   * @return true if scores are in order from least to greatest;
   *         false otherwise
   */
  private boolean hasImproved()
  {
    int bef=0;
    for (int i : scores) {
      if (i>=bef) {
        bef = i;
      } else {
        return false;
      }
    }
    return true;
  }
  
  
  /** 
   * Returns the average of the elements in scores with indexes greater 
   * than or equal to scores.length / 2, if the values in scores have improved;
   * otherwise, returns the average of all of the values in scores
   * 
   * @return the average of all values if scores have not improved; otherwise
   *         the avearge of the last half of the values
   */
  public double finalAverage()
  {
    if (hasImproved()) {
      System.out.print("improved. ");
      return average(scores.length/2, scores.length-1);
    } else {
      return average(0,scores.length-1);
    }
  }
  
  
}
