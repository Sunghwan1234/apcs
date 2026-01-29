package lab4_5;

public class Address {
  private String street;
  private String city;
  private String state;
  private int zip;

  public Address(String iStreet, String iCity, String iState, int iZip) {
    street = iStreet;
    city = iCity;
    state = iState;
    zip = iZip;
  }




  public String getCity() {
    return city;
  }
  public String getState() {
    return state;
  }
  public String getStreet() {
    return street;
  }
  public int getZipCode() {
    return zip;
  }

  public void setCity(String city) {
    this.city = city;
  }
  public void setState(String state) {
    this.state = state;
  }
  public void setStreet(String street) {
    this.street = street;
  }
  public void setZipCode(int zip) {
    this.zip = zip;
  }

  public String toString() {
    return street+" "+city+" "+state+" "+zip;
  }
}
