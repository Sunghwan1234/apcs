package lab.lab4_5p2;

/**
 * ComputerTester contains a main method to test Computer and HardDrive objects.
 * 
 * The tester constructs two Computer objects and one HardDrive object, invokes
 * the getDrive, findBestDrive, and toString methods, and prints the results.
 */
public class ComputerTester {
  public static void main(String[] args) {
    // tests Computer default constructor
    Computer myComputer1 = new Computer();
    
    // tests Computer overloaded constructor
    HardDrive myDrive2 = new HardDrive(2000);
    Computer myComputer2 = new Computer("AMD Ryzen 7 1700X 3.4 GHz 8-Core", myDrive2);
    
    // tests Computer getDrive and HardDrive toString method
    System.out.println(myComputer1.getDrive() + "\n");
    
    // tests Computer toString method
    System.out.println(myComputer1 + "\n");
    System.out.println(myComputer2 + "\n");
    
    // tests getBestDrive method
    System.out.println("The best hard drive's " + myComputer1.findBestDrive(myComputer2));
  }
}
