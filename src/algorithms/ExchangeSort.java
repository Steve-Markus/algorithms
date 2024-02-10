package algorithms;

public class ExchangeSort {

  public static void main(String[] args) {
    int[] array = {40, 20, 10, 50, 30, 60, 50};
    printArr(array, "Original array");
    exchangeSort(array);
    printArr(array, "Sorted array");
  }

  private static void exchangeSort(int[] arr) {
    int n = arr.length;

    for (int i = 0; i < n - 1; i++) {
      for (int j = 0; j < n - 1 - i; j++) {
        // swap if the element found is greater than the next element
        if (arr[j] > arr[j + 1]) {
          // swap arr[j] with arr[j + 1]
          int temp = arr[j];
          arr[j] = arr[j + 1];
          arr[j + 1] = temp;
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
