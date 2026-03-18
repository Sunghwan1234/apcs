package AP.TestPractice.SeatingChart;

import java.util.List;

/** 
 * A seating chart contains the arrangement of students in a classroom, as well 
 * as the option to remove absent students.
 */
public class SeatingChart {
  /** seats[r][c] represencts the Student in row r and column c in the classroom. */
  private Student[][] seats;
  
  /** 
   * Creates a seating chart with the given number of rows and columns from the 
   * students in studentList. Empty seats in the seating chart are represented 
   * by null.
   * Preconditions: rows > 0; cols > 0;
   *                rows * columns >= studentList.size()
   * Postconditions:
   *   - Students appear in the seating chart in the same order as they appear
   *     in studentList, starting at seats[0][0].
   *   - seats is filled column by column from studentList, followed by any
   *     empty seats (represented by null).
   *   - studentList is unchanged.
   * 
   * @param rows the number of rows of seats in the classroom
   * @param cols the number of columns of seats in the classroom
   */
  public SeatingChart(List<Student> studentList, int rows, int cols)
  {
    seats = new Student[rows][cols];
    for (int i=0;i<studentList.size();i++) {
      seats[i%rows][i/rows] = studentList.get(i);
    }
  }
  
  
  /** 
   * Removes students who have more than a given number of absences from the
   * seating chart, replacing those entries in the seating chart with null
   * and returns the number of students removed.
   * Postconditions:
   *  - All students with allowedAbsences or fewer are in their original positions in seats.
   *  - No student in seats has more than allowedAbsences absences.
   *  - Entries without students contain null.
   * 
   * @param allowedAbsences as integer >=0
   * @return number of students removed from seats
   */
  public int removeAbsentStudents(int allowedAbsences)
  {
    int count=0;
    for (Student[] r : seats) {
      for (Student s : r) {
        if (s==null) {continue;}
        if (s.getAbsenceCount()>allowedAbsences) {
          s=null;
          count++;
        }
      }
    }
    return count;
  }
  
  
  /** 
   * Creates a string representation of the object.
   * 
   * @return  a string representation of the object
   */
  public String toString()
  {
    String s = "";
    for (Student[] row : seats) {
      for (Student student : row) {
        if (student==null) {
          s+="null\t\t";
        } else {
          s+=student.getName()+"\t"+student.getAbsenceCount()+"\t";
        }
      }
      s+="\n";
    }
    return s;
  }
  
  
}