package lab.lab.Sem2.lab7_2;

/**
 * A musician has a starting decade and a home state.
 */
public class Musician {
  private int decadeStart = -1;
  private String homeState = null;
  
  /**
   * Constructs a Musician by initializing instance variables.
   * 
   * @param decadeStart  the decade that this musician rose to prominence
   * @param homeState    this musician's state of origin
   */
  public Musician(int decadeStart, String homeState) {
    this.decadeStart = decadeStart;
    this.homeState = homeState;
  }
  
  /**
   * Returns the decade that this musician rose to prominence.
   * 
   * @return  the decade that this musician started
   */
  public int getDecadeStart() {
    return decadeStart;
  }
  
  /**
   * Returns this musician's state of origin
   * 
   * @return  this musician's home state
   */
  public String getHomeState() {
    return homeState;
  }
  
  /**
   * Returns a string containing this musician's starting decade and home state.
   * Overrides the toString method from Object.
   * 
   * @return  a string representation of the object
   */
 @Override
 public String toString() {
   return decadeStart + ", " + homeState;
 }
  
  /** 
   * Returns true if two objects start in same decade and have same home state;
   *         false otherwise.
   * Overrides the equals method from Object.
   * 
   * @return  true if this musician and obj have the same data;
   *          false otherwise
   */
 @Override
 public boolean equals(Object obj) {
   boolean output = false;
   if (((Musician) obj).getDecadeStart() == decadeStart && ((Musician) obj).getHomeState().equals(homeState)) {
     output = true;
   }
   return output;
   
   // Or this entire method can be condensed to one line:
   // return ((Musician) obj).getDecadeStart() == decadeStart && ((Musician) obj).getHomeState().equals(homeState);
 }  
  
}