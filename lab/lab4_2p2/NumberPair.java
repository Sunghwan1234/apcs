package lab.lab4_2p2;

public class NumberPair {
  private final double num1, num2;
  public NumberPair(double n1, double n2) {
    num1=n1; num2=n2;
  }
  public double getNum1() {
    return num1;
  }
  public double getNum2() {
    return num2;
  }
  public double calculateArithmeticMean() {
    return (num1+num2)/2;
  }
  public double calculateGeometricMean() {
    return Math.sqrt(num1*num2);
  }
  public double calculateHypotenuse() {
    return Math.sqrt(num1*num1+num2*num2);
  }
  public boolean isMadeOfInts() {
    return num1==Math.floor(num1)&&num2==Math.floor(num2);
  }
  public String toString() {
    return "For nums "+num1+", "+num2+"\n"
      +"The arithmetic mean is "+calculateArithmeticMean()
      +"\nThe geometric mean is "+calculateGeometricMean()
      +"\nThe hypotenuse is "+calculateHypotenuse();
  }
}
