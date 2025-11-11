package lab.lab4_3;

/**
 * StandingsTester contains a main method to test Standings objects.
 * 
 * The tester constructs two Standings objects, invokes the getName, findWinPercentage,
 * addWins, addLosses, and toString methods, and prints the results.
 */
public class StandingsTester {
  public static void main(String[] args) {
    // tests constructor with three parameters.
    Standings minn = new Standings("Timberwolves", 6, 4);
    // tests getName and findWinPercentage methods
    System.out.println(minn.getName() + " current winning percentage: " + minn.findWinPercentage());
    // tests default addWins method
    minn.addWins();
    System.out.println(minn.getName() + " current winning percentage: " + minn.findWinPercentage());
    
    // tests default addLosses method
    minn.addLosses();
    // tests toString method
    System.out.println("\n" + minn);
    
    System.out.println("\n----------------------------------------------------\n");
    
    // tests constructor with one parameter
    Standings losAng = new Standings("Lakers");
    // tests getName and findWinPercentage methods
    System.out.println(losAng.getName() + " current winning percentage: " + losAng.findWinPercentage());
    // tests overloaded addWins method
    losAng.addWins(3);
    System.out.println(losAng.getName() + " current winning percentage: " + losAng.findWinPercentage());
    
    // tests overloaded addLosses method
    losAng.addLosses(2);
    // tests toString method
    System.out.println("\n" + losAng);
  }
}
