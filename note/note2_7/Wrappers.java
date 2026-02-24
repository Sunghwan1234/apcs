package note.note2_7;

// Comment out the lines that cause errors.

/**
 * Wrappers contains a main method to explore the Integer and Double classes.
 */
public class Wrappers {
  public static void main(String[] args) { 
    // instantiates Integer and Double objects using constructors:
    Integer a = new Integer(40);
    Double ww = new Double(35);
    
    // or instantiates Integer and Double objects using autoboxing of primitive types:
    Integer b = 25;
    Double xx = 25.0;
    Double yy = 10.0;
    
    System.out.println("Tests the Integer constants and intValue method:");
    System.out.println(Integer.MIN_VALUE);
    System.out.println(Integer.MAX_VALUE);
    System.out.println(a.intValue());
    System.out.println(b.intValue());
    
    System.out.println("\nTests the Double doubleValue method:");
    System.out.println(ww.doubleValue());
    System.out.println(xx.doubleValue());
    
    System.out.println("\nTests <, >, and =");
    System.out.println(a > b);
    System.out.println(b < ww);
    System.out.println(a == b);
    System.out.println(a - 15 == b);
    System.out.println(xx == ww);
    System.out.println(xx + 10 == ww);
    System.out.println(b.intValue() == xx);
    
    System.out.println("\nTests the Integer compareTo method:");
    System.out.println(a.compareTo(b));
    System.out.println(a.compareTo(10));
    System.out.println(a.compareTo(a));
    System.out.println(a.compareTo((int) ww.doubleValue()));
    
    System.out.println("\nTests the Double compareTo method:");
    System.out.println(ww.compareTo(xx));
    System.out.println(ww.compareTo((double) 100));
    System.out.println(ww.compareTo(100.0));
    System.out.println(ww.compareTo(35.0));
  //  System.out.println(ww.compareTo(b));
    
    System.out.println("\nTests the Integer equals method:");
    System.out.println(a.equals(b));
    System.out.println(a.equals(40));
    System.out.println(a.equals((int) ww.doubleValue()));
    
    System.out.println("\nTests the Double equals method:");
    System.out.println(ww.equals(xx));
    System.out.println(ww.equals((double)35));
    System.out.println(ww.equals(35.0));
    System.out.println(xx.equals((double)b));
    
    System.out.println("\nTests the toString methods:");
    System.out.println(a.toString());
    System.out.println(b);
    System.out.println(ww.toString());
    System.out.println(xx);
  }
}
