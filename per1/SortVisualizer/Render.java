

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.ArrayList;

public class Render {
  public static int[] array; // = {4,3,7,8,2,9,1,5,6,0};
  public static int items = 75;
  public static int MARGIN = items>75?0:5;
  public static int FRAME_WIDTH = items>=75?1875:(20+MARGIN)*items, FRAME_HEIGHT = 1000;
  public static int PANEL_HEIGHT = FRAME_HEIGHT-100;

  public static Timer timer = new Timer(500, new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
      animateTick();
    }
  });

  /** Delay in ms */
  public static int delay = 500;
  public static int ticks = -1;
  private static Sort sort;
  private static String sortType = "Gnome";

  public static Point mouse = new Point(0, 10);

  public static void main(String[] args) {
    final JFrame launcher = new JFrame("Launcher");
    final JPanel launcherPanel = new JPanel();
    final JSpinner launcherItemSpinner = new JSpinner(new SpinnerNumberModel(75, 2, 200, 1));
      launcherItemSpinner.addChangeListener(new ChangeListener() {
        @Override
        public void stateChanged(ChangeEvent e) {
            items = (int) launcherItemSpinner.getValue();
        }
      });
    final JButton launchButton = new JButton("Launch");
      launchButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          launch();
        }
      });

    launcherPanel.add(launcherItemSpinner);
    launcherPanel.add(launchButton);
    launcherPanel.setPreferredSize(new Dimension(100,100));
    launcher.add(launcherPanel);

    launcher.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    launcher.pack();
    launcher.setVisible(true);
  }
  private static void launch() {
    MARGIN = items>75?0:5;
    FRAME_WIDTH = items>=75?1875:(20+MARGIN)*items; FRAME_HEIGHT = 1000;
    PANEL_HEIGHT = FRAME_HEIGHT-100;

    final JFrame frame = new JFrame("JFrame");
    final JPanel panel = new JPanel() {
      @Override
      public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.LIGHT_GRAY); g.fillRect(0, 0, FRAME_WIDTH, FRAME_HEIGHT);
        
        if (mouse!=null) {
          g.setColor(Color.black);
          g.drawRect(mouse.x, mouse.y, 10, 10);
        }

        for (Block b:Block.blockArray) {
          b.paint(g);
        }

        if (sort!=null && ticks>-1) {
          for (int i=0;i<getCVArray().length;i++) {
            g.setColor(Color.getHSBColor((float)i/getCVArray().length, 1, 1));
            g.drawString(sort.getTypes()[i], Block.getXAt((int)getCVArray()[i]), FRAME_HEIGHT-80);
          }
        }

      }
    };

    final Timer ticker = new Timer(1, new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        mouse = panel.getMousePosition()==null ? mouse : panel.getMousePosition();
        panel.repaint();
      }
    });;

    frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
    panel.setLayout(new BorderLayout());

    final JComboBox<String> chooseSort = new JComboBox<String>(Sort.sortTypes);
      chooseSort.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            sortType = (String)chooseSort.getSelectedItem();
        }
      });
    final JButton randomizeButton = new JButton("Randomize");
    randomizeButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          randomizeArray();
          Block.setGoalX(array);
        }
    });
    final JButton runButton = new JButton("Run");
    runButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Button clicked!");
            startAnimation();
        }
    });
    final JButton simulateButton = new JButton("Simulate 100");
    simulateButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Button clicked!");
            int total = 0;
            for (int i=0;i<100;i++) {
              randomizeArray();
              sort = new Sort(array, sortType);
              total+=sort.getLogLength();
            }
            total/=100;
            System.out.println("Average: "+total+" Steps");
        }
    });
    final JSlider slider = new JSlider(0, 1000);
    slider.addChangeListener(new ChangeListener() {
      @Override
      public void stateChanged(ChangeEvent e) {
        timer.setDelay(slider.getValue());
        if (ticks>-1) {
          timer.restart();
        } else {
          timer.setInitialDelay(slider.getValue());
        }
      }
    });
    final JPanel controlPanel = new JPanel();
    controlPanel.add(chooseSort);
    controlPanel.add(randomizeButton);
    controlPanel.add(runButton);
    controlPanel.add(slider);
    controlPanel.add(simulateButton);
    // Init Finished //

    randomizeArray();
    Block.blockArray = new Block[items];
    for (int i=0;i<array.length;i++) {
      Block.blockArray[i] = new Block(i,array[i]);
    }

    panel.add(controlPanel, BorderLayout.SOUTH);
    panel.setPreferredSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT));
    frame.add(panel);
    frame.setVisible(true);
    ticker.start();
  }

  public static void randomizeArray() {
    array = new int[items];
    ArrayList<Integer> listOfNumbers = new ArrayList<Integer>();
    for (int i=0;i<items;i++) {
      listOfNumbers.add(i);
    }
    for(int i=0;i<items;i++) {
      int randIndex = (int)(Math.random()*listOfNumbers.size());
      array[i]=listOfNumbers.remove(randIndex);
    }
  }

  public static void startAnimation() {
    sort = new Sort(array, sortType);
    //System.out.println(sort);
    ticks = 0;
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
