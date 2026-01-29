package lab4_3;

/**
 * ExtraLifeTester contains a main method to test ExtraLife objects.
 * 
 * The tester constructs three ExtraLife objects, invokes the coverServiceFee,
 * getDonation, and toString methods, and prints the results.
 */
public class ExtraLifeTester {
  public static void main(String[] args) {
    // tests constructor with three parameters
    ExtraLife donor1 = new ExtraLife(123456.78, "Link", "Thanks for helping the kids!");
    
    // tests overloaded serviceFee method
    donor1.coverServiceFee(true);
    
    // tests toString method
    System.out.println(donor1 + "\n");
    
    // tests constructor with two parameters
    ExtraLife donor2 = new ExtraLife(678924.13, "Zelda");
    
    donor2.coverServiceFee(false);
    System.out.println(donor2 + "\n");
    
    // tests constructor with one parameter
    ExtraLife donor3 = new ExtraLife(100);
    
    // tests default serviceFee method
    donor3.coverServiceFee();
    System.out.println(donor3 + "\n");
    
    // tests getDonation method
    double total = donor1.getDonation() + donor2.getDonation() + donor3.getDonation();
    System.out.println("Total donations (including service fees): " + total);
  }
}
