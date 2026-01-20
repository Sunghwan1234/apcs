package AP.Calendar_2;

import java.util.Scanner;

/**
 * APCalendarTester contains a main method to test an APCalendar object.
 * 
 * The tester prompts for user input to enter values for four different APCalendar
 * objects, constructs the APCalendar objects, invokes the numberOfLeapYears and 
 * dayOfWeek methods, and prints the results.
 */
public class APCalendarTester {
  public static void main(String[] args) {
    // tests the numberOfLeapYears method
    Scanner userInput = new Scanner(System.in);
    System.out.println("Please enter the the first year (must be on or after 1582):");
    int firstYear = 1956;
    System.out.println("Please enter the the second year (must be on or after 1582):");
    int secondYear = 2014;
    System.out.println("Number of leap years from " + firstYear + " to " + secondYear);
    System.out.println("(inclusive) is " + APCalendar.numberOfLeapYears(firstYear, secondYear) + "\n");
    
    // tests the dayOfWeek method
    for (int i = 0; i < 3; i++) {
      System.out.println("Please enter the month (1 = January, 2 = February, etc.):");
      int month = userInput.nextInt();
      System.out.println("Please enter the day:");
      int day = userInput.nextInt();
      System.out.println("Please enter the year (must be on or after 1582):");
      int year = userInput.nextInt();
      System.out.println(APCalendar.dayOfWeek(month, day, year));
      String[] dayNames = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
      System.out.println(month + "/" + day + "/" + year + " is/was a "
         + dayNames[APCalendar.dayOfWeek(month, day, year)] + "\n");
    }
  }
}
