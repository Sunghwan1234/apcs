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

        for (Block b:Block.blockArray) {
          b.paint(g);
        }

        if (pointer!=-1) {
          g.drawString("^", Block.getXAt(pointer), FRAME_HEIGHT-50);
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

  public static int pointer = 0;

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

    panel.add(controlPanel, BorderLayout.SOUTH);
    panel.setPreferredSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT));
    frame.add(panel);
    frame.setVisible(true);
    ticker.start();
  }

  public static void startAnimation() {
    int pointer = 0;

    ticks = 0;
    timer = new Timer(1000, new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        System.out.println(">> Tick "+ticks);
        if (pointer+1<array.length) {
          ticks++;
          doOneSortStep(pointer);
        } else {
          timer.stop();
        }
      }
    });
    timer.start();
    System.out.println("Timer Started.");
  }

  public static void doOneSortStep(int pointer) {
    if (array[pointer]>array[pointer+1]) {
      // swap here
        doOneSwap(pointer, pointer+1);
        if (pointer>0) {pointer--;} else {pointer++;}
      } else {
        pointer++;
      }
  }

  public static void doOneSwap(int index1, int index2) {
    int temp=array[index1];
    array[index1]=array[index2];
    array[index2]=temp;
    
    Block.swap(index1,index2);
  }
}
