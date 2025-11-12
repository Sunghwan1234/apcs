package lab.CombinedTable;

public class CombinedTable {
  private SingleTable t1, t2;
  public CombinedTable(SingleTable table1, SingleTable table2) {
    t1=table1; t2=table2;
  }

  public boolean canSeat(int people) {return t1.getNumSeats()+t2.getNumSeats()-2>=people;}
  public double getDesirability() {
    if (t1.getHeight()==t2.getHeight()) {
      return (t1.getViewQuality()+t2.getViewQuality())/2;
    } else {
      return (t1.getViewQuality()+t2.getViewQuality())/2-10;
    }
  }

}
