package lab.AP.Sem2.Crossword;

import java.awt.*;
import javax.swing.*;

/**
 * Creates a visual depiction of a crossword puzzle
 * 
 * @author Junhao Zhang - Mayo H.S. class of 2025
 * @author Mr. Dirks
 */
class CrosswordGUIRunner extends JFrame {
  private final int HEIGHT; // height, in squares
  private final int WIDTH; // width, in squares
  private final int SQUARE_SIZE; // size, in pixels, of each square
  private final int TITLE_BAR_HEIGHT = 28;
  private Square[][] squares = null;

  /**
   * Creates a new Crossword GUI instance.
   * 
   * @param squares the 2-D array of Squares
   */
  private CrosswordGUIRunner(Square[][] squares) {
    this.squares = squares;
    HEIGHT = squares.length;
    WIDTH = squares[0].length;

    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    SQUARE_SIZE = (int) (screenSize.getHeight() / (1.5 * HEIGHT));
    Dimension windowSize = new Dimension((int) (WIDTH * (SQUARE_SIZE + 0.75)),
        (int) (HEIGHT * SQUARE_SIZE + TITLE_BAR_HEIGHT));
    setSize(windowSize);
    setPreferredSize(windowSize);
    setTitle("Crossword Display");
    setLayout(null);
    setVisible(true);
    setResizable(false);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
  }

  /**
   * Draws the crossword puzzle on the screen.
   * 
   * @param render the state to be rendered
   */
  @Override
  public void paint(Graphics render) {
    for (int row = 0; row < squares.length; row++) {
      for (int col = 0; col < squares[0].length; col++) {
        int y = row * SQUARE_SIZE;
        int x = col * SQUARE_SIZE + 5;
        render.setColor(Color.BLACK);
        render.fillRect(x, y + TITLE_BAR_HEIGHT, SQUARE_SIZE, SQUARE_SIZE); // black square fill or white square outline
        if (!squares[row][col].isBlack()) {
          render.setColor(Color.white);
          render.fillRect(x + 2, y + TITLE_BAR_HEIGHT + 2, SQUARE_SIZE - 2, SQUARE_SIZE - 2); // white square fill
          if (squares[row][col].getNum() > 0) {
            render.setColor(Color.black);
            render.setFont(new Font("SansSerif", Font.BOLD, SQUARE_SIZE / 3)); // white square number
            render.drawString(Integer.toString(squares[row][col].getNum()), x + 5,
                y + TITLE_BAR_HEIGHT + SQUARE_SIZE / 3 + 2);
          }
        }
      }
    }
  }

  /**
   * Converts a comma-separated string into a boolean 2D array, in which the
   * first string element is the rows of the array, the second string element
   * is the columns of the array, and the subsequent 1's and 0's depict true
   * and false values of the array to be populated as such.
   * 
   * @param input the comma-separated string.
   * @return a two-dimensional array depicting squares in a crossword
   *         grid, in which "true" elements are considered to be black
   *         and "false" elements are considered to be white
   */
  private static boolean[][] getBlackSquares(String input) {
    String[] inputArray = input.split(",");
    int rows = Integer.parseInt(inputArray[0]);
    int cols = Integer.parseInt(inputArray[1]);
    boolean[][] blackSquares = new boolean[rows][cols];

    int count = 2;
    for (int row = 0; row < blackSquares.length; row++) {
      for (int col = 0; col < blackSquares[0].length; col++) {
        if (inputArray[count].equals("1")) {
          blackSquares[row][col] = true;
        }
        count++;
      }
    }
    return blackSquares;
  }

  /**
   * The main method constructs and displays two crossword puzzles.
   */
  public static void main(String[] args) {
    String apExample = "7,9,1,0,0,1,1,1,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,1,1,1,0,0,1,0,0,0,1,0,0,1,1,1,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,1,1,1,0,0,1";
    Crossword apTimes = new Crossword(getBlackSquares(apExample));
    Square[][] apSquares = apTimes.getPuzzle();
    new CrosswordGUIRunner(apSquares); // depicts AP example

    String laExample = "21,21,0,0,0,0,1,0,0,0,0,1,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,1,0,0,0,0,1,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,1,0,0,0,0,1,0,0,0,0,1,1,1,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,1,1,0,0,0,1,1,1,0,0,0,1,1,0,0,0,1,1,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,1,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,1,0,0,0,0,1,1,0,0,0,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,0,0,0,1,1,0,0,0,0,1,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,1,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,1,1,0,0,0,1,1,0,0,0,1,1,1,0,0,0,1,1,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,1,1,1,0,0,0,0,1,0,0,0,0,1,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,1,0,0,0,0,1,0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,1,0,0,0,0,1,0,0,0,0";
    Crossword laTimes = new Crossword(getBlackSquares(laExample));
    Square[][] laSquares = laTimes.getPuzzle();
    new CrosswordGUIRunner(laSquares); // depicts LA Times example
  }

}