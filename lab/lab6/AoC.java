package lab6;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class AoC {
  public static void main(String[] args) throws FileNotFoundException {
    File textFile = new File("lab/lab6/input.txt");
    Scanner userInput = new Scanner(textFile);
    int[] depths = new int[2000];
    for (int i = 0; i < depths.length; i++) {
      depths[i] = userInput.nextInt();
    }

    int c=0;
    int j=0;
    
    for (int i=1;i<depths.length;i++) {
      if (i==1999) {System.out.println("last one: "+depths[i]);}
      if (depths[i-1]<depths[i]) {c++;}
      j++;
    }
    System.out.print("Out of total "+j+" Inc: "+c);
  }
}

