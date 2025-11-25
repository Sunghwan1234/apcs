package lab.lab5_1;

/**
 * An account is comprised of the rate, account number, and balance,
 * which money can be deposited, earn interest, and be withdrawn.
 */
public class Account {
  // instance variables
  public final double RATE = 0.035; // interest rate of 3.5%
  private int accountNumber = 0;
  private double balance = 0.0;

  /**
   * Initializes number and current balance.
   * 
   * @param accountNumber the account number
   * @param balance       the initial balance
   */
  public Account(int accountNumber, double balance) {
    this.accountNumber = accountNumber;
    this.balance = balance;
  }

  /**
   * Returns account number.
   * 
   * @return the account number
   */
  public int getAccountNumber() {
    return accountNumber;
  }

  /**
   * Returns current balance.
   * 
   * @return the current balance
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

  /**
   * Validates the transaction, then withdraws the specified amount from the
   * account, along with a $1.50 service fee, and returns the new balance.
   */
  public double withdraw(double amount) {
    if (amount < 0) {
      System.out.println("\nError: Deposit amount is invalid.");
    } else if (balance - amount < 0) {
      System.out.println("Error: Withdrawal requested would result in a negative balance.");
    } else {
      balance = balance - amount - 1.5;
    }
    return balance;
  }

  /**
   * Adds interest to the account and returns nothing.
   */
  public void addInterest() {
    balance += (balance * RATE);
  }

  /**
   * Returns the account number and current balance of this account,
   * as a string.
   *
   * @return a string representation of the object
   */
  public String toString() {
    String output = "";
    output += "Account number: " + accountNumber;
    output += "\nBalance: " + balance;
    return output;
  }

}
