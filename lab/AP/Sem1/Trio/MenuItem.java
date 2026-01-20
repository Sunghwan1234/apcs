package AP.Trio;

/**
 * A menu item is comprised of a name and price of the item.
 */
public interface MenuItem {
  
  /** 
   * Returns the name of the menu item.
   * 
   * @return  the name of the menu item
   */
  public String getName();
  
  /**
   * Returns the price of the menu item.
   * 
   * @return  the price of the menu item
   */
  public double getPrice();
  
}
