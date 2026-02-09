/**
 * This class contains class methods that will help you test the Picture class 
 * methods.  Uncomment the methods and the code in the main method to test.
 * 
 * @author Barbara Ericson 
 */
public class PictureTester {
  /** 
   * Main method for testing.
   */
  public static void main(String[] args) {
    // Uncomment a call here to run a test and comment out the ones you don't want to run.
    
    /************************************ 6.C Lab ************************************/
    
    //testZeroBlue();
    //testKeepOnlyBlue();
//   testNegate();
//    testGrayscale();
// //  testFixUnderwater(); 
    
    /************************************ 6.D Lab ************************************/
    
//    testMirrorVerticalLeftToRight();
//    testMirrorVerticalRightToLeft();
   // testMirrorHorizontalTopToBottom();
//    testMirrorHorizontalBottomToTop();
    //testMirrorDiagonal();
    
    /************************************ 6.E Lab ************************************/

//testMirrorTemple();
//    testMirrorArms();
//    testMirrorSwan();
    
    /************************************ 6.F Lab ************************************/
    
    testChange1();
//    testChange2();
    
  }
  
  
  /****************************** Private Helper Methods *****************************/
  /************************************* 6.C Lab *************************************/
  
  /**
   * Tests zeroBlue method.
   */
  private static void testZeroBlue() {
    Picture pic = new Picture("lab/lab/lab6_Appendix/images/beach.jpg");
    pic.explore(); // displays original picture
    pic.zeroBlue();
    pic.explore(); // displays picture revised by zeroBlue method
  }
  
  /**
   * Tests keepOnlyBlue method.
   */
  private static void testKeepOnlyBlue() {
    Picture pic = new Picture("lab/lab/lab6_Appendix/images/beach.jpg");
    pic.explore(); // displays original picture
    pic.keepOnlyBlue();
    pic.explore(); // displays picture revised by keepOnlyBlue method
  }
  
  /**
   * Tests negate method.
   */
  private static void testNegate() {
    Picture pic = new Picture("lab/lab/lab6_Appendix/images/beach.jpg");
    pic.explore(); // displays original picture
    pic.negate();
    pic.explore(); // displays picture revised by negate method
  }
  
  /**
   * Tests grayscale method.
   */
  private static void testGrayscale() {
    Picture pic = new Picture("lab/lab/lab6_Appendix/images/beach.jpg");
    pic.explore(); // displays original picture
    pic.grayscale();
    pic.explore(); // displays picture revised by grayscale method
  }
  
  /**
   * Tests fixUnderwater method.
   */
  private static void testFixUnderwater() {
    Picture pic = new Picture("lab/lab/lab6_Appendix/images/water.jpg");
    pic.explore(); // displays original picture
    pic.fixUnderwater();
    pic.explore(); // displays picture revised by fixUnderwater method
  }
  
  /************************************* 6.D Lab *************************************/
  
  /** 
   * Tests mirrorVerticalLeftToRight method.
   */
  private static void testMirrorVerticalLeftToRight() {
    Picture pic = new Picture("lab/lab/lab6_Appendix/images/beach.jpg");
    pic.explore(); // displays original picture
    pic.mirrorVerticalLeftToRight();
    pic.explore(); // displays picture revised by mirrorVertical method
  }
  
  /** 
   * Tests mirrorVerticalRightToLeft method.
   */
  private static void testMirrorVerticalRightToLeft() {
    Picture pic = new Picture("lab/lab/lab6_Appendix/images/koala.jpg");
    pic.explore(); // displays original picture
    pic.mirrorVerticalRightToLeft();
    pic.explore(); // displays picture revised by mirrorVerticalRightToLeft method
  }
  
  /** 
   * Tests mirrorHorizontalTopToBottom method.
   */
  private static void testMirrorHorizontalTopToBottom() {
    Picture pic = new Picture("lab/lab/lab6_Appendix/images/redMotorcycle.jpg");
    pic.explore(); // displays original picture
    pic.mirrorHorizontalTopToBottom();
    pic.explore(); // displays picture revised by mirrorHorizontalTopToBottom method
  }
  
   /** 
   * Tests mirrorHorizontalBottomToTop method.
   */
  private static void testMirrorHorizontalBottomToTop() {
    Picture pic = new Picture("lab/lab/lab6_Appendix/images/redMotorcycle.jpg");
    pic.explore(); // displays original picture
    pic.mirrorHorizontalBottomToTop();
    pic.explore(); // displays picture revised by mirrorHorizontalBottomToTop method
  }
  
  /** 
   * Tests mirrorDiagonal method.
   */
  private static void testMirrorDiagonal() {
    Picture pic = new Picture("lab/lab/lab6_Appendix/images/beach.jpg");
    pic.explore(); // displays original picture
    pic.mirrorDiagonal();
    pic.explore(); // displays picture revised by mirrorDiagonal method
    pic = new Picture("lab/lab/lab6_Appendix/images/butterfly.jpg");
    pic.explore(); // displays original picture
    pic.mirrorDiagonal();
    pic.explore(); // displays picture revised by mirrorDiagonal method
  }
  
  /************************************* 6.E Lab *************************************/

  /** 
   * Tests mirrorTemple method.
   */
  private static void testMirrorTemple() {
    Picture pic = new Picture("lab/lab/lab6_Appendix/images/temple.jpg");
    pic.explore(); // displays original picture
    pic.mirrorTemple();
    pic.explore(); // displays picture revised by mirrorTemple method
  }
  
  /** 
   * Tests mirrorTemple method.
   */
  private static void testMirrorArms() {
    Picture pic = new Picture("lab/lab/lab6_Appendix/images/snowman.jpg");
    pic.explore(); // displays original picture
    pic.mirrorArms();
    pic.explore(); // displays picture revised by mirrorArms method
  }
  
  /** 
   * Tests mirrorSwan method.
   */
  private static void testMirrorSwan() {
    Picture pic = new Picture("lab/lab/lab6_Appendix/images/swan.jpg");
    pic.explore(); // displays original picture
    pic.mirrorSwan();
    pic.explore(); // displays picture revised by mirrorSwan method
  }
  
  /************************************* 6.F Lab *************************************/
  
  /** 
   * Tests change1 method.
   */
  private static void testChange1() {
    Picture pic = new Picture("lab/lab/lab6_Appendix/images/beach.jpg");
    pic.explore();
    pic.rotateCenter(90);
    pic.explore();
    pic = new Picture("lab/lab/lab6_Appendix/images/koala.jpg");
    pic.explore();
    pic.rotateCenter(-30);
    pic.explore();
  }
  
  /**
   * Tests change2 method.
   */
  private static void testChange2() {
    Picture pic = new Picture("lab/lab/lab6_Appendix/images/butterfly.jpg");
    pic.explore();
    pic.change2();
    pic.explore();
    pic = new Picture("lab/lab/lab6_Appendix/images/whiteFlower.jpg");
    pic.explore();
    pic.change2();
    pic.explore();
  }
  
}