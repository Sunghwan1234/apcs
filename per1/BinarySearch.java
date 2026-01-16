public class BinarySearch {
  public static void main(String[] args) {
    int[] array = new int[256]; 

    for (int i=0;i<array.length;i++) {
      array[i]=i;
    }
    
    for (int i : array) {
      if (binarySearch(array, i)<0) {
        System.err.println(">>> Cound not find "+i);
      }
    }
    //System.out.println(">> Found At "+binarySearch(array,-1));
  }

  public static int binarySearch(int[] array, int target) {
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
