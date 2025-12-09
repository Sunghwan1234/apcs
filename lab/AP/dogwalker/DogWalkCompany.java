package AP.dogwalker;

/**
 * A Dog walk company tracks the number of dogs available to walk in a given
 * time-frame and updates these numbers accordingly.
 */
public class DogWalkCompany {
  /*
   * The number of dogs available to walk at hours (indices) in a given time range
   */
  private int[] dogs = null;

  /**
   * Instantiates array of dogs available to walk in a given time range.
   * 
   * @param dogs the dogs availailable by hour
   */
  public DogWalkCompany(int[] theDogs) {
    dogs = theDogs;
  }

  /**
   * Returns the number of dogs, always greater than 0, that are available
   * for a walk during the time specified by hour.
   * Not implemented in the original AP question.
   * 
   * @param hour the hour dogs are to be walked
   *             Precondition: 0 <= hour <= 23
   * @return the number of available doges to be walked
   */
  public int numAvailableDogs(int hour) {
    return dogs[hour];
  }

  /**
   * Decreases, by numberDogsWalked, the number of dogs available for a walk
   * during the time specified by hour
   * Not implemented in the original AP question.
   * 
   * @param hour             the hour dogs are to be walked
   *                         Precondition: 0 <= hour <= 23
   * @param numberDogsWalked the number of dogs available to be walked
   *                         Precondition: numberDogsWalked > 0
   */
  public void updateDogs(int hour, int numberDogsWalked) {
    dogs[hour] -= numberDogsWalked;
  }

}
