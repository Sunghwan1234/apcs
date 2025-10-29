package lab4;

/**
 * The Feeder class simulates a bird feeder in tracking the level of bird food
 * remaining per day.
 */
public class Feeder {
  /**
   * The amount of food, in grams, currently in the bird feeder; initialized in
   * the constructor and always greater than or equal to zero.
   */
  public int currentFood;

  /**
   * Instantiates current food in this feeder.
   * Not included in the original AP question.
   * 
   * @param theCurrentFood  the initial food in the feeder
   */
  public Feeder(int theCurrentFood) {
    currentFood = theCurrentFood;
  }

  /**
   * Simulates one day with numBirds birds or possibly a bear at the bird feeder,
   * as described in part (a).
   * Precondition: numBirds > 0
   * 
   * @param numBirds the number of birds visiting the feeder each day
   */
  public void simulateOneDay(int numBirds)
  {  /* to be implemented in part (a) */
    boolean abnormal = Math.random()>0.95;
    if (!abnormal) {
      currentFood -= numBirds*(int)Math.floor(Math.random()*(41)+10);
      if (currentFood<0) {currentFood=0;}
    } else {
      currentFood = 0;
    }
  }


  /**
   * Returns the number of days birds or a bear found food to eat at the feeder in
   * this simulation, as described in part (b).
   * Preconditions: numBirds > 0, numDays > 0
   * 
   * @param numBirds the number of birds visiting the feeder each eay
   * @param numDays  the number of days to be siumlated
   * @return         the number of days some food was found in the feeder 
   */
  public int simulateManyDays(int numBirds, int numDays) {
    System.out.print("Simulate " + currentFood + " grams for " + numBirds);
    System.out.println(" birds for " + numDays + " days.");
    /* to be implemented in part (b) */ 
    int daysWithFood = 0;
    while (daysWithFood<numDays && currentFood>0) {
      simulateOneDay(numBirds);
      System.out.println("Food after day " + ++daysWithFood + ": " + currentFood);
    }
    System.out.print("Summary - Days with food: " + daysWithFood + " with ");
    System.out.println(currentFood + " remaining\n");
    return numBirds;
  }
  

}