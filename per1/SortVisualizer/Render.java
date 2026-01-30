

import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class Render {
  public static final int FRAME_WIDTH = 500, FRAME_HEIGHT = 500;
  public static final int PANEL_HEIGHT = FRAME_HEIGHT-60;

  private static final JFrame frame = new JFrame("JFrame");
  private static final JPanel panel = new JPanel() {
      @Override
      public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.LIGHT_GRAY); g.fillRect(0, 0, FRAME_WIDTH, FRAME_HEIGHT);
        
        g.setColor(Color.black);
        g.drawRect(mouse.x, mouse.y, 10, 10);

        for (Block b:Block.blockArray) {
          b.paint(g);
        }

        if (sort!=null && ticks>-1) {
          for (int i=0;i<getCVArray().length;i++) {
            g.setColor(Color.getHSBColor((float)i/getCVArray().length, 1, 1));
            g.drawString(sort.getTypes()[i], Block.getXAt((int)getCVArray()[i]), FRAME_HEIGHT-75);
          }
        }

      }
    };
  public static final Timer ticker = new Timer(1, new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        mouse = panel.getMousePosition()==null ? mouse : panel.getMousePosition();
        panel.repaint();
      }
    });;

  private static Timer timer;
  public static int ticks = -1;
  private static Sort sort;

  public static Point mouse = new Point(0, 10);

  static int[] array = {4,3,7,8,2,9,1,5,6,0};

  public static int pointerX = 0;

  public static void main(String[] args) {
    frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    panel.setLayout(new BorderLayout());
    JButton button = new JButton("Run");
    button.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Button clicked!");
            startAnimation();
        }
    });
    JPanel controlPanel = new JPanel();
    controlPanel.add(button);
    // Init Finished //

    for (int i=0;i<array.length;i++) {
      Block.blockArray[i] = new Block(i,array[i]);
    }

    panel.add(controlPanel, BorderLayout.SOUTH);
    panel.setPreferredSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT));
    frame.add(panel);
    frame.setVisible(true);
    ticker.start();
  }

  public static void startAnimation() {
    sort = new Sort(array, 2);
    System.out.println(sort);
    ticks = 0;
    timer = new Timer(500, new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        animateTick();
      }
    });
    timer.start();
    System.out.println("Timer Started.");
  }

  public static void animateTick() {
    System.out.println(">> Tick "+ticks);
    if (ticks+1>=sort.getLogLength()) { // Loop
      timer.stop();
      System.out.println("Stopping Timer.");
      System.out.println("Sort has finished in "+ticks+" Ticks.");
      ticks = -1;
    } else {
      ticks++;
    } 
  }

  /** Get Current Tick Array */
  public static int[] getCTArray() {return sort.getArray(ticks);}
  public static Object[] getCVArray() {return sort.getVars(ticks);}
}
