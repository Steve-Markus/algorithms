package algorithms;

import java.util.Arrays;

public class CocktailSort {

  public static void main(String[] args) {
    CocktailSort cocktail = new CocktailSort();
    int[] nums = {20, 30, 10, 50, 60, 40};

    cocktail.sort(nums);
    System.out.println(Arrays.toString(nums));
  }

  private static void sort(int[] array) {
    boolean swapped = true;
    int start = 0;
    int end = array.length;

    while (swapped) {
      swapped = false;
      for (int i = start; i < end - 1; ++i) {
        if (array[i] > array[i + 1]) {
          int temp = array[i];
          array[i] = array[i + 1];
          array[i + 1] = temp;
          swapped = true;
        }
      }

      if (!swapped) {
        break;
      }

      swapped = false;
      end -= 1;

      for (int i = end - 1; i >= start; i--) {
        if (array[i] > array[i + 1]) {
          int temp = array[i];
          array[i] = array[i + 1];
          array[i + 1] = temp;
          swapped = true;
        }
      }

      start += 1;
    }
  }
}
