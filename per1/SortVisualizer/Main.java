package SortVisualizer;

import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
  public static final int FRAME_WIDTH = 500, FRAME_HEIGHT = 500;

  public static final JFrame frame = new JFrame("JFrame");
  public static final JPanel panel = new JPanel() {
      @Override
      public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.LIGHT_GRAY); g.fillRect(0, 0, FRAME_WIDTH, FRAME_HEIGHT);
        
        g.setColor(Color.black);
        g.drawRect(mouse.x, mouse.y, 10, 10);

        for (Block b:blockArray) {
          b.paint(g);
        }
      }
    };
  public static final Timer ticker = new Timer(1, new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        mouse = panel.getMousePosition()==null ? new Point(mouse) : panel.getMousePosition();
        panel.repaint();
      }
    });;

  public static Timer timer;
  public static int ticks = 0;

  public static Point mouse = new Point(0, 10);
  public static final JButton button = new JButton("Run");

  public static int[] array = {4,3,7,8,2,9,1,5,6,0};
  public static Block[] blockArray = new Block[array.length];

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
    // Init Finished //

    Block.length = array.length;
    for (int i=0;i<array.length;i++) {
      blockArray[i] = new Block(i,array[i]);
    }

    panel.add(controlPanel, BorderLayout.SOUTH);
    panel.setPreferredSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT));
    frame.add(panel);
    frame.setVisible(true);
    ticker.start();
  }

  public static void startAnimation() {
    ticks = 0;
    timer = new Timer(1000, new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        ticks++;

        
      }
    });
  }

  public static void doOneSortStep(int pointer) {
    if (array[pointer]>array[pointer+1]) {
      // swap here
        
        if (pointer>0) {pointer--;} else {pointer++;}
      } else {
        pointer++;
      }
  }

  public static void doOneSwap(int index1, int index2) {
    int temp=array[index1];
    array[index1]=array[index2];
    array[index2]=temp;
    
  }
}
