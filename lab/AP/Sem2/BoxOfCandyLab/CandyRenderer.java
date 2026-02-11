import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.awt.event.*;

/**
 * CandyRenderer provides a GUI (Graphical User Interface) to interact with
 * the BoxOfCandy lab, as opposed to a CLI (Command Line Interface) that is
 * only text-based.
 * 
 * Special thanks to Jerry Zhang, Mayo H.S. class of 2025, for his work on
 * this GUI.
 * 
 * @author Jerry Zhang
 * @author Mr. Dirks
 */
public class CandyRenderer extends JFrame {
  private final int WIDTH = 5;
  private final int HEIGHT = 5;
  private final int SIZE = 150;
  private final int MAX_INDEX = 7;
  private JButton prev = null;
  private JLabel label = null;
  private JButton next = null;
  private JPanel panel = null;

  /**
   * The current state of the program
   * (The user can press buttons to step forward or backward.)
   */
  private int index = 0;

  private Candy[][] boxA;
  private BoxOfCandy partA;

  private Candy[][] boxB;
  private BoxOfCandy partB;

  /**
   * Initializes the GUI.
   */
  public CandyRenderer() {
    setSize(WIDTH * SIZE, HEIGHT * SIZE);
    setPreferredSize(new Dimension(WIDTH * SIZE, HEIGHT * SIZE));
    setBackground(new Color(255, 255, 255));
    setTitle("Candy Display");
    setResizable(false);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setAlwaysOnTop(true);

    next = new JButton("Next");
    next.addActionListener(new NextListener());
    prev = new JButton("Previous");
    prev.addActionListener(new PrevListener());
    label = new JLabel();
    
    panel = new JPanel();
    panel.setBackground(new Color(255, 255, 255));
    panel.add(prev);
    panel.add(label);
    panel.add(next);

    getContentPane().add(panel);
    pack();
    setVisible(true);
  }

  /**
   * Increments the index by 1.
   */
  public void incrIndex() {
    incrIndex(index + 1);
  }

  /**
   * Increments the index by param.
   * 
   * @param x the value to be incremented by
   */
  public void incrIndex(int x) {
    index = x;
    if (index > MAX_INDEX) {
      index = 0;
    } else if (index < 0) {
      index = MAX_INDEX;
    }

    repaint();
  }

  /**
   * Decrements the index by 1.
   */
  public void decrIndex() {
    incrIndex(index - 1);
  }

  /**
   * Initializes variables, as initially called by the constructor and
   * in repainting the GUI.
   */
  private void initVars() {
    boxA = new Candy[][] { { null, new Candy("lime"), null },
        { null, new Candy("orange"), null },
        { null, null, new Candy("cherry") },
        { null, new Candy("lemon"), new Candy("grape") } };
    partA = new BoxOfCandy(boxA);

    boxB = new Candy[][] { { new Candy("lime"), new Candy("lime"), null, new Candy("lemon"), null },
        { new Candy("orange"), null, null, new Candy("lime"), new Candy("lime") },
        { new Candy("cherry"), null, new Candy("lemon"), null, new Candy("orange") } };
    partB = new BoxOfCandy(boxB);
  }

  @Override
  public void paint(Graphics gg) {
    Graphics2D g = (Graphics2D) gg;
    g.setBackground(new Color(255, 255, 255));
    g.clearRect(0, 72, this.getWidth(), this.getHeight());
    g.setColor(Color.BLACK);

    initVars();

    // "re-run" code based on the index, progressively step through
    // reset code each time
    switch (index) {
      case 0:
        displayBox(g, boxA, "Part A Initial Setup");
        break;

      case 1:
        displayBox(g, boxA, "Move candy in column 0: " + partA.moveCandyToFirstRow(0));
        break;

      case 2:
        partA.moveCandyToFirstRow(0);
        displayBox(g, boxA, "Move candy in column 1: " + partA.moveCandyToFirstRow(1));
        break;

      case 3:
        partA.moveCandyToFirstRow(0);
        partA.moveCandyToFirstRow(1);
        displayBox(g, boxA, "Move candy in column 2: " + partA.moveCandyToFirstRow(2));
        break;

      case 4:
        displayBox(g, boxB, "Part B Initial Setup");
        break;

      case 5:
        displayBox(g, boxB, "Remove cherry: " + partB.removeNextByFlavor("cherry"));
        break;

      case 6:
        partB.removeNextByFlavor("cherry");
        displayBox(g, boxB, "Remove lime: " + partB.removeNextByFlavor("lime"));
        break;

      case 7:
        partB.removeNextByFlavor("cherry");
        partB.removeNextByFlavor("lime");
        displayBox(g, boxB, "Remove grape: " + partB.removeNextByFlavor("grape"));
        break;
    }
  }

  /**
   * Draws the box of candy.
   * 
   * @param g    Graphics2D element
   * @param box  the 2D array of Candy objects to be visualized
   * @param name action completed in this step
   */
  private void displayBox(Graphics2D g, Candy[][] box, String name) {

    float thickness = 2;

    for (int r = 0; r < box.length; r++) {
      for (int c = 0; c < box[0].length; c++) {
        int x = SIZE * (WIDTH - box[0].length) / 2 + c * SIZE;
        int y = r * SIZE;  

        g.setStroke(new BasicStroke(thickness));
        g.setColor(Color.WHITE);
        g.fillRect(x, y + SIZE / 2, SIZE, SIZE);

        if (box[r][c] != null) {
          displayImage(g, box[r][c].getFlavor(), x + 1, y + SIZE / 2 + 1);
        }

        g.setColor(Color.BLACK);
        g.drawRect(x, y + SIZE / 2, SIZE, SIZE);
      }
    }

    label.setText("\n" + index + ". " + name);
  }

  /**
   * Displays images if the box contains candy.
   * 
   * @param g    Graphics2D element
   * @param name file name to be loaded
   * @param x    horizontal coordinate
   * @param y    vertical coordinate
   */
  private void displayImage(Graphics2D g, String name, int x, int y) {
    try {
      BufferedImage image = ImageIO
          .read(new File(getClass().getClassLoader().getResource("images/" + name + ".png").toURI()));
      g.drawImage(image, x, y, SIZE, SIZE, this);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * Increments index when Next button is clicked.
   */
  private class NextListener implements ActionListener {
    public void actionPerformed(ActionEvent event) {
      incrIndex();
    }
  }

  /**
   * Decrements index when Prev button is clicked.
   */
  private class PrevListener implements ActionListener {
    public void actionPerformed(ActionEvent event) {
      decrIndex();
    }
  }

  /**
   * The main method instantiates this CandyRenderer.
   * 
   * @param args command line arguments, not applicable
   */
  public static void main(String[] args) {
    new CandyRenderer();
  }
}