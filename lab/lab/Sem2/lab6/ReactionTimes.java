package lab6;

import java.util.Scanner;

/**
 * ReactionTimes contains a main method to construct an array to hold the reaction
 * times of the user in a game.  The method finds the average of these reaction
 * times and prints it out.
 */
public class ReactionTimes {
  public static void main(String[] args) {
    // 1. Create a Scanner object.
    Scanner scanner = new Scanner(System.in);
    
    // 2. Declare and instantiate an array called "times" that contains 5 double elements.
    //    Don't initialize any values yet.
    double[] times = new double[5];
    
    // 3. Create a for loop that will fill the times array with values.
    //    Each time the for loop is iterated, ask the user for their reaction time.
    for (int i=0;i<times.length;i++) {
      times[i] = scanner.nextDouble();
    }
    
    // 4. Create a double variable called firstAverage that will contain the average reaction time of the user.
    //    Use a for each loop to calculate and store firstAverage.
    double firstAverage=0;
    for (double t : times) {
      firstAverage+=t;
    }
    firstAverage/=5;
    
    // 5. Print a message stating the first average reaction times of the user.
    System.out.println(firstAverage);
                       
    // 6. Create a for loop that will fill the times array with new values.
    //    Each time the for loop is iterated, ask the user for their reaction time.
    for (int i=0;i<times.length;i++) {
      times[i] = scanner.nextDouble();
    }
        
    // 7. Create a double variable called secondAverage that will contain the new average reaction time of the user.
    //    Use a for-each loop to calculate and store secondAverage.
    double secondAverage=0;
    for (double t : times) {
      secondAverage+=t;
    }
    secondAverage/=5;
    
    // 8. Print a message stating the second average reaction times of the user.
    System.out.println(secondAverage);
    
  }
}
