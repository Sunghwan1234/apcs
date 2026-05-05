package lab.lab.Sem2.lab7_2;

/**
 * An istrumentalist is a musician who plays one or more instruments.
 */
public class Instrumentalist extends Musician {
  // additional instance variable
  private int numInstruments = -1;
  
  /**
   * Constructs an Instrumentalist by initializing instance variables.
   * 
   * @param decadeStart     the decade that this instrumentalist rose to prominence
   * @param homeState       this instrumentalist's state of origin
   * @param numInstruments  the number of instruments played by this instrumentalist
   */
  public Instrumentalist(int decadeStart, String homeState, int numInstruments) {
    super(decadeStart, homeState);
    this.numInstruments = numInstruments;
  }
  
  /**
   * Returns the number of instruments this instrumentalist plays.
   * 
   * @return  the number of instruments played by this instrumentalist
   */
  public int getNumInstruments() {
    return numInstruments;
  }
  
  /**
   * Returns a string containing this instrumentalist's starting decade, home state, and number
   * of instruments played.
   * Overrides the toString method from Musician
   * 
   * @return  a string representation of the object
   */
 @Override
 public String toString() {
    return super.toString()+" Instruments: "+numInstruments;
 }
  
  
  /** 
   * Returns true if two objects start in same decade, have same home state, and play same num of instruments;
   *         false otherwise.
   * Overrides the equals method from Object.
   * 
   * @return  true if this instrumentalist and obj have the same data;
   *          false otherwise
   */
 @Override
 public boolean equals(Object obj) {
    return super.equals(obj) && numInstruments==((Instrumentalist)obj).numInstruments;
 }
  
  
}