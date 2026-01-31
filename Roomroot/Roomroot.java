package Roomroot;
import java.util.ArrayList;
import java.util.Scanner;

import Roomroot.Action.Type;

public class Roomroot {
    public enum stat {
        passive,
        combat
    }

    public static boolean debug = true;

    public static stat status = stat.passive;
    private static boolean inPlay = true;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        pSep(); pl();
        p("Player name: ");
        Player player = new Player(input.nextLine());
        pl(); pSep();
        pl("Welcome to Roomroot, "+player+".");
        pl("Starting Roomroot...");
        pSep();
        newLines(10);

        // Initialization
        player.loc = new Location("Spawn");
        player.inventory.add(Item.ITEMS.get("Wand"));
        player.equip(player.inventory.get(0));

        pl("You have arrived at "+player.loc+".");
        pl(); pSep();
        /* Game Loop */
        while (inPlay) {
            if (status==stat.passive) {
                player.loc.visit(player);
                pl("You are at "+player.loc+".");
                if (!player.loc.discovered) {
                    pl("You have discovered a new location!");
                    player.loc.discovered=true;
                }
                pl(printDescriptions(player.loc.getDescription(), "\n", "\t"));
            } else if (status==stat.combat) {
                p("There are "+Monster.aggroGroup.size()+" Aggroed Monsters near you! ");
                pl(printDescriptions(Monster.getMonsterNames(Monster.aggroGroup), ", ", ""));

                for (Monster m : Monster.aggroGroup) {
                    if (m.isAlive()) {
                        pl();
                        pl(printStatus(m.getStatus())); // Get status of Monster
                    }
                }
            }
            pl();
            pl("Your Status:\n"+printStatus(player.getStatus()));
            if (player.getWeapon()!=null) {
                pl("Equipped Weapon: "+player.getWeapon());
            }
            pl();

            /* Choose Actions */
            Action playerAction = new Action(Type.INSTAKILL);
            boolean choseFinalAction = false;
            while (!choseFinalAction) {
                // Choose Player Action
                playerAction = chooseAction(player.getActions(), input, "Your Actions: ");

                while (playerAction.type.com == Type.SUBACTION.com) {
                    Action subAction = chooseAction(playerAction.subactions, input, "Your Subactions for "+playerAction+":\n", "\n", "\t");
                    playerAction = subAction;
                }
                while (playerAction.type==Type.INV) {
                    playerAction.execute(player);
                    Action invAction = chooseAction(playerAction.subactions, input, "Inventory Actions:\n", "\n", "\t");
                    playerAction = invAction;
                }
                while (playerAction.type.com == Type.CHOOSE.com) {
                    playerAction.execute(player);
                    Action invAction = chooseAction(playerAction.subactions, input, "Choose:\n", "\n", "\t");
                    playerAction = invAction;
                }
                if (playerAction.type!=Type.BACK) {choseFinalAction=true;}
            }

            pSep(); pl();
            pl(playerAction.execute(player));

            // TODO: Monster Actions
            if (status==stat.combat) {
                for (Monster m : Monster.aggroGroup) {
                    if (m.isAlive()) {
                        
                    }
                }
            }

            pl(); pSep();

            if (!player.isAlive()) {
                pl(); pSepL("You have died.");
                inPlay=false;
            }

            p("Continue"); input.nextLine();
            pSep();
        }
        input.close();
    }

    /** chooseAction with sep=', ' tab='' */
    public static Action chooseAction(ArrayList<Action> actions, Scanner input, String prompt) {
        return chooseAction(actions, input, prompt, ", ", "");
    }
    public static Action chooseAction(ArrayList<Action> actions, Scanner input, String prompt, String sep, String tab) {
        p(prompt);
        pl(printActions(actions, sep, tab));

        int actionNumber=-1;
        while (actionNumber<=0 || actionNumber>actions.size()) {
            p("Choose your Action (number): ");
            try {
                actionNumber = Integer.parseInt(input.nextLine());
            } catch (Exception e) {
                pl("Invalid input. Please enter a number corresponding to an action.");
            }
        }
        return actions.get(actionNumber-1);
    }

    /** Prints an array with newlines. Use .getStatus() to get Statuses. */
    public static String printStatus(String[] statuses) {
        String status="";
        for (int i=0;i<statuses.length;i++) {
            if(i!=0) {status+="\n";}
            status+="\t"+statuses[i];
        }
        return status;
    }

    public static String printDescriptions(ArrayList<String> arr, String sep, String tab) {
        String list = "";
        for (int i=0;i<arr.size();i++) {
            if (i!=0) {list+=sep;}
            list+=tab+arr.get(i);
        }

        return list;
    }
    /** Print an ArrayList of actions. */
    public static String printActions(ArrayList<Action> arr, String sep, String tab) {
        String list = "";

        for (int i=0;i<arr.size();i++) {
            if (i!=0) {list+=sep;}
            if (tab=="\t") {list+="("+(i+1)+")"+tab+arr.get(i);}
            else {list+=tab+arr.get(i);}
        }

        return list;
    }
    public static String printActions(ArrayList<Action> arr, String sep) {
        return printActions(arr, sep, "");
    }
    // public static String printActions(Action[] arr, String sep, String tab) {
    //     String list = "";

    //     for (int i=0;i<arr.length;i++) {
    //         if (i!=0) {list+=sep;}
    //         list+=tab+arr[i];
    //     }

    //     return list;
    // }

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