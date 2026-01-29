package SortVisualizer;
import java.util.Arrays;

public class Sorter {
  public static int[] array;

  private int type;

  public int pointer = 0;

  public Sorter(int type) {
    this.type = type;

    switch (type) {
      default: break;
    }
  }

  public void step() {
    switch (type) {
      case 1: // Pull Sort
        if (array[pointer]>array[pointer+1]) {
          swapIndex(pointer, pointer+1);
          if (pointer>0) {pointer--;} else {pointer++;}
        } else {
          pointer++;
        }
        break;
      case 2:
          if(array[pointer]>array[pointer+1]){
            swapIndex(pointer, pointer + 1);
          }
        
        
      default: break;
    }
  }

  public boolean sortWhile() {
    switch (type) {
      case 1:
        return pointer+1<array.length;
      case 2:
        
      default: return true;
    }
  }

  public void sort2() {


    
  }

  /** 
   * Insertion Sort: Bubbling Back 
   * Sort right to left until cannot, then go left to right until can.
   */
  // public int[] sort1() {
  //   int pointer = 0;
  //   while (pointer+1<array.length) {
  //     if (array[pointer]>array[pointer+1]) {
  //       swapIndex(pointer, pointer+1);
  //       if (pointer>0) {pointer--;} else {pointer++;}
  //     } else {
  //       pointer++;
  //     }
  //   }
  //   return array;
  // }

  public static void swapIndex(int index1, int index2) {
    int temp=array[index1];
    array[index1]=array[index2];
    array[index2]=temp;
    
    Block.swap(index1,index2);
  }

  public static boolean isSorted(int[] array) {
    for (int i=0;i<array.length-1;i++) {
      if (!(array[i]<array[i+1])) {
        return false;
      }
    }
    return true;
  }
}
