package Roomroot;
import java.util.Scanner;

public class Roomroot {

    static boolean inPlay = true;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        p("Player name: ");
        Player player = new Player(input.next());
        pl("Welcome to Roomroot, "+player.name+".");
        pl("Starting Roomroot...");

        player.loc = new Location();

        while (inPlay) {
            pSep();
            pl("You have arrived at "+player.loc+".");
            pSep();


            inPlay=false;
        }
        input.close();
    }
    public static void p(Object o) {System.out.print(o);}
    public static void pl() {pl("");}
    public static void pl(Object o) {System.out.println(o);}
    public static void newLines(int lines) {
        for (int i=0;i<lines;i++) {pl();}
    }
    /** Prints a Line Seperator. */
    public static void pSep() {
        pl("------------------------------------------");
    }
    public static void pSepL(Object o) {
        
    }
}