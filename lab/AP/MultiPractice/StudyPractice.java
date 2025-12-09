package AP.MultiPractice;

/**
 * StudyPractice is comprised of practice problems on a certain subject.
 */
public interface StudyPractice {
  /** 
   * Returns the current practice problem.
   *
   * @return  the current practice problem
   */
  String getProblem();
  
  /**
   * Changes to the next practice problem.
   */
  void nextProblem();

}
