package lab.lab.Sem2.lab7_1;

/**
 * ATVTester contains a main method to test an ATV object.
 * 
 * The tester constructs an ATV object, invokes the getCost, toString, setTransmission,
 * setCost, and setInventory methods, and prints the results.
 */
public class ATVTester {
  public static void main(String[] args) {
    ATV fourWheeler1 = new ATV("4-Wheeler", 1499.95, 5, "manual");

    System.out.println("Four Wheeler cost: " + fourWheeler1.getCost()); // Note: this is using the RecVehicle method
    System.out.println("Four Wheeler toString: " + fourWheeler1); // Note: this is using the overriding ATV method
    
    fourWheeler1.setTransmission("automatic"); // Note: this is using the ATV method
    fourWheeler1.setCost(1295.99); // Note: this is using the RecVehicle method
    fourWheeler1.setInventory(3); // Note: this is using the RecVehicle method
    System.out.println("\nFour Wheeler toString: " + fourWheeler1); // Note: this is using the overriding ATV method
  }
}