package AP.Sem2.BatteryCharger;

/** 
 * BatteryChargerTester contains a main method to test a BatteryCharger object.
  *
  * The tester constructs a BatteryCharger object, repeatedly invokes the
  * getChargeStartTime method, and prints the results.
  */
public class BatteryChargerTester {
  public static void main(String[] args) {
    int[] table = {50, 60, 160, 60, 80, 100, 100, 120, 150, 150, 150, 200, 
                   40, 240, 220, 220, 200, 200, 180, 180, 140, 100, 80, 60};
    BatteryCharger option1 = new BatteryCharger(table);
    
    System.out.println(option1.getChargeStartTime(1));
    System.out.println(option1.getChargeStartTime(2));
    System.out.println(option1.getChargeStartTime(7));
    System.out.println(option1.getChargeStartTime(30));
  }
}
