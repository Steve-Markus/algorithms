package algorithms;

import java.util.Arrays;

public class CountingSort {

  public static void main(String[] args) {
    // intput data
    int[] array = {40, 20, 10, 50, 30, 60, 50};
    printArr(array, "Original array");
    countingSort(array);
    printArr(array, "Sorted array");
  }

  private static void countingSort(int[] arr) {
    // max value
    int max = Arrays.stream(arr).max().getAsInt();
    // min value
    int min = Arrays.stream(arr).min().getAsInt();

    int range = max - min + 1;
    int[] count = new int[range];
    int[] output = new int[arr.length];

    // count the occurrences of each element
    for (var a : arr) {
      count[a - min]++;
    }

    // update count to store the position of the next occurrence
    for (int i = 1; i < range; i++) {
      count[i] += count[i - 1];
    }

    // build the output array
    for (int i = arr.length - 1; i >= 0; i--) {
      output[count[arr[i] - min] - 1] = arr[i];
      count[arr[i] - min]--;
    }

    // copy the sorted elements back to the original array
    System.arraycopy(output, 0, arr, 0, arr.length);
  }

  private static void printArr(int[] array, String message) {
    System.out.println(System.lineSeparator() + message);

    for (var a : array) {
      System.out.print(a + " ");
    }
    System.out.println();
  }
}
