package AP.Sem2.Data;

public class DataTester {
  public static void main(String[] args) {
    Data random1 = new Data(129, 5, 6);
    random1.repopulate();
    System.out.println(random1);
    random1.repopulate();
    System.out.println(random1);


    Data random2 = new Data(510, 9, 7);
    random2.repopulate();
    System.out.println("\n" + random2);
    random2.repopulate();
    System.out.println(random2);


    int[][] sample1 = {{10, 50, 40}, {20, 40, 20}, {30, 50, 30}};
    Data example1 = new Data(50, sample1);
    System.out.println("\n" + example1.countIncreasingCols());
    int[][] sample2 = {{10, 540, 440, 440}, {220, 450, 440, 190}};
    Data example2 = new Data(540, sample2);
    System.out.println(example2.countIncreasingCols());
  }
  
}