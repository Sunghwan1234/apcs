public class BinarySearch {
  public static void main(String[] args) {
    System.out.println(binarySearchA(new int[] {3,5,6,8,9}, 7));
    int[] array = new int[256]; 

    // for (int i=0;i<array.length;i++) {
    //   array[i]=i;
    // }
    
    // for (int i : array) {
    //   if (binarySearchB(array, i)<0) {
    //     System.err.println(">>> Cound not find "+i);
    //   }
    // }
    //System.out.println(">> Found At "+binarySearch(array,-1));
  }
  public static int binarySearchA(int[] array, int target) {
    int lowIndex = 0;
    int highIndex = array.length - 1;
    int midIndex = (highIndex + lowIndex) / 2;
    while (array[midIndex] != target && lowIndex <= highIndex) {
      System.out.println(lowIndex+", "+midIndex+", "+highIndex);
      if (target < array[midIndex]) {
        highIndex = midIndex - 1;
      } else {
        lowIndex = midIndex + 1;
      }
      midIndex = (highIndex + lowIndex) / 2;
      System.out.println(lowIndex+", "+midIndex+", "+highIndex);
    }

    if (array[midIndex] == target) {
      return midIndex;
    } else {
      return -1;
    }
  }

  public static int binarySearchAb(int[] array, int target) {
    int lowIndex = 0, highIndex = array.length-1;
    while (true) {
      int midIndex = (highIndex + lowIndex) / 2;
      if (target < array[midIndex]) {
        highIndex = midIndex - 1;
      } else {
        lowIndex = midIndex + 1;
      }

      if (array[midIndex] == target) {
        return midIndex;
      } else if (highIndex<lowIndex) {
        return -1;
      }
    }
  }

  public static int binarySearchB(int[] array, int target) {
    System.out.println("\n>>> Searching "+target);
    int index=array.length/2;
    int lowBound=0,highBound=array.length-1;

    int rep=2;
    while (array[index]!=target) {
      System.out.print(index+">");
      if (lowBound==highBound) {return -1;}
      
      int half = (int) Math.ceil((array.length-1)/(Math.pow(2,rep)));
      if (array[index]>target) {
        index-=half;
      } else if(array[index]<target) {
        index+=half;
      } else {
        return -1;
      }
      if (index>lowBound) {lowBound=index;}
      if (index>highBound) {highBound=index;}
      //index=Math.clamp(index,0,array.length-1);
      rep++;
      System.out.print(index+"\t");
      if (index>=array.length||index<0) {return -1;}
    }
    return index;
  }
}
