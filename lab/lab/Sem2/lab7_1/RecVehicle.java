package lab.lab.Sem2.lab7_1;

/**
 * A rec (recreational) vehicle is any mode of transportation used more for fun
 * than function.
 */
public class RecVehicle {
  private String name = null;
  private double cost = -1;
  private int inventory = -1;

  /**
   * Constructs a RecVehicle object by setting instance variable values.
   * 
   * @param name      the brand/model of this boat
   * @param cost      the list price of this boat
   * @param inventory the number this boat on the lot
   */
  public RecVehicle(String name, double cost, int inventory) {
    this.name = name;
    this.cost = cost;
    this.inventory = inventory;
  }

  /**
   * Returns the name of this recreational vehicle.
   * 
   * @return the name of this recreational vehicle
   */
  public String getName() {
    return name;
  }

  /**
   * Revises the name of this recreational vehicle.
   * 
   * @param name the revised name of this recreational vehicle
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Returns the cost of this recreational vehicle.
   * 
   * @return the cost of this recreational vehicle
   */
  public double getCost() {
    return cost;
  }

  /**
   * Revises the list price of this recreational vehicle.
   * 
   * @param cost the revised list price of this recreational vehicle
   */
  public void setCost(double cost) {
    this.cost = cost;
  }

  /**
   * Returns the inventory of this recreational vehicle.
   * 
   * @return the inventory of this recreational vehicle
   */
  public int getInventory() {
    return inventory;
  }

  /**
   * Revises the inventory of this recreational vehicle.
   * 
   * @param inventory the revised number of this vehicle on the lot
   */
  public void setInventory(int inventory) {
    this.inventory = inventory;
  }

  /**
   * Returns a string containing name, cost, and inventory of this recreational
   * vehicle.
   *
   * @return a string representation of the object
   */
  public String toString() {
    return name + " at $" + cost + ", " + inventory + " on hand";
  }

}