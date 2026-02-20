package lab.AP.Sem2.GrayImage;

/**
 * A gray image is composed of only black and white pixels that can be set,
 * counted, and processed.
 */
public class GrayImage {
  /** The value of a black pixel: 0 */
  public static final int BLACK = 0;

  /** The value of a white pixel: 255 */
  public static final int WHITE = 255;

  /**
   * The 2-dimensional representation of this image. Guaranteed not to be null.
   * All values in the array are within the range [BLACK, WHITE], inclusive.
   */
  private int[][] pixelValues = null;

  /**
   * Instantiates a 2-dimensional array of dimensions row by col.
   * Not included in the original AP question.
   * 
   * @param row the number of rows in the array to be instantiated
   * @param col the number of columns in the array to be instantiated
   */
  public GrayImage(int row, int col) {
    pixelValues = new int[row][col];
  }

  /**
   * Adds color value to pixel located at row, col.
   * Not included in the original AP question.
   * 
   * @param row   the row of the pixel to be set
   * @param col   the column of the pixel to be set
   * @param value the value the pixel will hold upon running the method
   */
  public void setPixel(int row, int col, int value) {
    pixelValues[row][col] = value;
  }

  /**
   * Returns the total number of white pixels in this image.
   * Postcondition: this image has not been changed.
   * 
   * @return the total number of white pixels in this image
   */
  public int countWhitePixels() {
    int wp=0;
    for (int[] row : pixelValues) {
      for (int pixel : row) {
        if (pixel==WHITE) {
          wp++;
        }
      }
    }
    return wp;
  }


  /**
   * Processes this image in row-major order and decreases the value of each pixel
   * at position(row, col) by the value of the pixel at position (row + 2, col + 2)
   * if it exists. Resulting values that would be less than BLACK are replaced by 
   * BLACK. Pixels for which there is no pixel at position (row + 2, col + 2) are
   * unchanged.
   */
  public void processImage() 
  {
    
  }

  
  /**
   * Returns a string representation of the object.
   * Not included in the original AP question.
   * 
   * @return a String representation of the object
   */
  public String toString() {
    String output = ""; // Or as a for loop:
    for (int[] row : pixelValues) { // for (int row = 0; row < pixelValues.length; row++) {
      for (int item : row) { // for (int col = 0; col < pixelValues[0].length; col++) {
        output += (item + "\t"); // output += pixelValues[row][col] + "\t";
      } // }
      output += "\n"; // output += "\n";
    } // }
    return output;
  }

}