package lab.lab.Sem2.lab7_2;

/**
 * MusicianTester contains a main method to test any Musician objects.
 * 
 * The tester constructs Instrumentalist and Vocalist objects, which are all
 * Musicians, invokes the toString and equals methods, and prints the results.
 */
public class MusicianTester {
  public static void main(String[] args) {

    Instrumentalist willieMurphy = new Instrumentalist(1960, "Minnesota", 3);
    Instrumentalist bobDylan = new Instrumentalist(1960, "Minnesota", 3);
    Instrumentalist generic1 = willieMurphy; // points to first Instrumentalist
    
    Vocalist paulMcCartney = new Vocalist(1960, "England", 4);
    Vocalist marvinGaye = new Vocalist(1960, "Washington D.C.", 4);
    Vocalist generic2 = marvinGaye; // points to second Vocalist
    
                                         // Object toString             Musician toString        Inst/Voc toString
                                         // (others not written)        (Inst/Voc not written)
    System.out.println(willieMurphy);    // Instrumentalist@17e50eab    1960, Minnesota          1960, Minnesota, Instruments: 3 
    System.out.println(bobDylan);        // Instrumentalist@3b564b61    1960, Minnesota          1960, Minnesota, Instruments: 3 
    System.out.println(generic1 + "\n"); // Instrumentalist@17e50eab    1960, Minnesota          1960, Minnesota, Instruments: 3 
    
    System.out.println(paulMcCartney);   // Vocalist@26154aad           1960, England            1960, England, Range: 4 
    System.out.println(marvinGaye);      // Vocalist@5a2f4dd9           1960, Washington D.C.    1960, Washington D.C., Range: 4 
    System.out.println(generic2 + "\n"); // Vocalist@5a2f4dd9           1960, Washington D.C.    1960, Washington D.C., Range: 4 

                                                          // Object equals          Musician equals          Inst/Voc equals
                                                          // (others not written)   (Inst/Voc not written)   
    System.out.println(willieMurphy.equals(bobDylan));    // false                  true                     true
    System.out.println(willieMurphy.equals(generic1));    // true                   true                     true
    System.out.println(paulMcCartney.equals(marvinGaye)); // false                  false                    true
    System.out.println(paulMcCartney.equals(generic2));   // false                  false                    true
  }
  
}