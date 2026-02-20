package lab.AP.Sem2.GrayImage;

/**
 * GrayImageTester contains a main method to test a GrayImage object.
 * 
 * The tester constructs and sets a GrayImage object, invokes the countWhitePixels
 * and processImage methods, and prints the results.
 */
public class GrayImageTester {
  public static void main(String[] args) {
    // sets inital picture
    GrayImage picture = new GrayImage(4, 5);
    picture.setPixel(0, 0, 255);
    picture.setPixel(0, 1, 184);
    picture.setPixel(0, 2, 178);
    picture.setPixel(0, 3, 84);
    picture.setPixel(0, 4, 129);
    picture.setPixel(1, 0, 84);
    picture.setPixel(1, 1, 255);
    picture.setPixel(1, 2, 255);
    picture.setPixel(1, 3, 130);
    picture.setPixel(1, 4, 84);
    picture.setPixel(2, 0, 78);
    picture.setPixel(2, 1, 255);
    picture.setPixel(2, 2, 0);
    picture.setPixel(2, 3, 0);
    picture.setPixel(2, 4, 78);
    picture.setPixel(3, 0, 84);
    picture.setPixel(3, 1, 130);
    picture.setPixel(3, 2, 255);
    picture.setPixel(3, 3, 130);
    picture.setPixel(3, 4, 84);
    
    // tests countWhitePixels method
    System.out.println(picture.countWhitePixels() + "\n");

    // tests processImage method
    picture.processImage();
    System.out.println(picture);
  }
}