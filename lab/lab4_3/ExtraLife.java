package lab.lab4_3;

import java.util.Scanner;

public class ExtraLife {
  double donation=0;
  String name, msg;
  boolean fee=false;

  public ExtraLife(double d, String n, String m) {
    donation=d; name=n; msg=m;
  }

  public ExtraLife(double d, String n) {
    donation=d; name=n; msg="";
  }
  public ExtraLife(double d) {
    donation=d; name="Anonymous";
  }
  public void coverServiceFee() {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Donate: ");
    double f=scanner.nextDouble();
    fee=true;
    if (fee) {donation+=f;}
    scanner.close();
  }
  public void coverServiceFee(boolean cover) {
    fee=cover;
    if (fee) {donation+=3.5;}
  }
  public double getDonation() {
    return donation;
  }
  public String getMsg() {
    return msg;
  }
  public String getName() {
    return name;
  }
  
  public String toString() {
    return "Thank you "+name+" For the donation of "+donation+(fee?" and for covering the fee.":"");
  }
}
