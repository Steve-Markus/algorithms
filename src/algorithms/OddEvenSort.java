package algorithms;

public class OddEvenSort {

  public static void main(String[] args) {
    int[] array = {40, 20, 10, 50, 60, 30};
    printArr(array, "Original array");
    oddEvenSort(array);
    printArr(array, "Sorted array");
  }

  private static void oddEvenSort(int[] arr) {
    int n = arr.length;
    boolean isSorted = false;

    while (!isSorted) {
      isSorted = true;

      // perform odd-even comparisons
      for (int i = 1; i <= n - 2; i += 2) {
        // swap arr[i] and arr[i + 1]
        if (arr[i] > arr[i + 1]) {
          int temp = arr[i];
          arr[i] = arr[i + 1];
          arr[i + 1] = temp;
          isSorted = false;
        }
      }

      // perform even-odd comparisons
      for (int i = 0; i <= n - 2; i += 2) {
        // swap arr[i] and arr[i + 1]
        if (arr[i] > arr[i + 1]) {
          int temp = arr[i];
          arr[i] = arr[i + 1];
          arr[i + 1] = temp;
          isSorted = false;
        }
      }
    }
  }

  private static void printArr(int[] array, String message) {
    System.out.println(System.lineSeparator() + message);
    for (var a : array) {
      System.out.print(a + " ");
    }
    System.out.println();
  }
}
