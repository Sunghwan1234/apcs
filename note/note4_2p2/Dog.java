package note4_2p2;

/**
 * A dog has a number of chracteristics, can bark, and be fed.
 */
public class Dog {
  private String breed = null;
  private int age = 0;
  private double weight = 0.0;
  private String color = null;
  private String name = null;
  
  /** 
   * Default constructor initializes a newly constructed Dog object.
   * This is a default constructor because it takes no parameters.
   */
  public Dog() {
    breed = "Schnauzer";
    age = 10;
    weight = 15.2;
    color = "gray";
    name = "Fido";
  }
  
  /** 
   * Initializes a newly constructed Dog object to given parameter values.
   * 
   * @param aBreed   the breed
   * @param anAge    the current age
   * @param aWeight  the current weight
   * @param aColor   the coat color
   * @param aName    the name
   */
  public Dog(String aBreed, int anAge, double aWeight, String aColor, String aName) {
    breed = aBreed;
    age = anAge;
    weight = aWeight;
    color = aColor;
    name = aName;
  }
  
  /** 
   * Prints out bark of this Dog.
   */
  public void bark() {
    System.out.println(name + " says \"bark!\"");
  }
  
  /** 
   * Checks to see if the Dog is a puppy.
   *
   * @return  true if age is less than 4;
   *          false otherwise
   */
  public boolean isPuppy() {
    if (age < 4) {
      return true;
    } else {
      return false;
    }
  }
  
  /** 
   * Feeds this Dog by adding to weight, dependent on param value.
   * 
   * @param numScoops  the number of scoops to be fed to this dog
   */
  public void feed(int numScoops) {
    if (numScoops > 2) {
      weight = weight + 0.02;
    } else {
      weight = weight + 0.01;
    }
  }
  
  /** 
   * Returns name, age, color, breed, and weight of this Dog.
   * 
   * @return  a string representation of the object
   */
  public String toString() {
    String output = name + " is a " + age + " year old " + color + " " + breed;
    output += "\nthat weighs " + weight;
    return output;
  }
  
}