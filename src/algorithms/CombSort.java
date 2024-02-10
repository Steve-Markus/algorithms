package algorithms;

import java.util.Arrays;

public class CombSort {

  public static void main(String[] args) {
    // read input
    int[] array = {40, 20, 10, 50, 30, 60, 50};
    combSort(array);
    System.out.println("Sorted array: " + Arrays.toString(array));
  }

  private static void combSort(int[] arr) {
    int n = arr.length;

    // initialize gap
    int gap = n;

    // set the shrink factor
    double shrink = 1.3;
    boolean swapped;

    do {
      // update the gap value
      gap = (int) (gap / shrink);

      if (gap < 1) {
        gap = 1;
      }

      swapped = false;

      // perform a single pass of the comb sort
      for (int i = 0; i + gap < n; i++) {
        if (arr[i] > arr[i + gap]) {
          // swap
          int temp = arr[i];
          arr[i] = arr[i + gap];
          arr[i + gap] = temp;

          // mark that a swap occurred
          swapped = true;
        }
      }
    } while (gap > 1 || swapped);
  }
}
