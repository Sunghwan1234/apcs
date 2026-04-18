package lab.AP.TestPractice.Hotel;

/**
 * A reservation contains the name and room number of a guest in a hotel.
 */
public class Reservation {
  private String guestName = null;
  private int roomNumber = -1;
  
  /** 
   * Constructs a Reservation object.
   * Not implemented in the original AP question.
   * 
   * @param guestName   the name of the one holding the reservation
   * @param roomNumber  the room being reserved
   */
  public Reservation(String guestName, int roomNumber) {
    this.guestName = guestName;
    this.roomNumber = roomNumber;
  }
  
  /**
   * Returns the room number being reserved.
   * Not included in the original AP question.
   * 
   * @return  the room number being reserved
   */
  public int getRoomNumber() {
    return roomNumber;
  }
  
  /**
   * Returns the name of the one holding the reservation.
   * Not included in the original AP question.
   * 
   * @return  the name of the one holding the reservation
   */
  public String getGuestName() {
    return guestName;
  }

  @Override
  public String toString() {
      return guestName+" "+getRoomNumber();
  }
  
  @Override
  public boolean equals(Object obj) {
    if (obj==null) {return false;}
    return toString() == obj.toString();
  }
}