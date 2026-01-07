package AP.Robot;

/**
 * A robot can move, change direction, and clear a room of items.
 */
public class Robot {
  private int[] hall;
  private int pos;             // current position (tile number) of Robot
  private boolean facingRight; // true means this Robot is facing right
  
  /** 
   * Instantiates the items in the room, as well as the position and 
   * direction of this robot.
   * Not included in the original AP question.
   */
  public Robot(int[] hall, int pos, boolean facingRight) {
    this.hall = hall;
    this.pos = pos;
    this.facingRight = facingRight;
  }
  
  /**
   * Returns true if this Robot has a wall immediately in front of it,
   * so that it cannot move forward; otherwise, returns false.
   * 
   * @return true if the robot cannot move forward;
   *         false otherwise
   */
  private boolean forwardMoveBlocked()
  {return (!facingRight&&pos==0)||(facingRight&&pos==hall.length-1);}
  
  
  /** 
   * Makes one move according to the specifications above and updates the 
   * state of this robot.
   */
  public void move()
  {if (hall[pos]>0) {
      hall[pos]--;
    }
    if (hall[pos]<1) {
      if (forwardMoveBlocked()) {
        facingRight=!facingRight;
      } else {
        if (!facingRight) {
          pos--;
        } else {
          pos++;
        }
      }
    }
    seeProgress();
  }
  
  
  /** 
   * Returns the number of moves made after this robot has removed all items
   * in the hallway.
   * 
   * @return the total number of moves made once the hallway is cleared
   */
  public int clearHall()
  {
    int moves=0;
    while (!hallIsClear()) {
      move();
      moves++;
    }
    return moves;
  }
  
  
  /** 
   * Returns true if the hallway contains no items; otherwise, returns false.
   * Not implemented in the original AP question.
   * 
   * @return true if all items have been removed in the hallway;
   *         false otherwise
   */
  private boolean hallIsClear() {
    for (int item : hall) {
      if (item > 0) {
        return false;
      }
    }
    return true;
  }
  
  /** 
   * Prints a string representation of this robot's progress.
   * Not included in the original AP question.
   */
  private void seeProgress() {
    String output = "0 1 2 3\n";
    for (int item :  hall) {
      output += item + " ";
    }
    output += "\n";
    for (int i = 0; i < pos; i++) {
      output += "  ";
    }
    if (facingRight) {
      output += ">\n";
    } else {
      output += "<\n";
    }
    System.out.println(output);
  }
  
}
