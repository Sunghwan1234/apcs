
import java.util.ArrayList;
import java.util.Arrays;

public class Sort {
  private int[] array = {4,3,7,8,2,9,1,5,6,0};

  private String[] logVarTypes;
  private ArrayList<int[]> logArray = new ArrayList<>();
  private ArrayList<Object[]> log = new ArrayList<>();

  public static final String[] sortTypes = {"Gnome", "Insertion"};

  public Sort(int[] array, String type) {
    this.array = array;


    switch (type) {
      case "sort4": sort4(); break;
      //case "sort3": sort3(); break;
      case "Insertion": sort2(); break;
      case "Gnome": sort1(); break;
      default: sort1(); break;
    }
  }

  public void sort4() {
    setLogVarTypes(new String[] {"i","hi","li"});

    int highest=array[0], lowest=array[0];
    int highestIndex=0, lowestIndex=0;
    for (int i=0;i<array.length;i++) {
      if (array[i]>highest) {highestIndex=i;}
      if (array[i]<lowest) {lowestIndex=i;}

      logVars(array, new Object[] {i, highestIndex, lowestIndex});
    }
    swapIndices(highestIndex, lowestIndex);

    
  }

  /** Front-Back Choosing Teleport Bubble Sort */
  // public void sort3() {
  //   setLogVarTypes(new String[] {"i", "i-1", "i2", "m"});

  //   int[] sums = new int[array.length];
  //   for (int i=0;i<array.length;i++) {
  //     sums[i] = (i==0?0:sums[i-1])+array[i];
  //     logVars(array, new Object[] {i, -1, -1, -1});
  //   }

  //   int index = 1;
  //   int index2 = -1;
  //   int middle = -1;
  //   while (index<array.length) {
  //     if (array[index-1]>array[index]) { // i-1 > i (not in order)
  //       middle = sums[index]/index;
  //       if (array[index] < middle) {
  //         index2 = 1;
  //       }
  //       while (true) {
  //         if (array[index] > middle) { // MAIN LOGIC: is this < average?
  //           index=0;
  //         }
  //         swapIndices(index, index+1);

  //         index--;
  //       }
  //     }
  //     if (index<1) { // i == 0 (Start going backwards)
  //       if (save>-1) { // Go to savepoint if exists
  //         index = save;
  //         save = -1;
  //       } else {
  //         index++;
  //       }
  //     }

  //     logVars(array, new Object[] {index, index+1, save, middle});
  //   }
  // }

  /** Insertion Sort */
  public void sort2() {
    setLogVarTypes(new String[] {"p", "p+1", "s"});

    int pointer = 0;
    int save = -1;
    logVars(array, new Object[] {pointer, pointer+1, save});
    while (pointer+1<array.length) {
      if (array[pointer]>array[pointer+1]) { // Not in order?
        if (save==-1) {save=pointer+1;} // Set save
        swapIndices(pointer, pointer+1);

        if (pointer>0) {
          pointer--;
        }
      }
      if (!(array[pointer]>array[pointer+1]) || pointer<0) {
        if (save>-1) {
          pointer = save;
          save = -1;
        } else {
          pointer++;
        }
      }
      logVars(array, new Object[] {pointer, pointer+1, save});
    }
  }

  

  /** 
   * Gnome Sort (Stupid Sort)
   * Sort right to left until cannot, then go left to right until can.
   */
  public void sort1() {
    setLogVarTypes(new String[] {"p", "p+1"});

    int pointer = 0;
    while (pointer+1<array.length) {
      if (array[pointer]>array[pointer+1]) {
        swapIndices(pointer, pointer+1);
        if (pointer>0) {pointer--;} else {pointer++;}
      } else {
        pointer++;
      }

      logVars(array, new Object[] {pointer, pointer+1});
    }
  }

  public void swapIndices(int index1, int index2) {
    int temp=array[index1];
    array[index1]=array[index2];
    array[index2]=temp;
  }

  /** Push O(n) */
  private void push(int index, int toIndex) {
    int value = array[index];
    int i=index;
    boolean c=true;
    while (c) {
      array[i]=array[i+index>toIndex?1:-1];
      i+=index>toIndex?1:-1;
      c=index>toIndex? i<toIndex : i>toIndex;
    }
    array[toIndex]=value;
  }

  private void setLogVarTypes(String[] types) {
    logVarTypes = types;
  }
  private void logVars(int[] array, Object[] vars) {
    logArray.add(Arrays.copyOf(array, array.length));
    log.add(vars);
  }

  public int getLogLength() {return log.size();}

  public int[] getArray(int tick) {
    return logArray.get(tick);
  }
  public String[] getTypes() {
    return logVarTypes;
  }
  public Object[] getVars(int tick) {
    return log.get(tick);
  }

  public static boolean isSorted(int[] array) {
    for (int i=0;i<array.length-1;i++) {
      if (!(array[i]<array[i+1])) {
        return false;
      }
    }
    return true;
  }

  @Override
  public String toString() {
      String out="Sort Array\n";
      for (String s : logVarTypes) {
        out+=s+"\t";
      }
      out+="\n";
      // for (Object[] o : log) {
      //   for (Object i : o) {
      //     out+=i+"\t";
      //   }
      //   out+="\n";
      // }
      for (int li=0;li<logArray.size();li++) {
        for (int i : getArray(li)) {
          out+=i+"\t";
        }
        out+="\n";
      }
      return out;
  }
}
