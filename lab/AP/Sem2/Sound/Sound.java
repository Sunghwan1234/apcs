package AP.Sem2.Sound;

/**
 * A Sound object stores and revises samples of sound.
 */
public class Sound {
  /** the array of values in this sound; guaranteed not to be null */
  private int[] samples;
  
  /** 
   * Instantiates samples array.
   * Not included in the original AP question.
   * 
   * @param values positive and negative amplitudes of sound
   */
  public Sound(int[] values) {
    samples = values;
  }
  
  /** 
   * Changes those values in this sound that have an amplitude greater than limit.
   * Values greater than limit are changed to limit.
   * Values greater than -limit are changed to -limit.
   * Precondition: limit >= 0
   * 
   * @param limit the amplitude limit
   * @return the number of values in this sound that this method changed
   */
  public int limitAmplitude(int limit)
  {
    int counter=0;
    for (int i=0;i<samples.length;i++) {
      if (samples[i]<-limit||samples[i]>limit) {
        samples[i]=Math.clamp(samples[i], -limit, limit);
        counter++;
      }
    }
    return counter;
  }
  
  
  /** 
   * Removes all silence from the beginning of this sound.
   * Silence is represented by a value of 0.
   * Precondition: samples contains at least one nonzero value
   * Postcondition: the length of samples reflects the removeal of starting 
   *                silence
   */
  public void trimSilenceFromBeginning()
  {
    int zeros=0;
    for (int i:samples) {
      if (i!=0) {break;}
      zeros++;
    }
    if (zeros==0) {return;}
    int[] newSample = new int[samples.length-zeros];
    for (int i=zeros;i<samples.length;i++) {
      newSample[i-zeros]=samples[i];
    }
    samples=newSample;
  }
  
  
  /** 
   * Returns all sound samples as a string.
   * Not included in the original AP question.
   * 
   * @return a string representation of the object
   */
  public String toString() {
    String output = "";
    for (int item : samples) {
      output += item + "\t";
    }
    return output;
  }
  
}