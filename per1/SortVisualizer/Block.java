package SortVisualizer;

import java.awt.Graphics;
import java.awt.Color;

public class Block {
  public static int length=0;
  private int width = 20, height;
  public int value, index;
  private int x, y;
  private int goalX;
  
  public Block(int index, int value) {
    this.index=index;
    this.value=value;
    this.height=value*20+10;

    this.x = getXAt(index);
    this.goalX = x;
    this.y = Main.FRAME_HEIGHT-height-100;
  }

  public static void swap(Block block1, Block block2) {
    block1.animateTo(block2.index);
    block2.animateTo(block1.index);
  }

  public void animateTo(int newIndex) {
    this.index = newIndex;
    this.goalX = getXAt(index);
  }

  public int getXAt(int index) {
    return 10+index*(Main.FRAME_WIDTH-10)/Block.length;
  }

  public void paint(Graphics g) {
    x += (goalX-x)/2;

    g.setColor(Color.WHITE);
    g.fillRect(x, y, width, height);
    g.setColor(Color.GRAY);
    g.drawRect(x, y, width, height);
    g.drawString(value+"", x+7, y+height+15);
  }

  public String toString() {
    return height+"";
  }
}
