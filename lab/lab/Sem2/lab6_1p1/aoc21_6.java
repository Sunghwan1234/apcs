package lab6_1p1;

import java.util.Arrays;

public class aoc21_6 {
  public static void main(String[] args) {
    int[] dat = {1,1,5,2,1,1,5,5,3,1,1,1,1,1,1,3,4,5,2,1,2,1,1,1,1,1,1,1,1,3,1,1,5,4,5,1,5,3,1,3,2,1,1,1,1,2,4,1,5,1,1,1,4,4,1,1,1,1,1,1,3,4,5,1,1,2,1,1,5,1,1,4,1,4,4,2,4,4,2,2,1,2,3,1,1,2,5,3,1,1,1,4,1,2,2,1,4,1,1,2,5,1,3,2,5,2,5,1,1,1,5,3,1,3,1,5,3,3,4,1,1,4,4,1,3,3,2,5,5,1,1,1,1,3,1,5,2,1,3,5,1,4,3,1,3,1,1,3,1,1,1,1,1,1,5,1,1,5,5,2,1,5,1,4,1,1,5,1,1,1,5,5,5,1,4,5,1,3,1,2,5,1,1,1,5,1,1,4,1,1,2,3,1,3,4,1,2,1,4,3,1,2,4,1,5,1,1,1,1,1,3,4,1,1,5,1,1,3,1,1,2,1,3,1,2,1,1,3,3,4,5,3,5,1,1,1,1,1,1,1,1,1,5,4,1,5,1,3,1,1,2,5,1,1,4,1,1,4,4,3,1,2,1,2,4,4,4,1,2,1,3,2,4,4,1,1,1,1,4,1,1,1,1,1,4,1,5,4,1,5,4,1,1,2,5,5,1,1,1,5};
    int[] dat2 = {3,4,3,1,2};
    int days = 256;
    long[] fishAtState = new long[9];

    /** Fill the stateNum with dat */
    for (int i : dat) {
      fishAtState[i]++;
    }
    System.out.println(Arrays.toString(fishAtState));

    for (int day=0; day<days; day++) {
      long[] newState = new long[9];
      for (int i=(fishAtState.length-1); i>=0; i--) {
        //System.out.println("i"+Math.floorMod(i-1,fishAtState.length)+"+= "+fishAtState[i]+" Fih in i"+i);
        newState[Math.floorMod(i-1,fishAtState.length)]+=fishAtState[i];
        if (i==0) {
          //System.out.println("Duplicate "+fishAtState[i]);
          newState[6]+=fishAtState[i];
        }
        fishAtState[i]=0;
      }
      fishAtState=newState;
      System.out.println("Day "+(day+1)+": "+Arrays.toString(fishAtState));
    }

    System.out.println("Total Fih: "+getTotal(fishAtState));

  }
  public static long getTotal(long[] stateNum) {
    long total=0;
    for (long i : stateNum) {
      total+=i;
    }
    return total; 
  }
}
