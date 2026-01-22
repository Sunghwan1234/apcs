package SortVisualizer;

import javax.swing.*;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.MouseInfo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class Main  {
  public static final int FRAME_WIDTH = 500, FRAME_HEIGHT = 500;

  public static JFrame frame = new JFrame("JFrame");
  public static JPanel panel;
  public static Timer timer;
  public static ActionListener actionListener;

  public static Point mouse = new Point(0, 10);

  public static void main(String[] args) {
    frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    actionListener = new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        mouse = panel.getMousePosition()==null ? new Point(mouse) : panel.getMousePosition();
        panel.repaint();
      }
    };

    panel = new JPanel() {
      @Override
      public void paint(Graphics g) {
        g.setColor(Color.LIGHT_GRAY); g.fillRect(0, 0, FRAME_WIDTH, FRAME_HEIGHT);
        
        g.setColor(Color.black);
        g.drawRect(mouse.x, mouse.y, 10, 10);

        g.dispose();
      }
    };

    timer = new Timer(1, actionListener);
    // End of initialization.
    frame.add(panel);
    frame.setVisible(true);
    timer.start();
  }
}
