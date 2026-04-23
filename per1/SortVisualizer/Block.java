

import java.awt.Graphics;
import java.awt.Color;

public class Block {
  public static Block[] blockArray = new Block[Render.array.length];

  private final int width, height;
  public int value, index;
  private double x, y;
  private double goalX;
  
  public Block(int index, int value) {
    this.index=index;
    this.value=value;
    this.width=20;
    this.height=value*(Render.PANEL_HEIGHT)/Render.items+5;

    this.x = getXAt(index);
    this.goalX = x;
    this.y = Render.PANEL_HEIGHT-height;
  }

  // public static void swap(int index1, int index2) {
  //   Block temp=blockArray[index1];
  //   blockArray[index1]=blockArray[index2];
  //   blockArray[index2]=temp;

  //   int tempIndex = blockArray[index1].index;
  //   blockArray[index1].animateTo(blockArray[index2].index);
  //   blockArray[index2].animateTo(tempIndex);
  // }
  // public static void push(int index, int toIndex) {
  //   Block value = blockArray[index];
  //   int i=index;
  //   boolean c=true;
  //   while (c) {
  //     blockArray[i]=blockArray[i+index>toIndex?1:-1];
  //     blockArray[i].animateTo(i);
      
  //     i+=index>toIndex?1:-1;
  //     c=index>toIndex? i<toIndex : i>toIndex;
  //   }
  //   blockArray[toIndex]=value;
  //   blockArray[toIndex].animateTo(toIndex);
  // }
  // private void animateTo(int newIndex) {
  //   this.index = newIndex;
  //   this.goalX = getXAt(index);
  // }

  public static int getXAt(int index) {
    return (index)*(Render.FRAME_WIDTH)/(Block.blockArray.length+1);
    //return (index-(Block.blockArray.length-1)/2)
  }

  public void paint(Graphics g) {
    Color color = Color.WHITE;
    // Follow the value in the array around
    if (Render.ticks>-1) {
      setGoalX(Render.getCTArray());
      final Object[] varArray = Render.getCVArray();
      for (int i=0;i<varArray.length;i++) {
        if (this.index == (int)varArray[i]) {
          color = Color.getHSBColor((float) i/varArray.length, (float) 0.5, 1);
        }
      }
    }

    x += (goalX-x)/5;

    g.setColor(color);
    g.fillRect((int)x, (int)y, width, height);
    g.setColor(Color.GRAY);
    if (Render.MARGIN!=0) {
      g.drawRect((int)x, (int)y, width, height);
    }
    g.drawString(value+"", (int)x+7, (int)y+height+15);
  }
  public static void setGoalX(int[] array) {
    for (Block b : blockArray) {
      for (int i=0;i<array.length;i++) {
        if (array[i]==b.value) {
          b.index = i;
          b.goalX = getXAt(i);
          break;
        }
      }
    }
  }

  public String toString() {
    return height+"";
  }
}
