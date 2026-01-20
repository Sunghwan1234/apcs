package AP.SelfDivisor;

/**
 * SelfDivisor contains two class methods to analyze integers. An integer is a
 * self divisor if it is divisible by each of its digits.
 */
public class SelfDivisor {
  /** 
   * Returns true if positive integer number is divisible by each of its digits; 
   * otherwise returns false.
   * 
   * @param number the number to be tested.
   * @return true if every decimal digit of number is a divisor of number;
   *         false otherwise
   */
  public static boolean isSelfDivisor(int number)
  {
    for (int i=0;i<Math.log10(number);i++) {
      if ((int)(number/Math.pow(10,i))%10==0) {
        return false;
      }
      if (number % ((int)(number/Math.pow(10,i))%10)==0) {

      } else {
        return false;
      }
    }
    return true;
  }
  
  
  /** 
   * Returns array of the first num self divisors greater than or equal to start.
   * Precondition: start > 0
   * Precondition: num > 0
   * 
   * @param start starting point for values to be checked
   * @param num   the size of the array to be returned
   * @return an array containing the first num integers >= start that are self-divisors
   */
  public static int[] firstNumSelfDivisors(int start, int num)
  {
    int[] arr = new int[num];
    int arrIndex = 0;
    for (int i=start;arrIndex<num;i++) {
      if (isSelfDivisor(i)) {
        arr[arrIndex]=i;
        arrIndex+=1;
      }
    }
    return arr;
  }
  
  public static int digit(int n, int digit) {
      return (int)(n/Math.pow(10,digit))%10;
  }
}
