package SortVisualizer;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main implements ActionListener {
  public static JPanel panel;
  public static void main(String[] args) {
    JFrame frame = new JFrame("JFrame");
    frame.setSize(500,500);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    panel = new JPanel();
    

    frame.add(panel);

    frame.setVisible(true);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    panel.repaint();
  }


  
}
