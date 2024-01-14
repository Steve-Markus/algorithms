package algorithms;

public class ShellSort {

  public static void main(String[] args) {
    // read input data
    int[] array = {40, 20, 10, 50, 30, 60, 50};
    printArr(array, "Original array");
    shellSort(array);
    printArr(array, "Sorted array");
  }

  private static void shellSort(int[] arr) {
    int n = arr.length;

    // start with a large gap and reduce it
    for (int gap = n / 2; gap > 0; gap--) {
      // perform Insertion sort on the elements with the current gap
      for (int i = gap; i < n; i++) {
        // current element
        int temp = arr[i];
        int j;

        // shift elements with a gap until correct position for current is found
        for (j = i; j >= gap && arr[j - gap] > temp; j -= gap) {
          arr[j] = arr[j - gap];
        }

        // place current at its correct position
        arr[j] = temp;
      }
    }
  }

  private static void printArr(int[] arr, String message) {
    System.out.println(System.lineSeparator() + message);
    for (var a : arr) {
      System.out.print(a + " ");
    }
    System.out.println();
  }
}
