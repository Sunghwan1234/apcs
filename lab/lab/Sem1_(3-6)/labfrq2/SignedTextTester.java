package labfrq2;
/**
 * SignedTextTester contains a main method to test SignedText objects.
 * 
 * The tester constructs multiple SignedText objects, invokes the addSignature
 * and getSignature methods, and prints the results.
 */
public class SignedTextTester {
  public static void main(String[] args) {
    SignedText st1 = new SignedText("", "Wong");
    System.out.println(st1.getSignature());
    SignedText st2 = new SignedText("henri", "dubois");
    System.out.println(st2.getSignature());
    SignedText st3 = new SignedText("GRACE", "LOPEZ");
    System.out.println(st3.getSignature());
    SignedText st4 = new SignedText("", "FOX");
    String text = "Dear";
    System.out.println(st4.addSignature(text));
    text = "Best wishesFOX";
    System.out.println(st4.addSignature(text));
    text = "FOXThanks";
    System.out.println(st4.addSignature(text));
    text = "G-LOPEZHello";
    System.out.println(st3.addSignature(text));
  }
}