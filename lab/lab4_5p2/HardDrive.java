package lab.lab4_5p2;

/**
 * A hard drive has a number of gigabytes of storage.
 */
public class HardDrive {
  // instance variable
  private int memoryInGigabytes = 200;
  
  /** 
   * Default constructor initializes memory to default value.
   */
  public HardDrive() {}
  
  
  /**
   * Overloaded constructor initializes memory to parameter value.
   *
   * @param theMemoryInGigabytes  the number of gigabytes of memory in this hard drive
   */
  public HardDrive(int theMemoryInGigabytes)
  {
    memoryInGigabytes=theMemoryInGigabytes;
  }
  
  
  /**
   * Returns memory in gigabytes.
   *
   * @return  the total amount of memory in gigabytes
   */
  public int getMemory() {
    return memoryInGigabytes;
  }
  
  /**
   * Sets memory to parameter.
   *
   * @param theMemoryInGigabytes  the number of gigabytes of memory in this hard drive
   */
  public void setMemory(int theMemoryInGigabytes) {
    memoryInGigabytes = theMemoryInGigabytes;
  }
  
  /** 
   * Returns text stating the number of gigabytes of memory in this hard drive.
   * 
   * @return  a string representation of the object
   */
  public String toString(){
    return "Hard Drive | GB: "+memoryInGigabytes;
  }
  
  
}
