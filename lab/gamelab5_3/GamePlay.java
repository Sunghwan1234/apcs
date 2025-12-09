package gamelab5_3;

import java.util.*;

/**
 * GamePlay contains a main method to play a Star Wars-based video game.
 */
public class GamePlay {
  public static void main (String args[]) {
    // makes the map
    Map theMap = new Map();
    
    // makes the scanner
    Scanner scan = new Scanner(System.in);
    
    // welcome message and directions
    System.out.println("Welcome to Star Wars Episode 0");
    System.out.println("The New Worst Star Wars Video Game\n");
    
    // creates the player's Hero and introduces him/her
    System.out.println("Princess Leia is trapped in a holding cell.  It's your job to locate the princess and get her back to Cloud City!");
    System.out.println("What is your name, jedi?  (Only one word!)");
    String name = scan.next();
    Hero player = new Hero(name, 4);
    System.out.println("Great to meet you, " + name + ".");
    System.out.println("Your stamina is " + player.getStamina() + ".  The max stamina you can have is 10.  If your stamina drops to 0, the game is over!");
    System.out.println("Your strength is " + player.getStrength() + ".  The max strength you can have is 10.  You will need to have a certain amount of strength to defeat each villian.  You can earn strength points throughout the game.");
    System.out.println("To move from room to room, enter the number of the direction you would like to go.  For example, I might tell you that you can go west (2) or east (4).  If you wanted to go west, you'd type in 2.");
    System.out.println("Let's begin!\n");
    
    // sets the current room to 1 and asks the player for first move
    player.setCurrentRoom(1);
    
    // starts the game
    boolean play = true;
    
    while (play) {
      theMap.listAllMoves(player.getCurrentRoom());
      
      // asks the user for the next move
      System.out.println("Where would you like to go?");
      int playerMove = scan.nextInt();
      
      // keeps asking if they submit something incorrect
      if (!theMap.checkMove(playerMove)) {
        System.out.println("That is not a valid answer.  Try again.");
        playerMove = scan.nextInt();
      }
      
      // moves the player to the new room
      player.setCurrentRoom(playerMove);
      
      // initiates the action of the room
      theMap.playAction(player, player.getCurrentRoom());
      
      // checks to see if the player is still alive
      if (player.isDead()) {
        System.out.println("Oh no, looks like you're dead.  Better luck next time!");
        System.out.println("GAME OVER");
        play = false;
      } else {
        // checks to see if Leia has been found
        if (theMap.checkForWin()) {
          System.out.println("Thanks for playing!");
          play = false;
        } else {
          System.out.println("\nWe must keep moving!");
          
          // allows the player to check their stats
          System.out.println("Do you want to check your stats before you go?  Yes (y) or no (n)?");
          String ans = scan.next();
          while (!ans.equals("y") && !ans.equals("n")) {
            System.out.println("That is not a choice!  Pick yes (y) or no (n).");
            ans = scan.next();
          }
          
          if (ans.equals("y")) {
            System.out.println("Your stamina is " + player.getStamina() + ".");
            System.out.println("Your strength is " + player.getStrength() + ".\n");
          }
        }
      }
    }
  }
}