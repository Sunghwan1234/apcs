package lab6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * This game tracks reaction times.
 * 
 * @author Eric Kugel
 * @author Mr. Dirks
 */
public class ReactionGame extends JFrame {
  // GUI constants
  private final int WINDOW_SIZE = 500;
  private final Color RED = new Color(255, 60, 60);
  private final Color GREEN = new Color(60, 255, 60);

  // state constants and tracker
  private final int STATE_INSTRUCTIONS = 0;
  private final int STATE_WAITING = 1;
  private final int STATE_LIVE = 2;
  private final int STATE_DONE = 3;
  private int state = -1;

  // timer for delays
  private Timer timer;

  // GUI elements
  private JLabel header = new JLabel();
  private JPanel main = new JPanel();

  // time trackers
  private long startTime = -1;
  private long reactionTime = -1;

  /**
   * Extends the JFrame class; sets up a JFrame and 
   * calls the method to initialize the user interface.
   */
  public ReactionGame() {
    setTitle("Reaction Time Tester");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setResizable(false);
    setVisible(true);
    initGUI();
  }

  /**
   * Moves to the next state (3 goes to 0) after a specified delay.
   * 
   * @param millisecondDelay how long to wait in milliseconds before moving to the next state.
   */
  private void nextState(int millisecondDelay) {
    // reset the timer
    timer = new Timer(millisecondDelay, new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        // make sure to only run the timer event once
        timer.stop();
        
        // move to the next state
        state = (state + 1) % 4;

        // update the GUI based on the new state
        if (state == STATE_INSTRUCTIONS) {
            header.setText("<html><div style='text-align:center;padding-top:150px;'>Click anywhere when the <br> window turns green!</div></html>");
            main.setBackground(RED);
            nextState(1500);
        } else if (state == STATE_WAITING) {
            header.setText("");
            main.setBackground(RED);
            nextState((int) (Math.random() * 2000 + 2500));
        } else if (state == STATE_LIVE) {
            header.setText("");
            main.setBackground(GREEN);
            startTime = System.nanoTime();
            // do NOT move to a different state until stop() is called
        } else if (state == STATE_DONE) {
            header.setText("<html><div style='text-align:center;padding-top:150px;'>Your reaction time is " + reactionTime + "ms!</div></html>");
            System.out.println("Your reaction time is " + reactionTime + "ms!");
            main.setBackground(RED);
            nextState(2000);
        }
      }
    });
    timer.start();
  }

  /**
   * Initializes the graphical user interface.
   */
  private void initGUI() {
    // set up the main panel
    main.setPreferredSize(new Dimension(WINDOW_SIZE, WINDOW_SIZE));
    add(main, BorderLayout.CENTER);

    // set up the header label
    header.setFont(new Font("Verdana", Font.PLAIN, 24));
    main.add(header);
    pack();

    // listen for mouse clicks
    main.addMouseListener(new MouseAdapter() {
      @Override
      public void mousePressed(MouseEvent e) {
        // stop if the state is "live" or "waiting"
        if (state == STATE_LIVE) {
          stop(true);
        } else if (state == STATE_WAITING) {
          stop(false);
        }
      }
    });

    // begin the state cycle with the instructions
    nextState(0);
  }

  /**
   * Either congratulates or corrects the user,
   * based on whether or not they were supposed to click.
   * 
   * @param correctlyClicked
   */
  private void stop(boolean correctlyClicked) {
    if (correctlyClicked) {
        // calculate the stop time in nanoseconds
        long stopTime = System.nanoTime();
        // convert to milliseconds
        reactionTime = (stopTime - startTime) / 1000000;
        // congratulate user
        nextState(0);
    } else {
      // correct the user
      header.setText("<html><div style='text-align:center;padding-top:150px;'>You clicked too soon!</div></html>");
      main.setBackground(RED);
      // go back to STATE_INSTRUCTIONS
      state = STATE_INSTRUCTIONS;
      // do NOT move on to STATE_WATING right away
      timer.stop();
      // move to the next state (STATE_WAITING) after a delay
      nextState(1000);
    }
  }

  /**
   * Calls the constructor.
   * 
   * @param args
   */
  public static void main(String[] args) {
    new ReactionGame();
  }
}
