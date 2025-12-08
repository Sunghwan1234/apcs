package lab5_3;

/**
 * TaskTester contains a main method to test Task objects.
 * 
 * The tester constructs three Task objects, invokes the getNumTasks,
 * setPriority, getPriority, and compareTo methods, and prints the results.
 */
public class TaskTester {
  public static void main(String[] args) {
    Task job1 = new Task("Homework", "Completing assignments and studying", 8);
    Task job2 = new Task("Sleep", "A good night's sleep", 9);
    Task job3 = new Task("Eat", "Three meals per day, plus snacks", 10);
    
    System.out.println("The number of created tasks is "+ Task.getNumTasks() + "\n");
    
    System.out.println("On a No Homework Night, homework priority goes from " + job1.getPriority() + " to 0.\n");
    job1.setPriority(0);
    
    System.out.println("Fighting sickness, sleep priority goes from " + job2.getPriority() + " to 10,");
    job2.setPriority(10);
    System.out.println("and eat priority goes from " + job3.getPriority() + " to 6.\n");
    job3.setPriority(6);
    
    System.out.print("The return value of job1 at priority: " + job1.getPriority());
    System.out.println(" compared to job2 at priority: " + job2.getPriority() + " is " + job1.compareTo(job2));
    System.out.print("The return value of job2 at priority: " + job2.getPriority());
    System.out.println(" compared to job3 at priority: " + job3.getPriority() + " is " + job2.compareTo(job3));
  }
}
