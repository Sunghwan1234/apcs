import java.util.Scanner; // Sunghwan In
import java.lang.Math;

public class Lab3 {
    public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      int[] data = {-1,0,0,0,0,0,0}; // choice,cchoice,win,loss,spartans,panthers,rockets
      String[] teams = {"","Spartans","Panthers","Rockets"}; // Spartans > Panthers > Rockets > Spartans
      while (data[2]<10 && data[3]<10) {
        data[0] = -1;
        data[1] = (int)(Math.random()*3)+1;
        data[data[1]+3]++; // funny intermixing
        while (data[0]<0 || data[0]>3) { // Input validation, of course
          System.out.println("1 for Spartans, 2 for Panthers, 3 for Rockets, 0 to exit: "); // Allows exiting
          data[0] = scanner.nextInt();
        }
        if (data[0]==0) {
          break;
        } // Allows exiting
        String line = "You chose [a]. I chose [b].\n[c] won this time. You have [d] wins, I have [e] wins.[f]\nComputer Choices: ";
        for (int i=0;i<data[4]+data[5]+data[6];i++) { // amazing 'for' loop to iterate through all computer choices
          line += teams[(i<data[4]?1:i<data[4]+data[5]?2:3)]+" "; // advanced selection system using one variable
        }
        System.out.println(line.substring(0,line.indexOf("[a]"))+teams[data[0]]+line.substring(line.indexOf("[a]")+3,line.indexOf("[b]"))+teams[data[1]]+line.substring(line.indexOf("[b]")+3,line.indexOf("[c]"))+(data[0]==data[1]?"No one":data[0]<data[1]||data[0]==3&&data[1]==1?"You":"I")+line.substring(line.indexOf("[c]")+3,line.indexOf("[d]"))+((data[0]==data[1]?"No one":data[0]<data[1]||data[0]==3&&data[1]==1?"You":"I")=="You"?++data[2]:data[2])+line.substring(line.indexOf("[d]")+3,line.indexOf("[e]"))+((data[0]==data[1]?"No one":data[0]<data[1]||data[0]==3&&data[1]==1?"You":"I")=="I"?++data[3]:data[3])+line.substring(line.indexOf("[e]")+3,line.indexOf("[f]"))+(data[2]==10?"\nYou won!":data[3]==10?"\nI won!":"")+line.substring(line.indexOf("[f]")+3,line.length()-1));
      }
      System.out.println("\nClosing.");
    }
    public static double dist(double[] p1,double[] p2) { // useless funcitons
      return Math.sqrt(Math.pow(p2[0]-p1[0],2)+Math.pow(p2[1]-p1[1],2));
    }
    public static void pl(String p) {
      System.out.println(p);
    }
    public static void printOut(String[] out) {
      for (int i = 0; i < out.length; i++) {
            System.out.println(out[i]);
        }
    }
    public static String ask(Scanner scanner, String askString) {
      System.out.print(askString);
      String out = scanner.nextLine();
      System.out.println();
      return out;
    }
    public static int askI(Scanner scanner, String ask) {
      System.out.print(ask);
      int out = scanner.nextInt();
      System.out.println();
      return out;
    }
    public static double askD(Scanner scanner, String ask) {
      System.out.print(ask);
      double out = scanner.nextDouble();
      System.out.println();
      return out;
    }
}