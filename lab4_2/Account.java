package lab4_2;
/**
 * An account is comprised of the rate, owner's name, account number, and
 * balance, which money can be deposited, earn interest, and be withdrawn.
 */
public class Account {
  // instance variables
  public final double RATE = 0.035; // interest rate of 3.5%
  private String name = null;
  private int accountNumber = 0;
  private double balance = 0.0;

  /**
   * Constructs an Account object by storing three parameters in three instance
   * variables.
   * 
   * @param aName           the initial name of the owner of this account
   * @param anAccountNumber the account number
   * @param aBalance        the initial balance
   */
  public Account(String aName, int anAccountNumber, double aBalance) {
    name = aName;
    accountNumber = anAccountNumber;
    balance = aBalance;
  }

  /**
   * Returns the account owner's name. @return the name of the owner of this account
   */
  public String getName() {
    return name;
  }

  /* getAccountNumber method, to be written in 4.2 Lab */
  public int getAccountNumber() {return accountNumber;}

  /**
   * Returns current balance. @return the current balance
   */
  public double getBalance() {
    return balance;
  }

  /**
   * Validates the transaction, then deposits the specified amount into the
   * account, and returns the new balance.
   * 
   * @param amount the amount to be deposited
   * @return the balance after deposit
   */
  public double deposit(double amount) {
    if (amount < 0) {
      System.out.println("\nError: Deposit amount is invalid.");
    } else {
      balance = balance + amount;
    }
    return balance;
  }

  /* withdraw method, to be written in 4.2 Lab */
  public double withdraw(double amount) {
    if (amount>balance) {
      System.out.println("you broke asf");
    } else {
      balance -= amount;
    }
    return balance;
  }

  /**
   * Adds interest to the account and returns nothing.
   */
  public void addInterest() {
    balance += (balance * RATE);
  }

  /* toString method, to be written in 4.2 Lab */
  public String toString() {
    return name+" #"+accountNumber+" ($"+balance+")";
  }
  
}