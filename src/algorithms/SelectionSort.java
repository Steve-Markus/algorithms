package algorithms;

public class SelectionSort {

  public static void main(String[] args) {
    int[] arr = {5, 4, 3, 2, 1, 6, 8, 7};
    sort(arr);

    for (int i : arr) {
      System.out.print(i + " ");
    }
  }

  private static void sort(int[] arr) {
    // iterate over elements
    for (int i = 0; i < arr.length; i++) {
      int index = i;
      for (int j = i + 1; j < arr.length; j++) {
        // find min element
        if (arr[j] < arr[index]) {
          index = j;
        }
      }
      // swap elements
      swap(arr, i, index);
    }
  }

  private static void swap(int[] arr, int first, int second) {
    int temp = arr[first];
    arr[first] = arr[second];
    arr[second] = temp;
  }
}
