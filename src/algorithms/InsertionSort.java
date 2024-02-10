package algorithms;

import java.util.Arrays;

public class InsertionSort {

  public static void main(String[] args) {
    // read input
    int[] values = {30, 10, 40, 20, 60, 50};
    insertionSort(values);
    System.out.println(Arrays.toString(values));
  }

  private static void insertionSort(int[] arr) {
    // length of array
    int n = arr.length;
    // iterate over elements
    for (int i = 1; i < n; i++) {
      int key = arr[i];
      int a = i - 1;
      // if element is lower than key, move element one position back
      while (a >= 0 && arr[a] > key) {
        arr[a + 1] = arr[a];
        a = a - 1;
      }
      arr[a + 1] = key;
    }
  }
}
