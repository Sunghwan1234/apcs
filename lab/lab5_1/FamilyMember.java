package lab.lab5_1;

/**
 * A family member has first and last name, an address, and access to a value
 * for the total savings of all members of the family.
 */
public class FamilyMember {
  // instance variables
  private String firstName = null;
  private String lastName = null;
  
  // class variables
  private static Address location = null;
  private static double totalSavings = 0.0;
  
  /**
   * Initializes first name, last name, and address.  Adds balance in this family member's
   * ledger to the total savings, if applicable.
   * 
   * @param firstName the family member's first name
   * @param lastName  the family member's last name
   * @param location  the address of the family's residence
   * @param ledger    the family member's bank account
   */
  public FamilyMember(String firstName, String lastName, Address location, Account ledger)
  {
    this.firstName=firstName;
    this.lastName=lastName;
    if (FamilyMember.location==null) {
      FamilyMember.location=location;
    }
    if (ledger!=null) {
      FamilyMember.totalSavings+=ledger.getBalance();
    }
  }
  
  
  /**
   * Returns first name.
   *
   * @return first name
   */
  public String getFirstName() {
    return firstName;
  }
  
  /**
   * Revises first name.
   *
   * @param firstname the new first name
   */
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }
  
  /**
   * Returns last name.
   *
   * @return last name
   */
  public String getLastName() {
    return lastName;
  }
  
  /**
   * Revises last name.
   *
   * @param lastname the new last name
   */
  public void setLastName(String lastName) {
    this.lastName = lastName;
  }
  
  /**
   * Returns address.
   *
   * @return an Address object for this family member
   */
  public Address getLocation() {
    return location;
  }
  
  /** 
   * Sets address.
   * 
   * @param location the new address for this family member
   */
  public void setLocation(Address location) {
    FamilyMember.location = location; // or this.location = location
  }
  
  /**
   * Returns all family members' net worth. 
   *
   * @return  the combined net worth of all family members
   */
  public double getTotalSavings() {
    return totalSavings;
  }
  
  /**
   * Returns the first name, last name, address of this family member,
   * as well as the net worth of all family members.
   * 
   * @return a string representation of the object
   */
  public String toString() {
    String result = firstName + " " + lastName + "\n";
    result += location + "\n";
    result += "Family total savings: " + totalSavings;
    return result;
  }
  
}
