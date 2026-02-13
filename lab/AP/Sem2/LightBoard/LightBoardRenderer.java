package lab.AP.Sem2.LightBoard;

import javax.swing.*;
import java.awt.*;

/**
 * LightRenderer provides a Graphical User Interface (GUI) for various
 * LightBoard objects. Special thanks to Jerry Zhang, Mayo H.S. class of
 * 2025, for his work on this project.
 * 
 * @author Jerry Zhang
 * @author Mr. Dirks
 */
public class LightBoardRenderer extends JFrame {
  private final int NUM_COLS;
  private final int NUM_ROWS;
  private final int SIZE = 50;

  private final LightBoard board;

  private boolean partB;

  /**
   * Initializes and tests example LightBoard objects.
   * 
   * @param partB true, if testing and displaying part B; false otherwise
   */
  public LightBoardRenderer(boolean partB) {
    if (partB) {
      NUM_ROWS = 7;
      NUM_COLS = 5;
      // default
      board = new LightBoard();
      setSize(NUM_COLS * SIZE, (NUM_ROWS + 1) * SIZE + 72);
      setPreferredSize(new Dimension(NUM_COLS * SIZE, (NUM_ROWS + 1) * SIZE + 72));
    } else {
      NUM_ROWS = 3;
      NUM_COLS = 6;
      board = new LightBoard(NUM_ROWS, NUM_COLS);
      setSize(NUM_COLS * SIZE, (NUM_ROWS + 1) * SIZE);
      setPreferredSize(new Dimension(NUM_COLS * SIZE, (NUM_ROWS + 1) * SIZE));
    }

    this.partB = partB;

    setTitle("Light Display Part " + (partB ? "2" : "1"));
    setVisible(true);
    setResizable(false);
    setDefaultCloseOperation(DISPOSE_ON_CLOSE);
  }

  @Override
  public void paint(Graphics gg) {
    Graphics2D g = (Graphics2D) gg;
    g.setBackground(new Color(102, 102,102));
    g.clearRect(0, 0, getWidth(), getHeight());
    
    g.setStroke(new BasicStroke(2));
    g.setColor(new Color(255, 255, 0));

    boolean[][] lights = board.getLights();

    for (int r = 0; r < NUM_ROWS; r++) {
      for (int c = 0; c < NUM_COLS; c++) {
        int y = r * SIZE;
        int x = c * SIZE;

        g.drawRect(x, y + SIZE / 2, SIZE, SIZE);
        
        if (lights[r][c]) {
          g.fillRect(x, y + SIZE / 2, SIZE, SIZE);
        }
      }
    }
    if (!partB) {
      g.drawString("Part (a)", 10, getHeight() - 10);
    } else {      
      g.drawString("Part (b)", 10, getHeight() - 72);
      g.drawString("*Tests*", 10, getHeight() - 60);
      g.drawString("" + board.evaluateLight(0, 3), 10, getHeight() - 48);
      g.drawString("" + board.evaluateLight(6, 0), 10, getHeight() - 36);
      g.drawString("" + board.evaluateLight(4, 1), 10, getHeight() - 24); 
      g.drawString("" + board.evaluateLight(5, 4), 10, getHeight() - 12);
    }
  }

  public static void main(String[] args) {
    new LightBoardRenderer(false);
    new LightBoardRenderer(true);
 }
}