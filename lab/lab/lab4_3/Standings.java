package lab4_3;

public class Standings {
  private String name;
  private int wins=0, losses=0;
  Standings(String n, int w, int l) {
    this.name=n;
    this.wins=w;
    this.losses=l;
  }
  public Standings(String n) {
    this.name=n;
  }
  public String getName() {return name;}
  public int getWins() {return wins;}
  public int getLosses() {return losses;}

  public void addWins() {wins++;}
  public void addLosses() {losses++;}
  public void addWins(int n) {wins+=n;}
  public void addLosses(int n) {losses+=n;}

  public double findWinPercentage() {
    if (wins>0||losses>0) {
      return (double)wins/(wins+losses);
    } else {
      return 0;
    }
  }
  public String toString() {
    return "Team "+name+" | Games: "+(wins+losses)+" W/L "+wins+"/"+losses+" %: "+findWinPercentage();
  }
}
