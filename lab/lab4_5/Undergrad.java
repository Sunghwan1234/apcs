package lab.lab4_5;

/**
 * An undergrad is a college student who has not yet completed a bachelor's degree.
 */
public class Undergrad {
  // instance variables
  private String name = null;
  private int test1 = 0;
  private int test2 = 0;
  private int test3 = 0;
  private int testsTaken = 0;
  
  /** 
   * Constructs an Undergrad object by initializing name.
   *
   * @param aName  the name of this undergrad
   */
  public Undergrad(String aName)
  {name = aName;}
  
  
  /** 
   * Constructs an Undergrad object by initializing name and one test score.
   * 
   * @param aName   the name of this undergrad
   * @param aTest1  the score for the first test
   */
  public Undergrad(String aName, int aTest1)
  {
    name=aName;
    test1=aTest1;
    testsTaken=1;
  }
  
  
  /** 
   * Constructs an Undergrad object by initializing name and two test scores.
   * 
   * @param aName   the name of this undergrad
   * @param aTest1  the score for the first test
   * @param aTest2  the score for the second test
   */
  public Undergrad(String aName, int aTest1, int aTest2) 
  {
    name=aName;
    test1=aTest1;
    test2=aTest2;
    testsTaken=2;
  }
  
  
  /** 
   * Constructs an Undergrad object by initializing name and three test scores.
   * 
   * @param aName   the name of this undergrad
   * @param aTest1  the score for the first test
   * @param aTest2  the score for the second test
   * @param aTest3  the score for the third test
   */
  public Undergrad(String aName, int aTest1, int aTest2, int aTest3)
  {
    name=aName;
    test1=aTest1;
    test2=aTest2;
    test3=aTest3;
    testsTaken=3;
  }
  
  
  /**
   * Returns this undergad's name.
   * 
   * @return  the name of this undergrad
   */
  public String getName() {
    return name;
  }
  
  /** 
   * Returns the first test score.
   *
   * @return  the first test score
   */
  public int getTest1() {
    return test1;
  }
  
  /** 
   * Returns the second test score.
   *
   * @return  the second test score
   */
  public int getTest2() {
    return test2;
  }
  
  /** 
   * Returns the third test score.
   *
   * @return  the third test score
   */
  public int getTest3() {
    return test3;
  }
  
  /** 
   * Adds new test to appropriate instance variable, if possible.
   * 
   * @param nextTest  the next test score to be entered
   */
  public void addTest(int nextTest)
  {
    if (testsTaken==3) {
      System.out.println("no");
      return;
    }
    if (testsTaken==0) {
      test1=nextTest;
    } else if (testsTaken==1) {
      test2=nextTest;
    } else if (testsTaken==2) {
      test3=nextTest;
    }
    testsTaken++;
  }
  
  
  /**
   * Returns test average if number of tests is greater than 0; otherwise returns 0.0.
   * 
   * @return  average of all test scores, if there is at least one test;
   *          otherwise 0.0
   */
  public double calculateAverage() 
  {
    if (testsTaken==0) {return 0;} else {
      return ((double)(test1+test2+test3))/testsTaken;
    }
  }
  
  
  /** 
   * Returns the name and current average of this undergrad.
   * 
   * @return  a string representation of the object
   */
  public String toString() {
    return "Name: " + name + ", Current Average: " + calculateAverage();
  }
  
}
