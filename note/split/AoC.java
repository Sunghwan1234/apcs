package note.split;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.io.File;
import java.io.FileNotFoundException;

public class AoC {
  public static void main(String[] args) throws FileNotFoundException {
    File input = new File("note/split/input.txt");
    Scanner scanner = new Scanner(input);
;
    int paper = 0;
    while (scanner.hasNext()) {
      String[] split = scanner.next().split("x");
      int[] space = new int[3];
      int[] areas = new int[space.length];
      for (int i=0;i<space.length;i++) {
        space[i]=Integer.parseInt(split[i]);
      }
      for (int i=0;i<areas.length;i++) {
        areas[i] = space[i]*space[(i+1)%3];
      }
      int surfaceArea = 2*areas[0]+2*areas[1]+2*areas[2];
      int lowestArea = Math.min(Math.min(areas[0],areas[1]),areas[2]);
      paper+=surfaceArea+lowestArea;
    }
    System.out.println(paper);
    scanner.close();
  }
}
