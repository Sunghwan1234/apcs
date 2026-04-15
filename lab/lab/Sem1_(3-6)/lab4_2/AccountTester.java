package lab4_2;
/**
 * AccuntTester contains a main method to test an Account object.
 * 
 * The tester constructs an account and invokes the deposit and addInterest
 * methods, printing the results using the getName, getBalance, and toString methods.
 */
public class AccountTester {
  public static void main(String[] args) {
    Account demoAccount1 = new Account("Amy Anderson", 55234, 350.00); // demonstrates constructor 
    demoAccount1.deposit(25.50); // demonstrates deposit method without use of return value
    // demonstrates getName and getBalance methods
    System.out.println(demoAccount1.getName() + "'s account balance after deposit: " + demoAccount1.getBalance() + "\n");
    
    demoAccount1.addInterest(); // demonstrates addInterest method
    System.out.println(demoAccount1.getName() + "'s account balance after interest: " + demoAccount1.getBalance() + "\n");
    
    double total = demoAccount1.deposit(50); // demonstrates use of return value of deposit method
    System.out.println(demoAccount1.getName() + "'s account balance after deposit: " + total + "\n");
    
    System.out.println(demoAccount1); // demonstrate toString method
    
    // To demonstrate the power of Object-Oriented Programming, uncomment the following lines to
    // see how another object can be constructed and run using the same Account class code
   Account demoAccount2 = new Account("Sam Smith", 78317, 62.56); // demonstrates constructing another account
   demoAccount1.addInterest(); // demonstrates addInterest method
   total = demoAccount2.deposit(100.00); // demonstrates use of return value of deposit method
   System.out.println("\n--------------\n\n" + demoAccount2.getName() + "'s account balance after deposit: " + total);
   demoAccount2.deposit(45.12); // demonstrates deposit method without use of return value
    
  }
  
}