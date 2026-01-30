
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Sort {
  private int[] array = {4,3,7,8,2,9,1,5,6,0};

  private String[] logVarTypes;
  private ArrayList<int[]> logArray = new ArrayList<>();
  private ArrayList<Object[]> log = new ArrayList<>();

  public Sort(int[] array, int type) {
    this.array = array;

    switch (type) {
      case 2: sort2(); break;
      case 1: sort1(); break;
      default: sort1(); break;
    }
  }

  /** Teleporting Insertion Sort */
  public void sort2() {
    setLogVarTypes(new String[] {"p", "p+1", "s"});

    int pointer = 0;
    int save = -1;
    while (pointer+1<array.length) {
      if (array[pointer]>array[pointer+1]) {
        if (save==-1) {save=pointer;}
        swapIndices(pointer, pointer+1);
        if (pointer>0) {pointer--;} else {
          if (save>-1) {
            pointer = save;
            save = -1;
          } else {
            pointer++;
          }}
      } else {
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
   * Insertion Sort: Bubbling Back (Pull Sort)
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
