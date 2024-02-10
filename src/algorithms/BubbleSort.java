package algorithms;

public class BubbleSort {

  public static void main(String[] args) {
    // read input
    int[] arr = {5, 4, 3, 2, 1, 6, 8, 7};
    sort(arr);

    for (int i : arr) {
      System.out.print(i + " ");
    }
  }

  private static void sort(int[] arr) {
    // iterate over elements outer loop
    for (int i = 0; i < arr.length; i++) {
      // iterate over elements inner loop
      for (int j = 0; j < arr.length - i - 1; j++) {
        // swap elements if needed
        if (arr[j + 1] > arr[j]) {
          // reversed order
          swap(arr, j, j + 1);
        }
      }
    }
  }

  private static void swap(int[] arr, int first, int second) {
    int temp = arr[first];
    arr[first] = arr[second];
    arr[second] = temp;
  }
}
