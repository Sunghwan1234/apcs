package AP.CombinedTable;

/** 
 * CombinedTableTester contains a main method to test a CombinedTable object.
 * 
 * The tester constructs three SingleTable objects, two CombinedTable objects,
 * invokes the canSeat and getDesirability methods, and prints the resuls.
 */
public class CombinedTableTester {
  public static void main(String[] args) {
    SingleTable t1 = new SingleTable(4, 74, 60.0);
    SingleTable t2 = new SingleTable(8, 74, 70.0);
    SingleTable t3 = new SingleTable(12, 76, 75.0);
    
    CombinedTable c1 = new CombinedTable(t1, t2);
    System.out.println(c1.canSeat(9));
    System.out.println(c1.canSeat(11));
    System.out.println(c1.getDesirability());
    
    CombinedTable c2 = new CombinedTable(t2, t3);
    System.out.println("\n" + c2.canSeat(18));
    System.out.println(c2.getDesirability());
    t2.setViewQuality(80.0);
    System.out.println(c2.getDesirability());
  }
}
