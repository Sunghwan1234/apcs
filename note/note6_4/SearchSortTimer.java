package note.note6_4;

import java.util.Random;
import java.util.Scanner;
import java.text.NumberFormat;

/**
 * SearchSortTimer randomly fills three equal arrays (using the same seed), sorts them
 * using Bubble Sort, Selection Sort, and Insertion Sort, and reports the time lapsed for 
 * each sort.  The class also searches for the first and last values using Linear Search,
 * and the last value using Binary search, and reports the time lapsed for each search.
 * 
 * @author Mr. Dirks
 */
public class SearchSortTimer {
  public static void main(String[] args) {
    System.out.println("This program randomly fills, and then sorts, an array using");
    System.out.println("Bubble Sort, Selection Sort, and Insertion Sort.  The program");
    System.out.println("times each sort in seconds.  Enter the number of values you");
    System.out.print("would like to sort: ");

    Scanner userInput = new Scanner(System.in);
    int length = userInput.nextInt();
    userInput.close();
    int[] bubbleNums = new int[length];

    /*
     * The Generator class is another way to generate a random number. Random
     * numbers are not actually random. Random numbers usually use a seed as a
     * starting point. Two random numbers that start with the same seed will be
     * the same number. This class uses a random seed to populate three large
     * arrays that are random. Each time the program is run, it will use a 
     * different seed, and therefore, different random numbers. But during a 
     * given run of the program, each array will be filled using the same seed,
     * and will therefore be the same.
     */

    // long is another primitive type
    long seed = (long) (Math.random() * 1000000 - 500000);
    Random generator = new Random();
    generator.setSeed(seed);
    for (int i = 0; i < bubbleNums.length; i++) {
      bubbleNums[i] = generator.nextInt();
    }
    System.out.println("\nBubble sort numbers populated");

    generator.setSeed(seed);
    int[] selectionNums = new int[length];
    for (int i = 0; i < selectionNums.length; i++) {
      selectionNums[i] = generator.nextInt();
    }
    System.out.println("Selection sort numbers populated");

    generator.setSeed(seed);
    int[] insertionNums = new int[length];
    for (int i = 0; i < insertionNums.length; i++) {
      insertionNums[i] = generator.nextInt();
    }
    System.out.println("Insertion sort numbers populated\n");

    NumberFormat addCommas = NumberFormat.getInstance();
    addCommas.setGroupingUsed(true);

    long start = System.nanoTime();
    bubbleSort(bubbleNums);
    long end = System.nanoTime();
    System.out.print("   Bubble Sort [O(n^2)] time: " + addCommas.format(end - start) + " nanoseconds ");
    System.out.println("(≈ " + addCommas.format((end - start) / 1000000) + " milliseconds)");
    
    start = System.nanoTime();
    selectionSort(selectionNums);
    end = System.nanoTime();
    System.out.print("Selection Sort [O(n^2)] time: " + addCommas.format(end - start) + " nanoseconds ");
    System.out.println("(≈ " + addCommas.format((end - start) / 1000000) + " milliseconds)");
    
    start = System.nanoTime();
    insertionSort(insertionNums);
    end = System.nanoTime();
    System.out.print("Insertion Sort [O(n^2)] time: " + addCommas.format(end - start) + " nanoseconds ");
    System.out.println("(≈ " + addCommas.format((end - start) / 1000000) + " milliseconds)");
    
    int smallestInt = insertionNums[0];
    start = System.nanoTime();
    int smallestIndex = linearSearch(insertionNums, smallestInt);
    end = System.nanoTime();
    System.out.print("\nSmallest (first) number found at index " + smallestIndex);
    System.out.print(" by Linear Search [O(n)] in " + addCommas.format(end - start) + " nanoseconds ");
    System.out.println("(≈ " + addCommas.format((end - start) / 1000000) + " milliseconds)");

    int largestInt = insertionNums[insertionNums.length - 1];
    start = System.nanoTime();
    int largestIndex = linearSearch(insertionNums, largestInt);
    end = System.nanoTime();
    System.out.print("Largest (last) number found at index " + largestIndex);
    System.out.print(" by Linear Search [O(n)] in " + addCommas.format(end - start) + " nanoseconds ");
    System.out.println("(≈ " + addCommas.format((end - start) / 1000000) + " milliseconds)");
    
    start = System.nanoTime();
    largestIndex = binarySearch(insertionNums, largestInt);
    end = System.nanoTime();
    System.out.print("\nLargest (last) number found at index " + largestIndex);
    System.out.print(" by Binary Search [O(log n)] in " + addCommas.format(end - start) + " nanoseconds ");
    System.out.println("(≈ " + addCommas.format((end - start) / 1000000) + " milliseconds)\n");
  }

  private static void bubbleSort(int[] numbers) {
    for (int i = numbers.length - 1; i >= 0; i--) {
      for (int j = 0; j < i; j++) {
        if (numbers[j] > numbers[j + 1]) {
          int temp = numbers[j];
          numbers[j] = numbers[j + 1];
          numbers[j + 1] = temp;
        }
      }
    }
  }

  private static void selectionSort(int[] numbers) {
    int minIndex = -1;
    int temp = -1;

    for (int index = 0; index < numbers.length - 1; index++) {
      minIndex = index;
      for (int scan = index + 1; scan < numbers.length; scan++) {
        if (numbers[scan] < numbers[minIndex]) {
          minIndex = scan;
        }
      }

      // swaps the values
      temp = numbers[minIndex];
      numbers[minIndex] = numbers[index];
      numbers[index] = temp;
    }
  }

  private static void insertionSort(int[] numbers) {
    for (int index = 1; index < numbers.length; index++) {
      int key = numbers[index];
      int position = index;

      // shifts larger values to the right
      while (position > 0 && numbers[position - 1] > key) {
        numbers[position] = numbers[position - 1];
        position--;
      }
      numbers[position] = key;
    }
  }

  private static int linearSearch(int[] numbers, int target) {
    for (int i = 0; i < numbers.length; i++) {
      if (numbers[i] == target) {
        return i;
      }
    }
    return -1;
  }

  private static int binarySearch(int[] numbers, int target) {
    int lowIndex = 0;
    int highIndex = numbers.length - 1;
    int midIndex = (highIndex + lowIndex) / 2;
    while (numbers[midIndex] != target && lowIndex <= highIndex) {
      if (target < numbers[midIndex]) {
        highIndex = midIndex - 1;
      } else {
        lowIndex = midIndex + 1;
      }
      midIndex = (highIndex + lowIndex) / 2;
    }

    if (numbers[midIndex] == target) {
      return midIndex;
    } else {
      return -1;
    }

  }
}
