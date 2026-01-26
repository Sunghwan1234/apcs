package SortVisualizer;

import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.MouseInfo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class Main {
  public static final int FRAME_WIDTH = 500, FRAME_HEIGHT = 500;

  public static JFrame frame = new JFrame("JFrame");
  public static JPanel panel = new JPanel() {
      @Override
      public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.LIGHT_GRAY); g.fillRect(0, 0, FRAME_WIDTH, FRAME_HEIGHT);
        
        g.setColor(Color.black);
        g.drawRect(mouse.x, mouse.y, 10, 10);
      }
    };
  public static Timer timer = new Timer(1, new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        mouse = panel.getMousePosition()==null ? new Point(mouse) : panel.getMousePosition();
        panel.repaint();
      }
    });;

  public static Point mouse = new Point(0, 10);
  public static JButton button = new JButton("Run");

  public static int[] array = {4,3,7,8,2,9,1,5,6,0};

  public static void main(String[] args) {
    frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    panel.setLayout(new BorderLayout());

    button.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Button clicked!");
        }
    });

    JPanel controlPanel = new JPanel();
    controlPanel.add(button);

    panel.add(controlPanel, BorderLayout.SOUTH);

    panel.setPreferredSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT));

    frame.add(panel);
    frame.setVisible(true);

    timer.start();
  }


}
