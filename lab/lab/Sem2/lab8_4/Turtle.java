

/**
 * The Turtle class has been created for demonstration of the Software
 * Development Method by drawing figures on a canvas.
 * 
 * @author U. Wolz
 */
public class Turtle {
  protected double currentHeading = 0;
  protected double currentX = 0;
  protected double currentY = 0;

  /**
   * Moves turtle forwards the distance on the canvas in the direction it is
   * already facing.
   * 
   * @param distance the number of pixels to move
   */
  public void forward(double distance) {
    currentX = currentX + distance * Math.sin(currentHeading * Math.PI / 180);
    currentY = currentY + distance * Math.cos(currentHeading * Math.PI / 180);
  }

  /**
   * Moves turtle backwards the distance on the canvas in the direction it is
   * already facing.
   * 
   * @param distance
   */
  public void backward(double distance) {
    forward(-1 * distance);
  }

  /**
   * Rotates the turtle clockwise turn degrees.
   * 
   * @param turn the degrees to turn
   */
  public void right(double turn) {
    currentHeading = (currentHeading + turn + 360) % 360;
  }

  /**
   * Rotates the turtle counterclockwise turn degrees.
   * 
   * @param turn the degrees to turn
   */
  public void left(double turn) {
    right(-turn);
  }

  /**
   * Returns the current direction.
   * 
   * @return the current direction
   */
  public double getHeading() {
    return currentHeading;
  }

  /**
   * Returns the current x (horizontal) position coordinate.
   * 
   * @return the current value of x
   */
  public double getX() {
    return currentX;
  }

  /**
   * Returns the current y (vertical) position coordinate.
   * 
   * @return the current value of y
   */
  public double getY() {
    return currentY;
  }

}
