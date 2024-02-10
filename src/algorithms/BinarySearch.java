package algorithms;

public class BinarySearch {

  public static void main(String[] args) {
    int[] arr = {0, 1, 2, 3, 4, 7, 10, 40};
    int number = 10;
    int result = binarySearch(arr, 0, arr.length - 1, number);
    if (result != -1) {
      System.out.println("Result fount at index: " + result);
    } else {
      System.out.println("No result found");
    }
  }

  private static int binarySearch(int[] arr, int start, int end, int number) {
    // base condition
    if (end >= start) {
      int mid = start + (end - start) / 2;
      // found
      if (arr[mid] == number) {
        return mid;
      }
      // search in left
      if (arr[mid] > number) {
        return binarySearch(arr, start, mid - 1, number);
      }
      // search in right
      return binarySearch(arr, mid + 1, end, number);
    }

    // not found
    return -1;
  }
}
