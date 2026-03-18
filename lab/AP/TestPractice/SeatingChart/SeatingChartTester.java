package AP.TestPractice.SeatingChart;

import java.util.ArrayList;
import java.util.List;

/**
 * SeatingChartTester contains a main method to test a SeatingChart object.
 * 
 * The tester constucts a SeatingChart, invokes the removeAbsentStudents, and prints the results.
 */
public class SeatingChartTester {
  public static void main(String[] args) {
    // populates roster with students
    List<Student> roster = new ArrayList<Student>();
    roster.add(new Student("Karen ", 3));
    roster.add(new Student("Liz   ", 1));
    roster.add(new Student("Paul  ", 4));
    roster.add(new Student("Lester", 1));
    roster.add(new Student("Henry ", 5));
    roster.add(new Student("Renee ", 9));
    roster.add(new Student("Glen  ", 2));
    roster.add(new Student("Fran  ", 6));
    roster.add(new Student("David ", 1));
    roster.add(new Student("Danny ", 3));
    
    // tests SeatingChart constructor and toString methods
    SeatingChart introCS = new SeatingChart(roster, 3, 4);
    System.out.println(introCS);
    
    // tests removeAbsentStudents method
    System.out.println(introCS.removeAbsentStudents(4) + "\n");
    System.out.println(introCS);
  }
}