package AP.MultiPractice;

/**
 * MultPracticeTester contains a main method to test MultPractice objects.
 * 
 * The tester constructs two MultPractice objects, invokes the getProblem
 * and nextProblem methods, and prints the results.
 */
public class MultPracticeTester {
  public static void main(String[] args) {
    StudyPractice p1 = new MultPractice(7, 3);
    System.out.println(p1.getProblem());
    
    p1.nextProblem();
    System.out.println(p1.getProblem());
    
    p1.nextProblem();
    System.out.println(p1.getProblem());
    
    p1.nextProblem();
    System.out.println(p1.getProblem() + "\n");
    
    
    StudyPractice p2 = new MultPractice(4, 12);
    p2.nextProblem();
    System.out.println(p2.getProblem());
    System.out.println(p2.getProblem());
    
    p2.nextProblem();
    p2.nextProblem();
    System.out.println(p2.getProblem());
    
    p2.nextProblem();
    System.out.println(p2.getProblem());
    
  }
}
