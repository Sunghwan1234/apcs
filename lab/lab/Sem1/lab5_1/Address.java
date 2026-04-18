package lab5_1;

/**
 * An address is the mailing address, comprised of street, city, state, and zip
 * code.
 */
public class Address {
  // instance variables
  private String street = null;
  private String city = null;
  private String state = null;
  private int zipCode = 0;

  /**
   * Constructs an Address object by initializing instance variables with
   * parameter values.
   *
   * @param street  the road, avenue, drive, etc.
   * @param city    the city
   * @param state   the U.S. state
   * @param zipCode the five-digit zip code
   */
  public Address(String street, String city, String state, int zipCode) {
    this.street = street;
    this.city = city;
    this.state = state;
    this.zipCode = zipCode;
  }

  /**
   * Returns the street name of this address.
   *
   * @return the street name of this address
   */
  public String getStreet() {
    return street;
  }

  /**
   * Revises street name.
   *
   * @param street the new street name
   */
  public void setStreet(String street) {
    this.street = street;
  }

  /**
   * Returns the city of this address.
   *
   * @return the city of this address
   */
  public String getCity() {
    return city;
  }

  /**
   * Revises city.
   *
   * @param aCity the new city
   */
  public void setCity(String city) {
    this.city = city;
  }

  /**
   * Returns the U.S. state of this address.
   *
   * @return the U.S. state of this address
   */
  public String getState() {
    return state;
  }

  /**
   * Revises U.S. state.
   *
   * @param state the new U.S. state
   */
  public void setState(String state) {
    this.state = state;
  }

  /**
   * Returns the zip code of this address.
   *
   * @return the zip code of this address
   */
  public int getZipCode() {
    return zipCode;
  }

  /**
   * Revises zip code.
   *
   * @param aZipCode the new five-digit zip code
   */
  public void setZipCode(int zipCode) {
    this.zipCode = zipCode;
  }

  /**
   * Returns postal address, formatted correctly for mailing
   * 
   * @return a string representation of the object
   */
  public String toString() {
    return street + "\n" + city + ", " + state + " " + zipCode;
  }

}
