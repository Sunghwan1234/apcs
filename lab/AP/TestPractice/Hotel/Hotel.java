package lab.AP.TestPractice.Hotel;

import java.util.ArrayList;

/**
 * A hotel contains the rooms and the waiting list for those rooms.  Rooms can be 
 * requested and cancelled.
 */
public class Hotel {
  /* Each element corresponds to a room in the hotel;
   * if rooms[index] is null, the room is empty;
   * otherwise, it contains a reference to the Reservation for that room,
   * such that rooms[index].getRoomNumber() returns index.
   */
  private Reservation[] rooms;
  
  /* Contains names of guests who have not yet been
   * assigned a room because all rooms are full.
   */
  private ArrayList<String> waitList;
  
  /**
   * Constructs a Hotel object by instantiating rooms array and waitList 
   * ArrayList.
   * Not included in the original AP question.
   * 
   * @param totalRooms  the number of rooms in the hotel
   */
  public Hotel(int totalRooms) {
    rooms = new Reservation[totalRooms];
    waitList = new ArrayList<String>();
  }
  
  /** 
   * If there are any empty rooms (rooms with no reservation), then creates a
   * reservation for an empty room for the specified guest and returns the new
   * Reservation; otherwise, adds the guest to the end of waitList and returns
   * null.
   * 
   * @param guestName the name of the one requesting the room
   * @return the reservation for the requested room, if available
   */
  public Reservation requestRoom(String guestName)
  {
    for (int i=0;i<rooms.length;i++) {
      if (rooms[i]==null) {
        rooms[i] = new Reservation(guestName, i);
        return rooms[i];
      }
    }
    waitList.add(guestName);
    return null;
  }
  
  
  /** 
   * Releases the room associated with parameter res, effectively canceling the
   * reservation; if any names are stored in waitList, removes the first name and 
   * creates a Reservation for this person in the room reserved by res; returns 
   * that new Reservation; if waitList is empty, marks the room specified by res
   * as empty and returns null.
   * Precondition: res is a valid Reservation for some room in this hotel
   * 
   * @param res the reservation to be cancelled
   */
  public Reservation cancelAndReassign(Reservation res)
  {
    int i = res.getRoomNumber();
    if (waitList.size()>0) {
      rooms[i] = new Reservation(waitList.get(0), i);
      waitList.remove(0);
    } else {
      rooms[i]=null;
    }
    return rooms[i];
  }
  
  
  /** 
   * Returns a string representation of the object.
   * Not included in the original AP question.
   * 
   * @return a string representation of the object
   */
  public String toString() {
    String output = "";
    for (Reservation item : rooms) {
      if (item == null) {
        output += "null\n";
      } else {
        output += item.getGuestName() + ": " + item.getRoomNumber() + "\n";
      }
    }
    output += "wait list: " + waitList;
    return output;
  }
  
}