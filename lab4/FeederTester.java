package lab4;

import java.util.Scanner;

/**
 * FeederTester contains a main method to test a Feeder object.
 * 
 * The tester constructs a Feeder object and repeatedly invokes the
 * simulateManyDays method. 
 */
public class FeederTester {
  public static void main(String[] args) {
    Scanner userInput = new Scanner(System.in);
    System.out.print("To exit this simulation at any time,");
    System.out.println(" enter a negative number for food, birds, or days.\n");
    int initialFood = 0;
    int initialBirds = 0;
    int initialDays = 0;

    while (initialFood >= 0 && initialBirds >= 0 && initialDays >= 0) {
      System.out.print("Enter the initial bird feeder food in grams: ");
      initialFood = userInput.nextInt();
      if (initialFood >= 0) {
        System.out.print("Enter the number of birds at the feeder: ");
        initialBirds = userInput.nextInt();
        if (initialBirds >= 0) {
          System.out.print("Enter the number of days to siumulate: ");
          initialDays = userInput.nextInt();
          if (initialDays >= 0) {
            Feeder myFeeder = new Feeder(initialFood);
            myFeeder.simulateManyDays(initialBirds, initialDays);
          }
        }
      }
    }
    
    userInput.close();

  }
}