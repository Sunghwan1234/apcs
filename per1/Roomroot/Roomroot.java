package Roomroot;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Roomroot {

    static boolean inPlay = true;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        p("Player name: ");
        Player player = new Player(input.next());
        pSep();
        pl("Welcome to Roomroot, "+player.name+".");
        pl("Starting Roomroot...");

        player.loc = new Location();

        pSepL("You have arrived at "+player.loc+".");
        pl();
        while (inPlay) {
            pl("You are at "+player.loc+".\n");
            if (!player.loc.discovered) {
                pl("You have discovered a new location!");
                player.loc.discovered=true;
            }

            pl(printStatus(player.getStatus()));

            pl("Your Actions: "+printActions(player.getActions()));


            inPlay=false;
        }
        input.close();
    }

    public static String printStatus(String[] statuses) {
        String status="";
        for (int i=0;i<statuses.length;i++) {
            if(i!=0) {status+="\n";}
            status+="\t"+statuses[i];
        }
        return status;
    }

    public static String printActions(ArrayList<Action> actions) {
        String list = "";

        for (int i=0;i<actions.size();i++) {
            if (i!=0) {list+=", ";}
            list+=actions.get(i);
        }

        return list;
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
        pSep(); pl(o); pSep();
    }
}