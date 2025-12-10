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

        player.loc = new Location("Spawn");

        pSepL("You have arrived at "+player.loc+".");
        pl();
        while (inPlay) {
            pSep();
            player.loc.visit();
            pl("You are at "+player.loc+".");
            if (!player.loc.discovered) {
                pl("You have discovered a new location!");
                player.loc.discovered=true;
            }
            pl(printDescription(player.loc.getDescription(), "\n", "\t"));
            pl();
            pl("Your Status:");
            pl(printStatus(player.getStatus()));

            pl("Your Actions: "+printActions(player.getActions(),", "));
            pl();
            int playerActionNumber=-1;
            while (playerActionNumber<=0 || playerActionNumber>player.getActions().size()) {
                p("Choose Action (number): ");
                try {
                    playerActionNumber = Integer.parseInt(input.nextLine());
                } catch (Exception e) {
                    pl("Invalid input. Please enter a number corresponding to an action.");
                }
            }
            Action playerAction = player.getActions().get(playerActionNumber-1);
            playerAction.Execute(player);



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

    public static String printDescription(ArrayList<String> arr, String sep, String tab) {
        String list = "";
        for (int i=0;i<arr.size();i++) {
            if (i!=0) {list+=sep;}
            list+=tab+arr.get(i);
        }

        return list;
    }
    public static String printActions(ArrayList<Action> arr, String sep) {
        String list = "";

        for (int i=0;i<arr.size();i++) {
            if (i!=0) {list+=sep;}
            list+=arr.get(i);
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