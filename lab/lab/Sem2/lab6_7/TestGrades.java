package lab.lab.lab6_7;

import java.util.ArrayList;

/** 
 * TestGrades contains a main method to construct and manipulate ArrayLists.
 */ 
public class TestGrades {
  public static void main (String[] args) {
    // Make an empty ArrayList that will hold the test grades of a class (grades will be Doubles)
    
    ArrayList<Double> grades = new ArrayList<>();
    // Add five grades to the list
    
    for (int i : new int[] {58,89,92,29,31}) {
      grades.add((double) i);
    }
    // Calculate the average (double) test grade
    // Use a for-each loop to do this
    double average = 0;
    for (Double d : grades) {
      average+=d;
    }    
    average/=grades.size();
    // Find the lowest score
    // Use a for loop to do this
    double lowest=grades.get(0);
    for (Double d : grades) {
      if (d<lowest) {lowest=d;}
    }
    // Find the highest score
    // Use a for-each loop to do this
    double highest=grades.get(0);
    for (Double d : grades) {
      if (d>highest) {highest=d;}
    }
    
    // Print all the info
    System.out.println("There are " + grades.size() + " students in this class.");
    System.out.println("The class average was " + average);
    System.out.println("The lowest score was " + lowest);
    System.out.println("The highest score was " + highest);
    
    // Print out a graph to show grade distribution like so:
    // A: *****
    // B: ***
    // C: *
    // D:
    // F: *
    // It should still print the correct graph if you change some of the values in the ArrayList
    int[] abcdf = new int[] {0,0,0,0,0};
    for (Double d : grades) {
      if (d>=90) {
        abcdf[0]++;
      } else if (d>=80) {
        abcdf[1]++;
      } else if (d>=70) {
        abcdf[2]++;
      } else if (d>=60) {
        abcdf[3]++;
      } else {
        abcdf[4]++;
      }
    }
    for (int i=0;i<abcdf.length;i++) {
      String s;
      switch (i) {
        case 0: s="A"; break;
        case 1: s="B"; break;
        case 2: s="C"; break;
        case 3: s="D"; break;
        default: s="F"; break;
      }
      s+=": ";
      for (int n=0;n<abcdf[i];n++) {
        s+="*";
      }
      System.out.println(s);
    }
  }
}