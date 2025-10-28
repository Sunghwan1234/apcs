/**
 * FakeClass is used to demonstrate visibility modifiers
 */
public class FakeClass {
  public int overt = 0;
  private int hidden = -1;
  
  /**
   * Constructs a FakeClass object by initializing instance variables.
   * 
   * @param anOvert  the public variable value
   * @param aHidden  the private variable value
   */
  public FakeClass(int anOvert, int aHidden) {
    overt = anOvert;
    hidden = aHidden;
  }
  
  /**
   * Returns public instance variable overt.
   * 
   * @return  public overt value, if possible
   */
  public int getPublicVariable() {
    return overt;
  }
  
  /**
   * Returns private instance variable hidden.
   * 
   * @return  private hidden value, if possible
   */
  public int getPrivateVariable() {
    return hidden;
  }
  
  /**
   * Prints "something".
   */
  private void saySomething() {
    System.out.println("something");
  }
  
  /**
   * Prints "something" repeatedly
   */
  public void repeatedlySaySomething() {
    for (int i = 0; i < 5; i++) {
      saySomething();
    }
  }
  
}