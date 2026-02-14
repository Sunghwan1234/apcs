package Roomroot;
import java.util.ArrayList;
import java.util.Scanner;

import Roomroot.Action.Type;

public class Roomroot {
    public enum Status {
        passive,
        combat
    }

    public static final boolean debug = false;

    public static Status status = Status.passive;
    private static boolean inPlay = true;

    public static Player player;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        pSep(); pl();
        p("Player name: ");
        player = new Player(input.nextLine());
        pl(); pSep();
        pl("Welcome to Roomroot, "+player+".");
        pl("Starting Roomroot v1.0...");
        if (debug) {pl("Debug Mode is Enabled.");}
        pSep();
        newLines(10);

        // Initialization
        player.loc = new Location("Spawn");
        player.inventory.add(Item.getNew("Wand"));
        player.equip(player.inventory.get(0));

        pl("You have arrived at "+player.loc+".");
        pl(); pSep();
        /* Game Loop */
        while (inPlay) {
            if (status==Status.passive) {
                player.loc.visit(player);
                pl("You are at "+player.loc+".");
                if (!player.loc.discovered) {
                    pl("You have discovered a new location!");
                    player.loc.discovered=true;
                }
                pl(printDescriptions(player.loc.getDescription(), "\n", "\t"));
            } else if (status==Status.combat) {
                pl("There are "+player.targets.size()+" "+player.getTarget().toString()+" near you! ");
                //pl(printDescriptions(Monster.getMonsterNames(player.targets), ", ", ""));

                for (Monster m : player.targets) {
                    if (m.isAlive()) {
                        pl(printStatus(m.getStatus())); // Get status of Monster
                    }
                }
            }
            pl();
            pl("Your Status:\n"+printStatus(player.getStatus()));
            if (player.getWeapon()!=null) {
                pl("Equipped Weapon: "+player.getWeapon());
            }
            if (status==Status.combat && player.getTarget()!=null) {
                pl("Currect Target: "+player.getTarget()); // TODO: does this work
            }
            pl();

            /* Choose Actions */
            Action playerAction = new Action(Type.CUSTOM);
            boolean choseFinalAction = false;
            while (!choseFinalAction) {
                // Choose Player Action
                playerAction = chooseAction(player.getActions(), input, "Your Actions: ");
                while (playerAction.type.com == Type.SUBACTION.com) {
                    playerAction = chooseAction(playerAction.subactions, input, playerAction.execute(player), "\n", "\t");
                }
                if (playerAction.type.com!=Type.BACK.com) {choseFinalAction=true;}
            }

            pSep(); pl();
            pl(playerAction.execute(player));

            if (status==Status.combat) {
                boolean endCombat=true;
                for (Monster m : player.targets) {
                    if (m.isAlive()) {
                        pl(m.getActions().get(0).execute(player));
                        endCombat=false;
                    }
                }
                if (endCombat) {
                    pl("You have killed all the monsters!");
                    status = Status.passive;
                }
            }

            if (!player.isAlive()) {inPlay=false;
                pl("\nYou have died.");
            }

            pl(); pSep(); p("Continue"); input.nextLine(); pSep();
        }
        input.close();
    }

    public static void checkDeaths() {

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
            p("| Choose your Action (number): ");
            try {
                actionNumber = Integer.parseInt(input.nextLine());
            } catch (Exception e) {
                //pl("Invalid input. Please enter a number corresponding to an action.");
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
    public static String toOneString(ArrayList<String> array) {
        String s="";
        for (int i=0;i<array.size();i++) {if (i!=0){s+="\n";} s+=array.get(i);}
        return s;
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
    public static void debugLine(Object o) {if (debug) {p("..");pl(o);}}
}