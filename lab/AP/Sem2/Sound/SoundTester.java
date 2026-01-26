package AP.Sem2.Sound;

/**
 * SoundTester contains a main method to test a Sound object.
 *
 * The tester constructs two Sound objects, invokes the limiteAmplitude,
 * trimSilenceFromBeginning, and toString methods, and prints the results.
 */
public class SoundTester {
  public static void main(String[] args) {
    int[] sample1 = {40, 2532, 17, -2300, -17, -4000, 2000, 1048, -420, 33, 15, -32, 2030, 3223};
    Sound check = new Sound(sample1);
    
    // tests limitAmplitude method
    int numChanges = check.limitAmplitude(2000);
    System.out.println(numChanges);
    System.out.println(check + "\n");
    
    // tests trimSilenceFromBeginning method
    int[] sample2 = {0, 0, 0, 0, -14, 0, -35, -39, 0, -7, 16, 32, 37, 29, 0, 0};
    check = new Sound(sample2);
    System.out.println(check);  // array before trim
    
    check.trimSilenceFromBeginning();
    System.out.println(check); // array after trim
  }
}
