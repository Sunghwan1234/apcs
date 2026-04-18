package lab.AP.TestPractice.Hotel;

/**
 * HotelTester contains a main method to test a Hotel object.
 * 
 * The tester constructs a Hotel, invokes the requestRoom and 
 * cancelAndReassign methods, and prints the results.
 */
public class HotelTester {
  public static void main(String[] args) {
    Hotel disney = new Hotel(4);
    Reservation request01 = disney.requestRoom("Minnie");        // Puts Minnie in room 0
    Reservation request02 = disney.requestRoom("Goofy");         // Puts Goofy in room 1
    Reservation request03 = disney.requestRoom("Daisy");         // Puts Daisy in room 2
    System.out.println(disney + "\n");
    
    disney.cancelAndReassign(request02);
    System.out.println(disney + "\n");                           // Removes Goofy
    
    Reservation request04 = disney.requestRoom("Pluto");         // Puts Pluto in room 1
    Reservation request05 = disney.requestRoom("Mickey");        // Puts Mickey in room 3
    Reservation request06 = disney.requestRoom("Donald");        // Puts Donald 1st on wait list
    Reservation request07 = disney.requestRoom("Pete");          // Puts Pete 2nd on wait list
    System.out.println(disney + "\n");
    
    Reservation request08 = disney.cancelAndReassign(request03); // Removes Daisy and puts Donald in room 2
    System.out.println(disney + "\n");
    
    Reservation request09 = disney.cancelAndReassign(request01); // Removes Minnie and puts Pete in room 0
    System.out.println(disney + "\n");
    
    Reservation request10 = disney.cancelAndReassign(request09); // Removes Pete
    System.out.println(disney + "\n"); 
    
  }
}