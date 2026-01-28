package lab6_6p1;

import java.util.Scanner;

/**
 * StudentGrades contains a main method that stores and accesses students' grades in a 2D array.
 */
public class StudentGrades {
  public static void main(String[] args) {
    /* Prints the introductory information.
     * You don't need to change or add anything here.
     */
    System.out.println("Precalculus Honors");
    System.out.println("Student Test Grades");
    System.out.println();
    System.out.println("ID Num " + "\t" + "T1" + "\t" + "T2" + "\t" + "T3" + "\t" + "Avg");
    
    /* The two-dimensional array that contains all the grades.
     * Each row contains the student's ID number in the first slot,
     * followed by the student's first three test grades.
     */
    int[][] grades = new int[5][5]; 
    grades[0][0] = 4550801; grades[0][1] = 89; grades[0][2] = 94; grades[0][3] = 91;
    grades[1][0] = 4354202; grades[1][1] = 67; grades[1][2] = 90; grades[1][3] = 87;
    grades[2][0] = 5673001; grades[2][1] = 70; grades[2][2] = 93; grades[2][3] = 96;
    grades[3][0] = 3490200; grades[3][1] = 75; grades[3][2] = 85; grades[3][3] = 98;
    grades[4][0] = 3490200; grades[4][1] = 75; grades[4][2] = 85; grades[4][3] = 98;
    /* to be implemented in part (a) */
    
    /* to be implemented in part (b) */
    for (int row=0;row<grades.length;row++) {
      int sum=0;
      int count=0;
      for (int col=1;col<grades[row].length-1;col++) {
        sum+=grades[row][col];
        count++;
      }
      grades[row][4]=sum/count;
    }
    
    
    
    /* to be implemented in part (c) */
    System.out.println("ID\tT1\tT2\tT3\tAvg");
    for (int[] row:grades) {
      for (int i:row) {
        System.out.print(i+"\t");
      }
      System.out.println();
    }
    
    
    Scanner userInput = new Scanner(System.in);
    System.out.println("\nEnter your student ID: ");
    int userID = userInput.nextInt();
    
    System.out.println("Your scores: ");
    String output = "";
    /* to be implemented in part (d) */
    for (int[] row:grades) {
      if (row[0]==userID) {
        for (int i=1;i<row.length-1;i++) {
          output+=row[i]+"\t";
        }
        break;
      }
    }
    System.out.println(output);
  }
}