package SortVisualizer;
import java.util.Arrays;

public class Sorter {
  public static void main(String[] args) {
    int[] array = {48,36,34,33,31,29,22,7,6,-18,-47,-49};
    int[] newArray = sort1(array);
    System.out.println(Arrays.toString(newArray));
    System.out.println(isSorted(newArray));
  }

  /** 
   * Insertion Sort: Bubbling Back 
   * Sort right to left until cannot, then go left to right until can.
   */
  public static int[] sort1(int[] array) {
    int pointer = 0;
    while (pointer+1<array.length) {
      if (array[pointer]>array[pointer+1]) {
        int temp=array[pointer];
        array[pointer]=array[pointer+1];
        array[pointer+1]=temp;
        if (pointer>0) {pointer--;} else {pointer++;}
      } else {
        pointer++;
      }
    }
    return array;
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
