package AP.TestPractice.SeatingChart;

/**
 * A student contains the name, and the number of absences from school.
 */
public class Student {
  private String name = null;
  private int absenceCount = -1;
  
  /** 
   * Constructs a student by initializing instance variables to parameters.
   * Not included in the original AP question.
   * 
   * @param name          the student's name
   * @param absenceCount  the current number of absences for the student
   */
  public Student(String name, int absenceCount) {
    this.name = name;
    this.absenceCount = absenceCount;
  }
  
  /**
   * Returns the name of the student.
   * Not implemented in the original AP question.
   * 
   * @return  the name of the student
   */
  public String getName() {
    return name;  
  }
  
  /** 
   * Returns the number of times this student has missed class.
   * Not implemented in the original AP question.
   * 
   * @return  the number of times this student has missed class.
   */
  public int getAbsenceCount() {
    return absenceCount;
  }
}