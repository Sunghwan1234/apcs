package SortVisualizer;

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

  public static final JFrame frame = new JFrame("JFrame");
  public static final JPanel panel = new JPanel() {
      @Override
      public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.LIGHT_GRAY); g.fillRect(0, 0, FRAME_WIDTH, FRAME_HEIGHT);
        
        g.setColor(Color.black);
        g.drawRect(mouse.x, mouse.y, 10, 10);

        for (Block b:Block.blockArray) {
          b.paint(g);
        }

        if (pointerX!=-1) {
          g.setColor(Color.RED);
          g.drawString("^", Block.getXAt(pointerX)+5, FRAME_HEIGHT-75);
          g.setColor(Color.BLUE);
          g.drawString("^", Block.getXAt(pointerX+1)+5, FRAME_HEIGHT-75);
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

  public static Timer timer;
  public static int ticks = 0;

  public static Point mouse = new Point(0, 10);
  public static final JButton button = new JButton("Run");

  public static int[] array = {4,3,7,8,2,9,1,5,6,0};

  public static int pointerX = 0;

  public static void main(String[] args) {
    frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    panel.setLayout(new BorderLayout());
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
    Sorter.array = array;

    panel.add(controlPanel, BorderLayout.SOUTH);
    panel.setPreferredSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT));
    frame.add(panel);
    frame.setVisible(true);
    ticker.start();
  }

  public static void startAnimation() {
    Sorter sort = new Sorter(1);
    ticks = 0;
    timer = new Timer(500, new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        System.out.println(">> Tick "+ticks);
        if (sort.sortWhile()) { // Loop
          ticks++;

          sort.step();

          pointerX = sort.pointer;

        } else {
          timer.stop();
          System.out.println("Stopping Timer.");
          System.out.println("Sort has finished in "+ticks+" Ticks.");
        }
      }
    });
    timer.start();
    System.out.println("Timer Started.");
  }

  public static void setDrawingPointer(int pointer) {
    pointerX = pointer;
  }
}
