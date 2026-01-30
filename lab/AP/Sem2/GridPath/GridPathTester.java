package lab.AP.Sem2.GridPath;

public class GridPathTester {
  public static void main(String[] args) {
    System.out.println("Part (a)");
    int[][] gridA = {{12, 3, 4, 13,  5},
                    {11, 21, 2, 14, 16},
                    {7, 8, 9, 15, 0},
                    {10, 17, 20, 19, 1},
                    {18, 22, 30, 25, 6}};

    GridPath partA = new GridPath(gridA);
    Location nextLocation = partA.getNextLoc(0, 0);
    System.out.print("row 0, col 0 -> next: row " + nextLocation.getRow());
    System.out.println(", col " + nextLocation.getCol());
    nextLocation = partA.getNextLoc(1, 3);
    System.out.print("row 1, col 3 -> next: row " + nextLocation.getRow());
    System.out.println(", col " + nextLocation.getCol());
    nextLocation = partA.getNextLoc(2, 4);
    System.out.print("row 2, col 4 -> next: row " + nextLocation.getRow());
    System.out.println(", col " + nextLocation.getCol());
    nextLocation = partA.getNextLoc(4, 3);
    System.out.print("row 4, col 3 -> next: row " + nextLocation.getRow());
    System.out.println(", col " + nextLocation.getCol());

    int[][] gridB = {{12, 30, 40, 25, 5},
                     {11, 3, 22, 15, 43},
                     {7, 2, 9, 4, 0},
                     {8, 33, 18, 6, 1}};
    GridPath partB = new GridPath(gridB);
    System.out.println("\nPart (b)");
    System.out.println("Sum path from row 1, column 1: " + partB.sumPath(1, 1));
  }
}