package AP.Sem2.BatteryCharger;
/**
 * A battery charger calculates the charging cost at a given start time and 
 * duration, as well as the optimal start time for a given chrarging duration.
 */
public class BatteryCharger {
  /** 
   * rateTable has 24 entries representing the charging costs for hours 0 through 23.
   */
  private int[] rateTable;
  
  /**
   * Instantiates rate table.
   * Not included in the original AP question.
   * 
   * @param rateTable the array of charging costs for hours 0 through 23.
   */
  public BatteryCharger(int[] rateTable) {
    this.rateTable = rateTable;

    
    System.out.println(getChargingCost(12,1));
    System.out.println(getChargingCost(0,2));
  }
  
  /**
   * Determines the total cost to charge the battery starting at the beginning of
   * startHour.
   * Precondition: 0 <= startHour <= 23
   * Precondition: chargeTime > 0
   * 
   * @param startHour  the hour at which the charge period begins
   * @param chargeTime the number of hours the battery needs to be charged
   * @return the total cost to charge the battery
   */
  private int getChargingCost(int startHour, int chargeTime)
  {
    int cost=0;
    for (int i=startHour; i<((startHour+chargeTime)); i++) {
      int h = i%24;
      cost+=rateTable[h];
    }
    return cost;
  }
  
  
  /** 
   * Determines start time to charge the battery at the lowest cost for the given charge time.
   * Precondition: chargeTime > 0 
   * 
   * @param chargeTime the number of hours the battery needs to be charged
   * @return an optimal start time, with 0 <= returned value <= 23
   */
  public int getChargeStartTime(int chargeTime)
  {
    int lowestCost=99999999, lowestIndex=-1;
    for (int i=0; i<rateTable.length; i++) {
      int total = getChargingCost(i,chargeTime);
      if (total<lowestCost) {
        lowestCost = total;
        lowestIndex = i;
      }
    }
    System.out.println("MinCost: "+lowestCost);
    return lowestIndex;
  }
}
