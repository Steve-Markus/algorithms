package algorithms;

import java.util.Arrays;
import java.util.Random;

public class ShuffleAlgorithm {

  public static void main(String[] args) {
    int[] arr = {5, 4, 3, 2, 1, 6, 8, 7};
    Arrays.sort(arr);
    getRandom(arr);
    for (int rand : arr) {
      System.out.print(rand + " ");
    }
  }

  private static void getRandom(int[] arr) {
    Random random = new Random();
    for (int i = 0; i < arr.length; i++) {
      swap(arr, i, random.nextInt(arr.length));
    }
  }

  private static void swap(int[] arr, int first, int second) {
    int temp = arr[first];
    arr[first] = arr[second];
    arr[second] = temp;
  }
}
