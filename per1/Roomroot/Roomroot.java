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
        pl(player.loc)

        while (inPlay) {

        }
        input.close();
    }
    public static void p(Object o) {System.out.print(o);}
    public static void pl(Object o) {System.out.println(o);}
}