package algorithms;

public class TernarySearchArray {

  public static void main(String[] args) {
    int[] sortedArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    int target = 6;
    int index = ternarySearch(sortedArray, target);

    if (index != -1) {
      System.out.println("Element " + target + " found at index " + index);
    } else {
      System.out.println("Element " + target + " not found in the array");
    }
  }

  private static int ternarySearch(int[] array, int target) {
    int left = 0;
    int right = array.length - 1;

    while (left <= right) {
      int mid1 = left + (right - left) / 3;
      int mid2 = right - (right - left) / 3;

      if (array[mid1] == target) {
        return mid1;
      }

      if (array[mid2] == target) {
        return mid2;
      }

      if (target < array[mid1]) {
        right = mid1 - 1;
      } else if (target > array[mid2]) {
        left = mid2 + 1;
      } else {
        left = mid1 + 1;
        right = mid2 - 1;
      }
    }

    return -1; // Element not found
  }
}
