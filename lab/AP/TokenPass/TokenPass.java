package AP.TokenPass;

/**
 * Token Pass is a multiplayer game in which token are distributed amongst 
 * players.
 */
public class TokenPass {
  private int[] board={3,2,6,10};
  private int currentPlayer;
  
  /** 
   * Creates the board array to be of size playerCount and fills it with
   * random integer values from 1 to 10, inclusive.  Initializes currentPlayer to a
   * random integer value in the range between 0 and playerCount - 1, inclusive.
   * 
   * @param playerCount the number of players
   */
  public TokenPass(int playerCount)
  {
    // board = new int[playerCount];
    // for (int i=0;i<playerCount;i++) {
    //   board[i] = (int) (Math.random()*10+1);
    // }

    currentPlayer = (int) (Math.random()*playerCount);
  }
  
  
  /** 
   * Distributes the tokens from the current player's position one at a time to each player in
   * the game.  Distribution begins with the next position and continues until all the tokens
   * have been distributed.  If there are still tokens to distribute when the player at the
   * highest position is reached, the next token will be distributed to the player at position 0.
   * Precondition: the current player has at least one token.
   * Postcondition: the current player has not changed.
   */
  public void distributeCurrentPlayerTokens()
  { 
    int tokensTaken = board[currentPlayer];
    board[currentPlayer] = 0;

    int tokenDistPlayer = (currentPlayer+1)%board.length;
    for (int i=0;i<tokensTaken;i++) {
      board[tokenDistPlayer]++;
      tokenDistPlayer = (tokenDistPlayer+1)%board.length;
    }
  }
  
  
  /** 
   * Returns the current player.
   * Not included in the original AP question.
   * 
   * @return the index of the current player
   */
  public int getCurrentPlayer() {
    return currentPlayer;
  }
  
  /** 
   * Returns the number of tokens at each index on the board.
   * Not included in the original AP question.
   * 
   * @return a string representation of the object
   */
  public String toString() {
    String output = "";
    for (int i = 0; i < board.length; i++) {
      output += board[i] + "\t";
    }
    return output;
  }
  
}
