package AP.StudentRecord;

/**
 * StudentRecordTester contains a main method to test StudentRecord objects.
 * 
 * The tester constructs three StudentRecord objects, invokes the
 * finalAverage methods, and prints the results.
 */
public class StudentRecordTester {
  public static void main(String[] args) {
    int[] scoreSet1 = {50, 50, 20, 80, 53};
    StudentRecord record1 = new StudentRecord(scoreSet1);
    System.out.println(record1.finalAverage() + "\n");
    
    int[] scoreSet2 = {20, 50, 50, 53, 80};
    StudentRecord record2 = new StudentRecord(scoreSet2);
    System.out.println(record2.finalAverage() + "\n");
    
    int[] scoreSet3 = {20, 50, 50, 80};
    StudentRecord record3 = new StudentRecord(scoreSet3);
    System.out.println(record3.finalAverage());
  }
}
