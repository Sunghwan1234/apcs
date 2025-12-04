package lab.game;

/**
 * A level earns points for the player if it is completed.
 */
/**
 * A game contains three levels that can be completed for points.
 */
public class Game {
  private Level levelOne = null;
  private Level levelTwo = null;
  private Level levelThree = null;
  private boolean bonus = false; // not included in the original AP question
  private int playCount = 0;     // not included in the original AP question

  /**
   * Initializes level instance variables. Each level holds multiple potential
   * values to match each successive example provided in directions for part (a).
   * Postcondition: All instance variables have been initialized.
   * Not implemented in the original AP question.
   */
  public Game() {
    levelOne = new Level(200, new boolean[] {true, true, true, false});
    levelTwo = new Level(100, new boolean[] {true, true, false, true});
    levelThree = new Level(500, new boolean[] {true, false, true, true});
  }

  /**
   * Returns true if this game is a bonus game;
   *         false otherwise.
   * Not implemented in the original AP question.
   */
  public boolean isBonus() {
    bonus = !bonus; // simulates alternating bonus values in examples
    return bonus;
  }

  /**
   * Simulates the play of this Game (consisting of three levels) and updates all 
   * relevant game data to match examples provided for part (b).
   * Not implemented in the original AP question.
   */
  public void play() {
    if (playCount == 0) {        // returns 75 (= 25 * 3)
      levelOne = new Level(25, new boolean[] {true});
      levelTwo = new Level(30, new boolean[] {false});
      levelThree = new Level(20, new boolean[] {false});
    } else if (playCount == 1) { // returns 50
      levelOne = new Level(50, new boolean[] {true}); 
      levelTwo = new Level(30, new boolean[] {false}); 
      levelThree = new Level(20, new boolean[] {true});
    } else if (playCount == 2) { // returns 90 (= 30 * 3)
      levelOne = new Level(30, new boolean[] {true}); 
      levelTwo = new Level(25, new boolean[] {false}); 
      levelThree = new Level(20, new boolean[] {false});
    } else {                     // returns 20
      levelOne = new Level(20, new boolean[] {true}); 
      levelTwo = new Level(30, new boolean[] {false}); 
      levelThree = new Level(25, new boolean[] {true});
    }
    playCount++;
  }                                             

  /**
   * Returns the score earned in the most recently played game, as described in 
   * part (a).
   *
   * @return the most recent game's score
   */
  public int getScore()
  {
    int score=0;
    if (levelOne.goalReached()) {
      score+=levelOne.getPoints();
      if (levelTwo.goalReached()) {
        score+=levelTwo.getPoints();
        if (levelThree.goalReached()) {
          score+=levelThree.getPoints();
        }
      }
    }
    if (isBonus()) {
      score*=3;
    }
    return score;
  }


  /**
   * Simulates the play of num games and returns the highest score earned,
   * as described in part (b).
   * Precondition: num > 0
   * 
   * @return the highest score of num games played
   */
  public int playManyTimes(int num)
  {
    int topScore=0;
    for (int g=0;g<num;g++) {
      play();
      int score = getScore();
      if (score>topScore) {
        topScore=score;
      }
    }
    return topScore;
  }
}