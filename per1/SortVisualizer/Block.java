package SortVisualizer;

import java.awt.Graphics;
import java.awt.Color;

public class Block {
  public static Block[] blockArray = new Block[Main.array.length];

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

  public static void swap(int index1, int index2) {
    Block temp=blockArray[index1];
    blockArray[index1]=blockArray[index2];
    blockArray[index2]=temp;

    int tempIndex = blockArray[index1].index;
    blockArray[index1].animateTo(blockArray[index2].index);
    blockArray[index2].animateTo(tempIndex);
  }

  private void animateTo(int newIndex) {
    this.index = newIndex;
    this.goalX = getXAt(index);
  }

  public static int getXAt(int index) {
    return 10+index*(Main.FRAME_WIDTH-10)/Block.blockArray.length;
  }

  public void paint(Graphics g) {
    x += (goalX-x)/10;

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
