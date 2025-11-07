package lab.dogwalker;

/**
 * A dog walker works for a company and can walk a maximum number of dogs in a
 * given hour.
 */
public class DogWalker {
  /**
   * The maximum number of dogs this walker can walk simultaneously
   * per hour.
   */
  private int maxDogs = -1;

  /** The dog-walking company this dog walker is associated with */
  private DogWalkCompany company = null;

  /**
   * Instantiates maxDogs and company values.
   * Not implemented in the original AP question.
   * 
   * @param maxDogs the most dogs that can be walked by this dog walker
   *                Precondition: maxDogs > 0
   * @param company the employer of this dog walker
   */
  public DogWalker(int theMaxDogs, DogWalkCompany aCompany) {
    maxDogs = theMaxDogs;
    company = aCompany;
  }

  /**
   * Takes at least one dog for a walk during the time specified by
   * hour, as described in part (a).
   * 
   * @param hour the hour of the day dogs are being walked
   *             Preconditions: 0 <= hour <= 23
   *             maxDogs > 0
   * @return the number of dogs to be walked during the hour
   */
  public int walkDogs(int hour) {
    return (int)Math.clamp(company.numAvailableDogs(hour),0,maxDogs);
  }


  /**
   * Performs an entire dog-walking shift and returns the amount
   * earned, in dollars, as described in part (b).
   * 
   * @param startHour the first hour of the walk
   * @param endHour   the last hour of the walk (included in the walk)
   *                  Preconditions: 0 <= startHour <= endHour <= 23
   *                  maxDogs > 0
   * @return the total money earned for this shift
   */
  public int dogWalkShift(int startHour, int endHour) {
    int total=0;
    for (int hour=startHour;hour<=endHour;hour++) {
      total += walkDogs(hour)*5;
      if (walkDogs(hour)==maxDogs || (hour>=9&&hour<=17)) {
        total+=3;
      }
    }
    return total;
  }

  
}
