

import java.awt.*;

/**
 * The DrawTurtle class has been created for demonstration of the Software
 * Development Method by drawing figures on a canvas.
 * 
 * @author U. Wolz
 */
public class DrawTurtle extends Turtle {
  protected Graphics graphics = null;
  protected boolean penstate = true;
  protected int centerX = 0;
  protected int centerY = 0;
  protected Color color = Color.white;
  
  /**
   * Instantiates this Turtle.
   * 
   * @param comp the paint component to be drawn upon
   * @param graphics the graphics state
   */
  public DrawTurtle(Component comp, Graphics graphics) {
    this.graphics = graphics;
    centerX = comp.getSize().width / 2;
    centerY = comp.getSize().height / 2;
  }
  
  /**
   * Sets turtle at center of screen, facing up, with pen down (ready to draw).
   */
  public void home() {
    currentX = 0;
    currentY = 0;
    currentHeading = 0;
    penstate = true;
  }
  /**
   * Points torward and goes forward to an absolute angle, and undos heading
   * @param angle
   * @param length
   */
  public void pointAndMove(double angle, double length) {
    double head = currentHeading;
    currentHeading = angle;
    forward(length);
    currentHeading = head;
  }
  
  /**
   * Sets the turtle's drawing color.
   * 
   * @param color the color to be drawn in
   */
  public void setColor(Color color) {
    this.color = color;
  }
  
  /**
   * Returns the turtle's current drawing color.
   * 
   * @return the current color
   */
  public Color getColor() {
    return color;
  }
  
  /**
   * Activates the turtle's pen for future drawing.
   */
  public void penDown() { 
    penstate = true;
  }
  
  /**
   * Deactivates the turtle's pen for future drawing.
   */
  public void penUp() {
    penstate = false;
  }
  
  /**
   * Overrides Turtle method to not only move, but actually draw on the canvas.
   * 
   * @param distance the number of pixels to move and draw
   */
  @Override
  public void forward(double distance) {
    double newX = currentX + distance * Math.sin(currentHeading * Math.PI / 180);
    double newY = currentY + distance * Math.cos(currentHeading * Math.PI / 180);
    if (penstate) {
      Color temp = graphics.getColor();
      graphics.setColor(color);
      graphics.drawLine((int) currentX + centerX, centerY - (int) currentY, (int) newX + centerX, centerY - (int) newY);
      graphics.setColor(temp);
    }
    currentX = newX;
    currentY = newY;
  }
  
  /**
   * Draws a hexagon.
   *
   * @param length  the length of each side of the hexagon
   */
  public void hexagon(double length) {
    for (int i = 0; i < 6; i++) { 
      forward(length);
      right(60);
    }
  }
  
  /**
   * Draws a free form practice drawing.
   */
  public void freeForm(int length, int angle, int depth)
  {
    if (depth==0 || length==0) {return;}
    forward(length-1);
    right(angle);
    freeForm(length, angle, depth-1);
  }
  
  
  /**
   * Draws a squiral (square spiral).
   */
  public void squiral(int length, int repetitions)
  {
    for (int i=0; i<repetitions; i++) {
      forward(length*(i+1));
      left(90);
    }
  }
  public void squiralRecursive(int length, int repetitions) {
    if (repetitions<=0) {return;}
    squiralRecursive(length, repetitions-1);
    forward(length*repetitions);
    left(90);
  }
  
  
  /** 
   * Draws a fractal tree using recursion.
   * You may add parameters as needed.
   */
  public void fractalTree(int length, int angle, int depth, int subtract)
  {
    if (depth<=0 || length<=0) {
      //backward(length);
      return;
    }
    forward(length);
    left(angle);
    fractalTree(length-subtract, angle, depth-1,subtract);
    right(angle*2);
    fractalTree(length-subtract, angle, depth-1,subtract);
    left(angle);
    backward(length);
  }
  
  
  /** 
   * Draws a Sierpinski triangle using recursion.
   * You may add parameters as needed.
   */
  public void fractalTriangle(double length, int depth)
  {
    if (depth==1 || length<2) {
      penDown();
      right(90);
      forward(length);
      left(120);
      forward(length);
      left(120);
      forward(length);
      right(150);
      penUp();
    } else {
      fractalTriangle(length/2,depth-1);
      right(30);
      forward(length/2);
      left(30);
      fractalTriangle(length/2,depth-1);
      right(150);
      forward(length/2);
      left(150);
      fractalTriangle(length/2,depth-1);
      left(90);
      forward(length/2);
      right(90);
    }
  }
    
  
  /** 
   * Draws a beehive using recursion.
   *
   * @param level  the number of iterations (rings) in the beehive
   * @param length the length of each side of the hexagons
   */
  public void beehive(int level, double length)
  {
    for (int i=level-1;i>-level;i--) {
      int width = level*2-1-Math.abs(i);
      for (int r=0; r<width;r++) {
        //if (r==0||r==width-1||i==level-1||i==1-level) {
          penDown();
          hexagon(length);
          penUp();
        //}
        right(90);
        forward(length*1.732);
        left(90);
      }
      left(90);
      forward(length*1.732*width);
      right(90);
      if (i>0) {
        right(60);
        backward(length);
        left(60);
        backward(length);
      } else {
        left(60);
        backward(length);
        right(60);
        backward(length);
      }
    }

  }
}