package SortVisualizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Sorter {
  public static int[] array = {4,3,7,8,2,9,1,5,6,0};

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
    int min=array[0], max=array[0];
    int i=1;
    while (i<array.length) {
      boolean ii=true;
      if (array[i]<min) { // New Min?
        min=array[i];
        push(i, 0);
        ii=false;
      }
      if (array[i]>max) {
        max=array[i];
        push(i, array.length-1);
        ii=false;
      }
      if (array[i-1]>array[i]) {
        swapIndex(i-1, i);
        ii=false;
      }
      if (ii) {i++;}
    }
    
    
  }

  public void log(ArrayList<Object> vars) {

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
  public static void push(int index, int toIndex) {
    int value = array[index];
    int i=index;
    boolean c=true;
    while (c) {
      array[i]=array[i+index>toIndex?1:-1];
      i+=index>toIndex?1:-1;
      c=index>toIndex? i<toIndex : i>toIndex;
    }
    array[toIndex]=value;

    Block.push(index, toIndex);
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
