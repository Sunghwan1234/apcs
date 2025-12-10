package AP.Calendar_2;

/**
 * APCalendar contains static methods to determine leap years,
 * and the day of a week or year of a given date.
 */
public class APCalendar {
  /**
   * Determines if a given year is a leap year.
   * Not implemented in the original AP question.
   * 
   * @param year the year to be evaluated
   * @return true if param year is a leap year;
   *         false otherwise.
   */
  private static boolean isLeapYear(int year) {
    boolean answer = false;
    if (year > 1582) {
      if (year % 4 == 0) {
        if (year % 100 == 0) {
          if (year % 400 == 0) {
            answer = true;
          } else {
            answer = false;
          }
        } else {
          answer = true;
        }
      } else {
        answer = false;
      }
    } else {
      answer = false;
    }
    return answer;
  }

  /**
   * Returns the number of leap years between year1 and year2, inclusive.
   * Precondition: 0 <= year1 <= year2
   * 
   * @param year1 the first year to be checked if it is a leap year
   * @param year2 the last year to be checked if it is a leap year
   * @return the total number of leap years from year1 to year2, inclusive.
   */
  public static int numberOfLeapYears(int year1, int year2) {
    int count=0;
    for (int i=year1;i<=year2;i++) {
      if (isLeapYear(i)) {count++;}
    }
    return count;
  }


  /**
   * Returns the value representing the day of the week for the first day of year,
   * where 0 denotes Sunday, 1 denotes Monday, ..., and 6 denotes Saturday.
   * Not implemented in the original AP question.
   * 
   * @param year the year to be evaluated
   * @return the integer equivalent of the first day of the given year
   */
  private static int firstDayOfYear(int year) {
    return (5 + year - 1582 + numberOfLeapYears(1582, year - 1)) % 7;
  }

  /**
   * Returns n, where month, day, and year specify the nth day of the year.
   * Returns 1 for January 1 (month = 1, day = 1) of any year.
   * Precondition: The date represented by month, day, year is a valid date.
   * Not implemented in the original AP question.
   * 
   * @param month the month to be evaluated (1 = January, 2 = February, etc.)
   * @param day   the day to be evaluated
   * @param year  the year to be evaluated
   * @return the number of days from the beginning of the given year
   */
  private static int dayOfYear(int month, int day, int year) {
    int totalDays = 0;
    int[] daysInMonths = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
    if (isLeapYear(year)) {
      daysInMonths[1] = 29;
    }
    for (int i = 0; i < month - 1; i++) {
      totalDays += daysInMonths[i];
    }
    totalDays += day;
    return totalDays;
  }

  /**
   * Returns the value representing the day of the week for the given date
   * (month, day, year), where 0 denotes Sunday, 1 denotes Monday, ...,
   * and 6 denotes Saturday.
   * Precondition: The date represented by month, day, year is a valid date.
   * 
   * @param month the month to be evaluated (1 = January, 2 = February, etc.)
   * @param day   the day to be evaluated
   * @param year  the year to be evaluated
   * @return the integer equivalent of the day of the week of the given date
   */
  public static int dayOfWeek(int month, int day, int year) 
  {
    int startingDay = firstDayOfYear(year);
    int date = dayOfYear(month, day, year);
    date+=startingDay-1;
    date=date%7;
    return date;
  }


}