package AP.Sem2.Trail;

/**
 * TrailTester contains a main method to test a Trail object.
 *
 * The tester constructs a new Trail object, invokes the isLevelTrailSegment
 * and toString methods, and prints the results.
 */
public class TrailTester {
  public static void main(String[] args) {
    int[] myMarkers = {100, 150, 105, 120, 90, 80, 50, 75, 75, 70, 80, 90, 100};
    Trail myTrail = new Trail(myMarkers);
    
    System.out.println(myTrail.isLevelTrailSegment(7, 10)); // Should return true
    System.out.println(myTrail.isLevelTrailSegment(2, 12)); // Should return false
    
    System.out.println(myTrail.isDifficult()); // Should return true
  }
}