import java.util.*;

/**
 * The map contains the setup for all rooms in the game.
 */
public class Map {
  // instance variables
  // int for each room
  private int room1 = 1;
  private int room2 = 2;
  private int room3 = 3;
  private int room4 = 4;
  private int room5 = 5;
  private int room6 = 6;
  private int room7 = 7;
  
  // ints to keep track of how many times the player has entered a room
  private int enters1 = 0;
  private int enters2 = 0;
  private int enters3 = 0;
  private int enters4 = 0;
  private int enters5 = 0;
  private int enters6 = 0;
  private int enters7 = 0;
  
  // an ArrayList to document all available moves
  private ArrayList<Integer> allMoves = new ArrayList<Integer>();
  
  // a boolean for when Yoda is asking a question
  boolean rightAnswer = false;
  // a boolean for when the user has found the powerful lightsaber
  boolean lsfound = false;
  // a boolean for whether or not Leia has been found
  boolean foundLeia = false;
  
  // two villians for the map
  Villain v3 = new Villain("Darth Maul", 5);
  Villain v7 = new Villain("Darth Sidious", 7);
  
  // default constructor used, not necessary to write
  
  /**
   * Lists all the moves the player can make.
   *
   * @param currentRoom  the room currently occupied by the player
   * @return             an ArrayList of possible rooms to move to
   */
  public ArrayList<Integer> listAllMoves(int currentRoom) {
    if (currentRoom == 1) { // moves from room 1
      enters1++;
      allMoves.clear();
      allMoves.add(2);
      allMoves.add(4);
      System.out.println("You may go east (2) or south (4)!");
    } else if (currentRoom == 2) { // moves from room 2
      enters2++;
      allMoves.clear();
      allMoves.add(1);
      System.out.println("You may only go west (1)!");
    } else if (currentRoom == 3) { // moves from room 3
      enters3++;
      allMoves.clear();
      allMoves.add(4);
      System.out.println("You may only go east (4)!");
    } else if (currentRoom == 4) { // moves from room 4
      enters4++;
      allMoves.clear();
      allMoves.add(1);
      allMoves.add(3);
      allMoves.add(5);
      System.out.println("You may go north (1), west (3), or east (5)!");
    } else if (currentRoom == 5) { // moves from room 5
      enters5++;
      allMoves.clear();
      allMoves.add(4);
      allMoves.add(7);
      allMoves.add(6);
      System.out.println("You may go west (4), north (7), or south (6)!");
    } else if (currentRoom == 6) { // moves from room 6
      enters6++;
      allMoves.clear();
      allMoves.add(5);
      System.out.println("You may only go north (5)!");
    } else { // moves from room 7
      enters7++;
      allMoves.clear();
      allMoves.add(5);
      System.out.println("You may only go south (5)!");
    }
    
    return allMoves;
  }
  
  /**
   * Checks to see if the player's move is valid.
   *
   * @param aMove  the player's potential move
   * @return       true if potential move is found in list of available moves;
   *               false otherwise
   */
  public boolean checkMove(int aMove) {
    return allMoves.contains(aMove);
  }
  
  /**
   * Checks to see if game is won.
   *
   * @return  true if Leia has been found;
   *          false otherwise
   */
  public boolean checkForWin() {
    return foundLeia;
  }
  
  /**
   * Sets action for rooms.
   *
   * @param aPlayer  the protagonist in the game
   * @param aRoom    the current room
   */
  public void playAction(Hero aPlayer, int aRoom) {
    Scanner scan = new Scanner(System.in);
    if (aRoom == 1) { // action for Room 1 -----------------------------------------------
      System.out.println("This is the room where you started.  Not much to see here.");
    }
    
    if (aRoom == 2) { // action for Room 2 -----------------------------------------------
      System.out.println("You enter a dark and dreary holding cell.  A box sits in the corner.  Is that creepy scratching noise coming from the box, or is it your imagination?");
      System.out.println("Do you look in the box (y) or not (n)?");
      String ans = scan.next();
      while (!ans.equals("y") && !ans.equals("n")) {
        System.out.println("That is not a choice!  Pick yes (y) or no (n).");
        ans = scan.next();
      }
      
      if (ans.equals("y")) {
        System.out.println("You found some food!  Your stamina increases by 2, and it looks like there will be more for later.");
        System.out.println("Your current stamina is " + aPlayer.addStamina(2));
      } else {
        System.out.println("Well this is boring.");
      }    
    }
    
    if (aRoom == 3) { // action for Room 3 -----------------------------------------------
      if (!v3.isDead()) { // if the villian hasn't been defeated ...
        System.out.println("You stumble upon a sith named " + v3.getName() + ".  Do you want to battle (y) or not (n)?");
        String ans = scan.next();
        while (!ans.equals("y") && !ans.equals("n")) { // check for valid choice
          System.out.println("That is not a choice!  Pick yes (y) or no (n).");
          ans = scan.next();
        }
        
        if (ans.equals("y")) { // if you battle ...
          System.out.println("Alright, if you say so.");
          
          if (aPlayer.compareTo(v3) <= 0) {
            System.out.println("You approach " + v3.getName() + " but he quickly knocks the light saber out of your hand.  Your stamina is now " + aPlayer.decreaseStamina(5) + "!");
            System.out.println("\"Hahahahahahaha you have been vanquished!\" laughs " + v3.getName() + ".");
          } else {
            System.out.println("With your new Jedi skills, you easily defeat " + v3.getName() + ". Your strength has increased to " + aPlayer.addStrength(2));
            v3.setDead(true);
          }
        } else { // if you don't battle ...
          System.out.println("Yeah, sounds good.  Let's get out of here!");
        }
      } else { // if the villian has been defeated ...
        System.out.println("Hm.  Nothing to see here, really.");
      }
    }
    
    if (aRoom == 4) { // action for Room 4 -----------------------------------------------
      if (enters4 == 0) { // if this is your first time in the room ...
        System.out.println("You enter a large conference room.  Do you want to look around (y) or keep moving (n)?");
        String ans = scan.next();
        while (!ans.equals("y") && !ans.equals("n")) { // check for valid choice
          System.out.println("That is not a choice!  Pick yes (y) or no (n).");
          ans = scan.next();
        }
        
        if (ans.equals("y")) { // if they want to look around
          System.out.println("At the end of the long glass table is a shining light saber.");
          System.out.println("You grab the weapon and hold it up to the light.  You sense power flowing through it and you immediately feel stronger.");
          System.out.println("Your strength has increased to " + aPlayer.addStrength(2) + "!");
          lsfound = true;
        } else { // if they want to keep moving
          System.out.println("Yeah, you've got stuff to do.");
        }
      } else { // if this isn't your first time in the room
        if (lsfound) { // if you already found the light saber
          System.out.println("You reenter the large conference room.  Nothing but an empty box of Duncan Donuts left here.");
        } else { // if you haven't found the light saber yet
          System.out.println("At the end of the long glass table is a shining light saber.");
          System.out.println("You grab the weapon and hold it up to the light.  You sense power flowing through it and you immediately feel stronger.");
          System.out.println("Your strength has increased to " + aPlayer.addStrength(2) + "!");
          lsfound = true;
        }
      }
    }    
    
    if (aRoom == 5) { // action for Room 5 -----------------------------------------------
      if (rightAnswer == false) { // if you haven't gotten the question right ...
        if (enters5 == 0) { // if this is your first time in the room ...
          System.out.println("You turn the corner and you're in a long white hallway.  You spot Yoda, your jedi master sitting in the shadows.");
          System.out.println("\"Hello, " + aPlayer.getName() + ", trying to save the princess you are.  Hm?\"");
          System.out.println("\"Yes and I'm in a bit of a hurry, master, if you don't mind.\" you say.");
          System.out.println("\"Always in a rush, you are.  Young ones do not understand the ways of the force.\" croaks Yoda.");
        } else { // if this is NOT your first time in the room ...
          System.out.println("\"Trying again, you are.\" says Yoda.  \"Better luck you must have.\"");
        }
        System.out.println("\"Answer my questions, and help you I will.\" he says.  \"What color was Mace Windu's light saber?");
        System.out.println("What will you answer?  Blue (b), green (g), or purple (p)?");   
        String ans = scan.next();
        
        while (!ans.equals("b") && !ans.equals("g") && !ans.equals("p")) { // check for valid input
          System.out.println("That is not a choice!  Pick blue (b), green (g), or purple (p).");
          ans = scan.next();
        }
        
        if (ans.equals("p")) { // if you got it right ...
          System.out.println("\"Very good, padawan.  More strength you now possess.  Good luck, young jedi.\"");
          System.out.println("Your strength has increased to " + aPlayer.addStrength(1));
          rightAnswer = true;
        } else { // if you got it wrong ...
          System.out.println("Yoda sighs.  \"Using your smartphone too much, you are.\" he says.  \"Pay more attention you must.\"");
          rightAnswer = false;
        }
      } else { // if you've been in the room before ...
        System.out.println("\"Nice to see you again, padawan.\" says Yoda.");
      } 
    }
    
    if (aRoom == 6) { // action for Room 6 -----------------------------------------------
      if (enters6 == 0) { // if you've never been in the room before ...
        System.out.println("You have found the cell where Princess Leia is trapped!  You call her name but you don't hear anything.  You worry that she is in more danger than you thought!");
      } else {
        System.out.println("You are back in Princess Leia's holding cell.");
      }
      System.out.println("You must have strength of 10 to break open the door.");
      
      if (aPlayer.getStrength() == 10) { // if you can break in
        System.out.println("Your strength is " + aPlayer.getStrength() + ". You use the Force to break the lock and open the door, then rush inside to rescue the princess.");
        System.out.println("The cell is empty save for one piece of paper.  You pick it up, recognize Leia's handwriting, and begin to read.\n");
        System.out.println("Dear " + aPlayer.getName() + ",\n");
        System.out.println("By the time you read this, I will have broken out of this cell myself because I got tired of waiting to be rescued.  Being");
        System.out.println("rescued is overrated and it's also very boring.  Thanks for trying, though.\n");
        System.out.println("Imma head back to Cloud City.  Let me know if you want to meet up for Chipotle or whatever.\n");
        System.out.println("Yours, \n\tLeia\n");
        System.out.println("Um ... well, congratulations, you won!");
        foundLeia = true;
      } else { // if you can't break in
        System.out.println("Your strength is only " + aPlayer.getStrength() + ".  Try defeating more sith to gain more strength!");
      }
    }
    
    if (aRoom == 7) { // action for Room 7 -----------------------------------------------
      if (!v7.isDead()) { // if the villian hasn't been defeated ...
        System.out.println("You stumble upon a sith named " + v7.getName() + ".  Do you want to battle (y) or not (n)?");
        String ans = scan.next();
        while (!ans.equals("y") && !ans.equals("n")) { // check for valid choice
          System.out.println("That is not a choice!  Pick yes (y) or no (n).");
          ans = scan.next();
        }
        
        if (ans.equals("y")) { // if you battle ...
          System.out.println("Alright, if you say so.");
          if (aPlayer.compareTo(v7) <= 0) {
            System.out.println("You approach " + v7.getName() + " but he quickly knocks the light saber out of your hand.  Your stamina is now " + aPlayer.decreaseStamina(5) + "!");
            System.out.println("\"Hahahahahahaha you have been vanquished!\" laughs " + v7.getName() + ".");
          } else {
            System.out.println("With your new Jedi skills, you easily defeat " + v7.getName() + ". Your strength has increased to " + aPlayer.addStrength(2));
            v7.setDead(true);
          }
        } else { // if you don't battle ...
          System.out.println("Yeah, sounds good.  Let's get out of here!");
        }
      } else { // if the villian has been defeated ...
        System.out.println("Hm.  Nothing to see here, really.");
      }
    }
  }
}