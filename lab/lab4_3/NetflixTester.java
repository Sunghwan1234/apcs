package lab.lab4_3;

/**
 * NetflixTester contains a main method to test a Netflix object.
 * 
 * The tester constructs three Netflix objects, invokes the setRating,
 * getRating, setTitle, getTitle, isPopular, and toString methods,
 * and prints the results.
 */
public class NetflixTester {
  public static void main (String[] args) {
    // tests constructor, default setRating, getRating, and toString methods
    Netflix movie1 = new Netflix("Home Alone");
    movie1.setRating();
    System.out.println(movie1.getRating()); 
    System.out.println(movie1 + "\n");
    
    // tests setTitle, default isPopular, and getTitle methods
    movie1.setTitle("HOME ALONe");
    if (movie1.isPopular()) {
      System.out.println(movie1.getTitle() + " is popular");
    } else {
      System.out.println(movie1.getTitle() + " is NOT popular");
    }
    // tests toString method
    System.out.println(movie1 + "\n");
    
    // tests constructor and overloaded setRating method with a second object
    Netflix movie2 = new Netflix("Pee Wee's Playhouse Christmas Special");
    movie2.setRating(1);
    // tests overloaded isPopular method (rating is too low to be promoted as popular)
    if (movie2.isPopular(true)) {
      System.out.println(movie2.getTitle() + " is popular");
    } else {
      System.out.println(movie2.getTitle() + " is NOT popular");
    }
    // tests toString method
    System.out.println(movie2 + "\n");
    
    Netflix movie3 = new Netflix("It's a Wonderful Life");
    movie3.setRating(2.5);
    // tests overloaded isPopular method
    // (rating is high enough to be promoted as popular, if promoted)
    if (movie3.isPopular(true)) {
      System.out.println("When promoted, " + movie3.getTitle() + " is popular");
    } else {
      System.out.println("When promoted, " + movie3.getTitle() + " is NOT popular");
    }
    if (movie3.isPopular(false)) {
      System.out.println("When not promoted, " + movie3.getTitle() + " is popular");
    } else {
      System.out.println("When not promoted, " + movie3.getTitle() + " is NOT popular");
    }
    if (movie1.isPopular(false)) {
      System.out.println("Even when not promoted, " + movie1.getTitle() + " is popular");
    } else {
      System.out.println("Even when not promoted, " + movie1.getTitle() + " is NOT popular");
    }
    
    // tests toString method
    System.out.println("\n" + movie3);
  }
  
}
