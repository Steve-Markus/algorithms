package algorithms;

import java.util.Arrays;

public class RadixSort {

  public static void main(String[] args) {
    // read input
    int[] arr = {40, 20, 10, 50, 30, 60, 50};
    sort(arr);
    System.out.println(Arrays.toString(arr));
  }

  private static int numOfDigits(int max) {
    var digits = String.valueOf(max).toCharArray();
    return digits.length;
  }

  private static int maxValue(int[] arr) {
    int m = 0;
    for (int n : arr) {
      m = Math.max(m, n);
    }
    return m;
  }

  private static void sort(int[] arr) {
    // get max value
    int max = maxValue(arr);
    // get count of digits
    int numberOfDigits = numOfDigits(max);
    int positionOfValue = 1;
    for (int n = numberOfDigits; n >= 0; n--) {
      int radix = 10;

      int l = arr.length;
      int[] count = new int[radix];
      int[] sorted = new int[l];

      for (int number : arr) {
        int digit = (number / positionOfValue) % radix;
        count[digit]++;
      }

      for (int i = 1; i < radix; i++) {
        count[i] += count[i - 1];
      }

      // move elements
      for (int i = l - 1; i >= 0; i--) {
        int digit = (arr[i] / positionOfValue) % radix;
        sorted[count[digit] - 1] = arr[i];
        count[digit]--;
      }

      // copy elements to array
      System.arraycopy(sorted, 0, arr, 0, l);
      positionOfValue *= radix;
    }
  }
}
