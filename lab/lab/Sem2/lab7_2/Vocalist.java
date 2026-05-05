package lab.lab.Sem2.lab7_2;

/**
 * A vocalist is a musician who sings.
 */
public class Vocalist extends Musician {
  // additional instance variable
  private int range = -1;
   
  /**
   * Constructs a vocalist by initializing instance variables.
   * 
   * @param decadeStart  the decade that this vocalist rose to prominence
   * @param homeState    this vocalist's state of origin
   * @param range        the number of octaves in this vocalist's range
   */
  public Vocalist(int decadeStart, String homeState, int range) {
    super(decadeStart, homeState);
    this.range = range;
  }
  
  /**
   * Returns this vocalist's octave range.
   * 
   * @return  the number of ocatves in this vocalist's range
   */
  public int getRange() {
    return range;
  }
  
  /**
   * Returns a string containing this vocalist's starting decade, home state, and vocal range.
   * Overrides the toString method from Musician
   * 
   * @return  a string representation of the object
   */
 @Override
 public String toString() {
  return super.toString()+" Range: "+range;
}
  
  
  /** 
   * Returns true if two objects start in same decade and have the same range (home state is not checked);
   *         false otherwise
   * Overrides the equals method from Object.
   * 
   * @return  true if this instrumentalist and obj have the same decade and range;
   *          false otherwise
   */
 @Override
 public boolean equals(Object obj) {
  return getDecadeStart()==((Musician)obj).getDecadeStart() && getRange()==((Vocalist)obj).getRange();
}
  
  
}