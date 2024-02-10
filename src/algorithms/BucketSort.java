package algorithms;

import java.util.Arrays;

public class BucketSort {

  public static void main(String[] args) {
    // read input
    int[] arr = {40, 20, 10, 50, 30, 60, 50};
    int max = maxValue(arr);

    sort(arr, max);
    System.out.println(Arrays.toString(arr));
  }

  private static void sort(int[] arr, int max) {
    // buckets
    int[] buckets = new int[max + 1];
    for (int a : arr) {
      // fill buckets
      buckets[a]++;
    }

    int pos = 0;
    for (int i = 0; i < buckets.length; i++) {
      for (int j = 0; j < buckets[i]; j++) {
        // sort elements
        arr[pos++] = i;
      }
    }
  }

  private static int maxValue(int[] arr) {
    int m = 0;
    for (int n : arr) {
      m = Math.max(m, n);
    }
    return m;
  }
}
