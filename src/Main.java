import java.util.Scanner; // Sunghwan In
import java.lang.Math;

public class Main {
    public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      boolean game = true;
      int level = 1;
      while (game) {
        double max = Math.pow(10, level);
        double num = Math.ceil(Math.random()*max);
        pl("The computer picked a number between 1 and "+max);
        int guesses=0;
        while (true) {
          int guess=0;
          while (true) {
            try {
              p("Your Guess: ");
              guess = scanner.nextInt();
              if (guess<1 || guess>max) {
                pl("Not in range");
              } else {
                break;
              }
            } catch (Exception e) {
              pl("Try Again: "+e.toString());
              guess = 0;
            }
          }
          guesses++;
          if (guess==num) {
            pl("Correct! You guessed this in "+guesses+" guesses!");
            double optimal = Math.ceil(Math.log(max)/Math.log(2));
            if (guesses>optimal) {
              pl("Suboptimal ("+optimal+"), but thats ok!");
            } else {
              pl("Optimal ("+optimal+")! Congrats!");
            }
            break;
          } else if (guess>num) {
            pl("Too High!");
          } else {
            pl("Too Low!");
          }
        }
        p("replay (-1), quit(0), or choose a level: ");
        while (true) {
          int choice = -2;
          try {
            choice = scanner.nextInt();
            if (choice==-1) {
              break;
            } else if (choice==0) {
              game = false;
              break;
            } else if (choice>0){
              level = choice;
              break;
            }
          } catch (Exception e) {
            pl("no.");
          }
        }
      }
      scanner.close();
    }
    public static int reqI(Scanner scanner, String ask, int low) {
      int ret = low-1;
      while (ret<low) {
        ret = askI(scanner,ask);
      }
      return ret;
    }
    public static int len(int n) {
      return (int)(Math.log10(n)) + 1;
    }
    public static int digit(int n, int digit) {
      return (int)(n/Math.pow(10,digit))%10;
    }
    public static double dist(double[] p1,double[] p2) {
      return Math.sqrt(Math.pow(p2[0]-p1[0],2)+Math.pow(p2[1]-p1[1],2));
    }
    public static void pl(Object o) {
      System.out.println(o);
    }
    public static void p(Object o) {
      System.out.print(o);
    }
    public static void printOut(String[] out) {
      for (int i = 0; i < out.length; i++) {
            System.out.println(out[i]);
        }
    }
    public static String ask(Scanner scanner, String askString) {
      System.out.print(askString);
      String out = scanner.nextLine();
      return out;
    }
    public static int askI(Scanner scanner, String ask) {
      System.out.print(ask);
      int out = scanner.nextInt();
      return out;
    }
    public static double askD(Scanner scanner, String ask) {
      System.out.print(ask);
      double out = scanner.nextDouble();
      return out;
    }
}