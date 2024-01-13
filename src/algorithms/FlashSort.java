package algorithms;

import java.util.Arrays;

public class FlashSort {

  public static void main(String[] args) {
    // input
    int[] array = {40, 20, 10, 50, 30, 60, 50};
    printArr(array, "Original array");
    flashsort(array);
    printArr(array, "Sorted array");
  }

  private static void flashsort(int[] arr) {
    int n = arr.length;
    if (n == 0) {
      return;
    }

    //find the minimum and maximum values of elements in array
    int min = arr[0];
    int max = arr[0];
    for (int i = 0; i < n; i++) {
      if (arr[i] < min) {
        min = arr[i];
      }
      if (arr[i] > max) {
        max = arr[i];
      }
    }
    // initialize the 'buckets' array
    int[] buckets = new int[n];
    Arrays.fill(buckets, 0);

    // calculate the class interval
    double c = 0.8 * (n - 1) / (max - min);

    // count the number of elements in each bucket
    for (int i = 0; i < n; i++) {
      int index = (int) (c * (arr[i] - min));
      buckets[index]++;
    }
    // modify the bucket to represent the starting index of each
    for (int i = 1; i < n; i++) {
      buckets[i] += buckets[i - 1];
    }

    // create a copy array to preserve the original array
    int[] copy = Arrays.copyOf(arr, n);

    // fill the final sorted array
    for (int i = n - 1; i >= 0; i--) {
      int index = (int) (c * (copy[i] - min));
      arr[--buckets[index]] = copy[i];
    }

    int a = arr[0];
    int b = arr[1];
    arr[0] = b;
    arr[1] = a;
  }

  private static void printArr(int[] array, String message) {
    System.out.println(System.lineSeparator() + message);
    for (var a : array) {
      System.out.print(a + " ");
    }
    System.out.println();
  }
}
