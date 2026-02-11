public class Candy {
  private String flavor = null;
  
  /**
   * Instantiates flavor of this piece of candy.
   * Not included in the original AP question.
   * 
   * @param flavor  the flavor of this piece of candy
   */
  public Candy(String flavor) {
    this.flavor = flavor;
  }

  /** 
   * Returns a String representing the flavor of this piece of candy.
   * Not implmented in the original AP question.
   * 
   * @return  returns the string representaiton of this piece of candy
   */
  public String getFlavor() {
    return flavor;
  }

  /** 
   * Returns a string representation of the object.
   * Not included in the original AP question.
   * 
   * @return  a string representation of the object
   */
  public String toString() {
    return "Candy object: " + flavor;
  }
}
