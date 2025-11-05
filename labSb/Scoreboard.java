package labSb;

public class Scoreboard {
  private String team1, team2;
  private int team1Score=0, team2Score=0;
  private boolean t1Active=true;
  

  public Scoreboard(String team1, String team2) {
    this.team1 = team1;
    this.team2 = team2;
  }
  public void recordPlay(int pointsScored) {
    if (t1Active) {
      team1Score+=pointsScored;
    } else {
      team2Score+=pointsScored;
    }
    if (pointsScored==0) {
      t1Active=!t1Active;
    }
  }
  public String getScore() {
    return team1Score+"-"+team2Score+"-"+(t1Active?team1:team2);
  }
}
