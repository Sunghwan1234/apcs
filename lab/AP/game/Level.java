package AP.game;
/**
 * A level earns points for the player if it is completed.
 */
public class Level {
  private int points = 0;
  private boolean[] goalReachedSimulations = null;
  private int count = -1;
  
  /**
   * Initializes values for this level. Simulates examples with multiple values depicting
   * all sample scenarios for a given level.
   * Not included in the original AP question.
   * 
   * @param points                  the points earned for completing this level
   * @param goalReachedSimulations  boolean values to simulate completing this level (or not)
   */
  public Level(int points, boolean[] goalReachedSimulations) {
    this.points = points;
    this.goalReachedSimulations = goalReachedSimulations;
  }
  
  /**
   * Simulates example questions by returning successive boolean values passed as parameter in constructor.
   * Not implemented in the original AP question.
   * 
   * @return  true if the player reached the goal on this level;
   *          false otherwise.
   */
  public boolean goalReached() {
    count++;
    return goalReachedSimulations[count];
  }

  /**
   * Returns the number of points (a positive integer) recorded for this level.
   * Not implemented in the original AP question.
   * 
   * @return  the number of points earned for completing this level
   */
  public int getPoints() {
    return points;
  }

}