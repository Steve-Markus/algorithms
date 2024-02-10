package algorithms;

public class BitonicSort {

  public static void main(String[] args) {
    // input
    int[] arr = {3, 7, 4, 8, 6, 2, 1, 5};

    System.out.println("Original Array:");
    printArray(arr);
    // true for asc
    bitonicSort(arr, 0, arr.length, true);

    System.out.println("\nSorted Array:");
    printArray(arr);
  }

  private static void bitonicSort(int[] arr, int low, int count, boolean ascending) {
    if (count > 1) {
      int k = count / 2;

      // sort ascending
      bitonicSort(arr, low, k, true);
      // sort descending
      bitonicSort(arr, low + k, k, false);

      bitonicMerge(arr, low, count, ascending);
    }
  }


  // merge two bitonic sequences in ascending or descending order
  private static void bitonicMerge(int[] arr, int low, int count, boolean ascending) {
    if (count > 1) {
      int k = count / 2;

      for (int i = low; i < low + k; i++) {
        compareAndSwap(arr, i, i + k, ascending);
      }

      bitonicMerge(arr, low, k, ascending);
      bitonicMerge(arr, low + k, k, ascending);
    }
  }

  private static void compareAndSwap(int[] arr, int i, int j, boolean ascending) {
    if ((arr[i] > arr[j] && ascending) || (arr[i] < arr[j] && !ascending)) {
      // swap arr[i] and arr[j]
      int temp = arr[i];
      arr[i] = arr[j];
      arr[j] = temp;
    }
  }

  // utility method to print array
  private static void printArray(int[] arr) {
    for (var value : arr) {
      System.out.print(value + " ");
    }
    System.out.println();
  }
}
