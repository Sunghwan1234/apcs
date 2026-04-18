import java.awt.Color;
import java.awt.Point;
import java.awt.image.BufferedImage;

/**
 * Represents a picture.  This class inherits from SimplePicture and
 * allows the student to add functionality to the Picture class.  
 * 
 * @author Barbara Ericson ericson@cc.gatech.edu
 */
public class Picture extends SimplePicture {
  
  /**
   * Default constructor.  Not needed but shows students the implicit
   * call to super().  Child constructors always call a parent constructor.
   */
  public Picture () {
    super();  
  }
  
  /**
   * Constructor that takes a file name and creates the picture.
   * 
   * @param fileName  the name of the file to create the picture from
   */
  public Picture(String fileName) {
    // lets the parent class handle this fileName
    super(fileName);
  }
  
  /**
   * Constructor that takes the width and height.
   * 
   * @param height  the height of the desired picture
   * @param width   the width of the desired picture
   */
  public Picture(int height, int width) {
    // lets the parent class handle this width and height
    super(width,height);
  }
  
  /**
   * Constructor that takes a picture and creates a copy of that picture.
   * 
   * @param copyPicture  the picture to copy
   */
  public Picture(Picture copyPicture) {
    // lets the parent class do the copy
    super(copyPicture);
  }
  
  /**
   * Constructor that takes a buffered image.
   * 
   * @param image  the buffered image to use
   */
  public Picture(BufferedImage image) {
    super(image);
  }
  
  /**
   *  Copies from the passed fromPic to the specified startRow and
   *  startCol in the current picture.
   * 
   * @param fromPic   the picture to copy from
   * @param startRow  the start row to copy to
   * @param startCol  the start col to copy to
   */
  public void copy(Picture fromPic, int startRow, int startCol) {
    Pixel fromPixel = null;
    Pixel toPixel = null;
    Pixel[][] toPixels = this.getPixels2D();
    Pixel[][] fromPixels = fromPic.getPixels2D();
    for (int fromRow = 0, toRow = startRow; 
         fromRow < fromPixels.length && toRow < toPixels.length; 
         fromRow++, toRow++) {
      for (int fromCol = 0, toCol = startCol; 
           fromCol < fromPixels[0].length && toCol < toPixels[0].length;  
           fromCol++, toCol++) {
        fromPixel = fromPixels[fromRow][fromCol];
        toPixel = toPixels[toRow][toCol];
        toPixel.setColor(fromPixel.getColor());
      }
    }   
  }

  /** Creates a collage of several pictures. */
  public void createCollage() {
    Picture flower1 = new Picture("flower1.jpg");
    Picture flower2 = new Picture("flower2.jpg");
    this.copy(flower1,0,0);
    this.copy(flower2,100,0);
    this.copy(flower1,200,0);
    Picture flowerNoBlue = new Picture(flower2);
    flowerNoBlue.zeroBlue();
    this.copy(flowerNoBlue,300,0);
    this.copy(flower1,400,0);
    this.copy(flower2,500,0);
    this.write("collage.jpg");
  }

  /**
   * Returns a string with information about this picture.
   * 
   * @return  a string with fileName, height, and width
   */
  public String toString() {
    String output = "Picture, filename " + getFileName() + 
      " height " + getHeight() + " width " + getWidth();
    return output;
  }
  
  /************************************ 6.C Lab ************************************/
  
  /** 
   * Sets the blue to 0.
   */
  public void zeroBlue() {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels) {
      for (Pixel pixelObj : rowArray) {
        pixelObj.setBlue(0);
      }
    }
  }

  /** 
   * Sets the red and green values of each pixel to 0.
   */
  public void keepOnlyBlue() {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels) {
      for (Pixel pixelObj : rowArray) {
        pixelObj.setRed(0);
        pixelObj.setGreen(0);
      }
    }
  }
  
  
  /** 
   * Sets all red, green, and blue values of each pixel to 255 - current value.
   */
  public void negate() {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels) {
      for (Pixel pixelObj : rowArray) {
        pixelObj.setRed(255-pixelObj.getRed());
        pixelObj.setGreen(255-pixelObj.getGreen());
        pixelObj.setBlue(255-pixelObj.getBlue());
      }
    }
  }
  
  
  /** 
   * Sets all red, green, and blue values of each pixel to the average of the current values.
   */
  public void grayscale() {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels) {
      for (Pixel pixelObj : rowArray) {
        int av = (pixelObj.getRed()+pixelObj.getGreen()+pixelObj.getBlue())/3;
        pixelObj.setRed(av);
        pixelObj.setGreen(av);
        pixelObj.setBlue(av);
      }
    }
  }
  
  
  /** 
   * Enhances the pixels that are the least like water.
   */
  public void fixUnderwater() {
    Pixel[][] pixels = this.getPixels2D();
    int[] sums = new int[3];
    for (int row = 0; row<pixels.length; row++) {
      for (int col=0;col<pixels[row].length;col++) {
        Pixel p = pixels[row][col];
        sums[0] += p.getRed()/Math.max(p.getGreen(),1);
        sums[1] += p.getGreen()/Math.max(p.getBlue(), 1);
        sums[2] += p.getBlue()/Math.max(p.getRed(),1);
      }
    }
    sums[0]/=pixels.length*pixels[0].length;
    sums[1]/=pixels.length*pixels[0].length;
    sums[2]/=pixels.length*pixels[0].length;

    for (Pixel[] rowArray : pixels) {
      for (Pixel p : rowArray) {
        double c = 1;
        try {
          c = 0.5+(0.5*2*Math.atan(((
            Math.abs(sums[0] - p.getRed()/Math.max(p.getGreen(),1)) +
            Math.abs(sums[1] - p.getGreen()/Math.max(p.getBlue(), 1)) +
            Math.abs(sums[2] - p.getBlue()/Math.max(p.getRed(),1))
          )/3)*0.8)/Math.PI);
        } catch (Exception e) {
        }
        p.setRed((int) (p.getRed()*c));
        p.setGreen((int)(p.getGreen()*c));
        p.setBlue((int)(p.getBlue()*c));

      }
    }
  }
  

  /************************************ 6.D Lab ************************************/

  /** 
   * Mirrors the picture around a vertical mirror in the center of the picture from left to right.
   */
  public void mirrorVerticalLeftToRight() {
    Pixel[][] pixels = this.getPixels2D();
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int width = pixels[0].length;
    for (int row = 0; row < pixels.length; row++) {
      for (int col = 0; col < width / 2; col++) {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][width - 1 - col];
        rightPixel.setColor(leftPixel.getColor());
      }
    } 
  }
  
  /** 
   * Mirrors the picture around a vertical mirror in the center of the picture from right to left.
   */
  public void mirrorVerticalRightToLeft() {
    Pixel[][] pixels = this.getPixels2D();
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int width = pixels[0].length;
    for (int row = 0; row < pixels.length; row++) {
      for (int col = 0; col < width / 2; col++) {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][width - 1 - col];
        leftPixel.setColor(rightPixel.getColor());
      }
    } 
  }
  
  
  /** 
   * Mirrors the picture around a horizontal mirror in the center of the picture from top to bottom.
   */
  public void mirrorHorizontalTopToBottom() {
    Pixel[][] pixels = this.getPixels2D();
    int width = pixels[0].length;

    for (int row=pixels.length-1;row>pixels.length/2;row--) {
      for (int col=0;col<width;col++) {
        pixels[row][col].setColor(pixels[pixels.length-row+1][col].getColor());
      }
    }
  }
  
  
  /** 
   * Mirrors the picture around a horizontal mirror in the center of the picture from bottom to top.
   */
  public void mirrorHorizontalBottomToTop() {
    Pixel[][] pixels = this.getPixels2D();
    int width = pixels[0].length;

    for (int row=pixels.length-1;row>pixels.length/2;row--) {
      for (int col=0;col<width;col++) {
        pixels[pixels.length-row+1][col].setColor(pixels[row][col].getColor());
      }
    }
  }
  
  
  /** 
   * Mirrors the picture around a diagonal mirror starting in the upper-left corner and continuing at a 45-degree angle.
   */
  public void mirrorDiagonal() {
    Pixel[][] pixels = this.getPixels2D();
    int width = pixels[0].length;
    for (int row=0;row<Math.min(pixels.length, width);row++) {
      for (int col=0;col<row;col++) {
        if (pixels.length<width) {
          pixels[row][col].setColor(pixels[col][row].getColor());
        } else {
          pixels[col][row].setColor(pixels[row][col].getColor());
        }
      }
    }
  }
  

  /************************************ 6.E Lab ************************************/

  /**
   * Mirrors just part of a picture of a temple.
   */
  public void mirrorTemple() {
    int mirrorPoint = 276;
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    Pixel[][] pixels = this.getPixels2D();
    
    // loops through the rows
    for (int row = 27; row < 97; row++) {
      // loops from 13 to just before the mirror point
      for (int col = 13; col < mirrorPoint; col++) {
        leftPixel = pixels[row][col];      
        rightPixel = pixels[row][mirrorPoint - col + mirrorPoint];
        rightPixel.setColor(leftPixel.getColor());
      }
    }
  }
  
  /** 
   * Mirrors just part of a picture of a snowman.
   */
  public void mirrorArms() {
    mirrorOppositeBound(155, 239, 200, 300, 191, 2);
    mirrorOppositeBound(155, 103, 191, 169, 191, 2);
  }
  
  
  /** 
   * Mirrors just part of a picture of a swan.
   */
  public void mirrorSwan() {
    mirrorOppositeBound(68, 220, 300, 450, 220, 1);
    mirrorOppositeBound(66, 315, 180, 391, 280, 1);
  }

  public void mirrorOppositeBound(int r, int c, int r2, int c2, int rl, int t) {
    Pixel[][] pixels = this.getPixels2D();
    int height = pixels.length;
    int width = pixels[0].length;
    if (rl==-1) {
      if (t==1) {
        rl=width/2;
      } else {
        rl=height/2;
      }
    }

    for (int row = r; row <= r2; row++) {
      for (int col = c; col <= c2; col++) {
        try {
          if (t==1) {
            Pixel cPixel = pixels[row][col];
            Pixel fPixel = pixels[row][rl+(rl-col)];
            fPixel.setColor(cPixel.getColor());
          } else {
            Pixel cPixel = pixels[row][col];
            Pixel fPixel = pixels[rl+(rl-row)][col];
            fPixel.setColor(cPixel.getColor());
          }
        } catch (Exception e) {
          continue;
        }
      }
    }
  }

  /** Mirrors a Rectangle within a line */
  public void mirrorPreciseBound(int r, int c, int r2, int c2, int rl, int t) {
    Pixel[][] pixels = this.getPixels2D();
    int height = pixels.length;
    int width = pixels[0].length;
    if (rl==-1) {
      if (t==1) {
        rl=width/2;
      } else {
        rl=height/2;
      }
    }

    for (int row = r; row <= r2; row++) {
      for (int col = c; col <= c2; col++) {
        if (t==1) {
          Pixel cPixel = pixels[row][col];
          Pixel fPixel = pixels[row][rl+(rl-col)];
          cPixel.setColor(fPixel.getColor());
        } else {
          Pixel cPixel = pixels[row][col];
          Pixel fPixel = pixels[rl+(rl-row)][col];
          cPixel.setColor(fPixel.getColor());
        }
      }
    }
  }

  /** Mirrors an rectangle. Types:
   * 1. L/R
   * 2. T/B
  */
  public void mirrorRect(int r, int c, int h, int w, int t) {
    mirrorPreciseBound(r, c, r+h, c+w, -1, t);
  }
  public void mirrorBound(int r, int c, int r2, int c2, int t) {
    mirrorRect(r, c, r2-r, c2-c, t);
  }

  /************************************ 6.F Lab ************************************/
  
  /**
   * Method to _________________________________
   */
  public void rotateCenter(int degrees) {
    double rad = Math.toRadians(degrees);
    Pixel[][] pixels = this.getPixels2D();
    int width = pixels[0].length;

    // Save Previous Colors
    Color[][] colors = new Color[pixels.length][width];
    /** Save all pixels to a color grid. */
    for (int row=0;row<pixels.length;row++) {
      for (int col=0;col<pixels[row].length;col++) {
        colors[row][col] = pixels[row][col].getColor();
      }
    }

    Point center = new Point(width/2, pixels.length/2);
    for (int row=0;row<pixels.length;row++) {
      for (int col=0;col<pixels[row].length;col++) {
        // Rotate Pixel
        Point relativePoint = new Point(col-center.x,row-center.y);
        double distance = Math.sqrt(Math.pow(relativePoint.x,2)+Math.pow(relativePoint.y,2));
        double angle = Math.atan2(relativePoint.y,relativePoint.x);
        Point newPoint = new Point((int)(center.x+distance*Math.cos(angle+rad)),(int)(center.y+distance*Math.sin(angle+rad)));
        if (newPoint.y<0||newPoint.y>=pixels.length||newPoint.x<0||newPoint.x>=width) {
          pixels[row][col].setColor(Color.BLACK);
          continue;
        }

        Color rotatedPixel = colors[newPoint.y][newPoint.x];

        pixels[row][col].setColor(rotatedPixel);
      }
    }
  }

  /**
   * Rotate around a custom point
   * @param degrees
   */
  public void rotatePoint(int cx, int cy, int degrees) {
    double rad = Math.toRadians(degrees);
    Pixel[][] pixels = this.getPixels2D();
    int width = pixels[0].length;

    // Save Previous Colors
    Color[][] colors = new Color[pixels.length][width];
    /** Save all pixels to a color grid. */
    for (int row=0;row<pixels.length;row++) {
      for (int col=0;col<pixels[row].length;col++) {
        colors[row][col] = pixels[row][col].getColor();
      }
    }

    Point center = new Point(cx, cy);
    for (int row=0;row<pixels.length;row++) {
      for (int col=0;col<pixels[row].length;col++) {
        // Rotate Pixel
        Point relativePoint = new Point(col-center.x,row-center.y);
        double distance = Math.sqrt(Math.pow(relativePoint.x,2)+Math.pow(relativePoint.y,2));
        double angle = Math.atan2(relativePoint.y,relativePoint.x);
        Point newPoint = new Point((int)(center.x+distance*Math.cos(angle+rad)),(int)(center.y+distance*Math.sin(angle+rad)));
        if (newPoint.y<0||newPoint.y>=pixels.length||newPoint.x<0||newPoint.x>=width) {
          pixels[row][col].setColor(Color.BLACK);
          continue;
        }

        Color rotatedPixel = colors[newPoint.y][newPoint.x];

        pixels[row][col].setColor(rotatedPixel);
      }
    }
  }
  
  
  /**
   * Method to Windmill
   */
  public void change2(int degrees) {
    double rad = Math.toRadians(degrees);
    Pixel[][] pixels = this.getPixels2D();
    int width = pixels[0].length;
    boolean[][] changed = new boolean[pixels.length][width];

    Point center = new Point(width/2, pixels.length/2);
    for (int row=0;row<pixels.length;row++) {
      for (int col=0;col<pixels[row].length;col++) {
        if (!changed[row][col]) {
          changed[row][col]=true;
          Point relativePoint = new Point(col-center.x,row-center.y);
          double distance = Math.sqrt(Math.pow(relativePoint.x,2)+Math.pow(relativePoint.y,2));
          double angle = Math.atan2(relativePoint.y,relativePoint.x);
          Point newPoint = new Point((int)(center.x+distance*Math.cos(angle+rad)),(int)(center.y+distance*Math.sin(angle+rad)));
          if (newPoint.y<0||newPoint.y>=pixels.length||newPoint.x<0||newPoint.x>=width) {
            pixels[row][col].setColor(Color.BLACK);

            continue;
          }
          Color thisPixelColor = pixels[row][col].getColor();
          Color newPixelColor = pixels[newPoint.y][newPoint.x].getColor();
          if (!changed[newPoint.y][newPoint.x]) {
            pixels[newPoint.y][newPoint.x].setColor(thisPixelColor);

            changed[newPoint.y][newPoint.x]=true;
          }
          pixels[row][col].setColor(newPixelColor);

          
        }
      }
    }
  }


}