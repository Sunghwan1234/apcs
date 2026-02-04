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
    /* to be implemented in 6.D Lab, part (a) */
  }
  
  
  /** 
   * Mirrors the picture around a horizontal mirror in the center of the picture from top to bottom.
   */
  public void mirrorHorizontalTopToBottom() {
    /* to be implemented in 6.D Lab, part (b) */
  }
  
  
  /** 
   * Mirrors the picture around a horizontal mirror in the center of the picture from bottom to top.
   */
  public void mirrorHorizontalBottomToTop() {
    /* to be implemented in 6.D Lab, part (c) */
  }
  
  
  /** 
   * Mirrors the picture around a diagonal mirror starting in the upper-left corner and continuing at a 45-degree angle.
   */
  public void mirrorDiagonal() {
    /* to be implemented in 6.D Lab, part (d) */
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
    /* to be implemented in 6.E Lab, part (a) */
  }
  
  
  /** 
   * Mirrors just part of a picture of a swan.
   */
  public void mirrorSwan() {
    /* to be implemented in 6.E Lab, part (b) */
  }


  /************************************ 6.F Lab ************************************/
  
  /**
   * Method to _________________________________
   */
  public void change1() {
    /* to be implemented in 6 Appendix Project */
       
  }
  
  
  /**
   * Method to _________________________________
   */
  public void change2() {
    /* to be implemented in 6 Appendix Project */
  }


}