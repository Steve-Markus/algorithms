import java.util.ArrayList;
import java.util.List;

public class RecursionClassicProblems {

  public static void main(String[] args) {
    // 1. Factorial calculation
    System.out.println("1. Factorial result: " + calculateFactorial(5));

    // 2. Fibonacci sequence
    System.out.println("2. Fibonacci result: " + calculateFibonacci(10));

    // 3. Binary Search
    System.out.println("3. Binary search result: "
        + binarySearch(new int[]{1, 2, 3, 4, 5}, 2, 0, 4));

    // 4. Sum of Digits
    System.out.println("4. Sum of digits result: " + calculateSumOfDigits(1234));

    // 5. Power Function
    System.out.println("5. Calculate power result: " + calculatePower(5, 2));

    // 6. Reverse a String
    System.out.println("6. Reverse a String result: " + reverseString("Good day"));

    // 7. Tower of Hanoi
    System.out.println("7. Tower of Hanoi result: ");
    solveHanoi(3, 'A', 'B', 'C');

    // 8. Combination Generation
    System.out.println("8. Combination generation result: ");
    generateCombinations(new int[]{1, 2, 3, 4}, 3);
  }

  private static void generateCombinations(int[] nums, int slots) {
    List<List<Integer>> result = new ArrayList<>();
    generateCombinationsHelper(nums, 0, slots, new ArrayList<>(), result);

    System.out.println("Combinations");
    for (var combination : result) {
      System.out.println(combination);
    }
  }

  private static void generateCombinationsHelper(int[] nums, int start, int slots,
      List<Integer> current,
      List<List<Integer>> result) {
    if (slots == 0) {
      result.add(new ArrayList<>(current));
      return;
    }

    for (int i = start; i < nums.length; i++) {
      current.add(nums[i]);
      generateCombinationsHelper(nums, i + 1, slots - 1, current, result);
      current.remove(current.size() - 1);
    }
  }

  private static void solveHanoi(int n, char source, char auxiliary, char destination) {
    if (n == 1) {
      System.out.println("Mode disk 1 from " + source + " to " + destination);
    } else {
      solveHanoi(n - 1, source, destination, auxiliary);
      System.out.println("Move disk " + n + " from " + source + " to " + destination);
      solveHanoi(n - 1, auxiliary, source, destination);
    }
  }

  private static String reverseString(String str) {
    if (str.isEmpty()) {
      return str;
    }
    return reverseString(str.substring(1)) + str.charAt(0);
  }

  private static double calculatePower(double base, int exponent) {
    if (exponent == 0) {
      return 1;
    }
    return base * calculatePower(base, exponent - 1);
  }

  private static int calculateSumOfDigits(int n) {
    if (n < 10) {
      return n;
    }
    return n % 10 + calculateSumOfDigits(n / 10);
  }

  private static int binarySearch(int[] array, int target, int low, int high) {
    if (low <= high) {
      int mid = low + (high - low) / 2;
      if (array[mid] == target) {
        return mid;
      } else if (array[mid] < target) {
        return binarySearch(array, target, mid + 1, high);
      } else {
        return binarySearch(array, target, low, mid - 1);
      }
    }

    // element not found
    return -1;
  }

  private static int calculateFibonacci(int n) {
    if (n <= 1) {
      return n;
    }
    return calculateSumOfDigits(n - 1) + calculateSumOfDigits(n - 2);
  }

  private static int calculateFactorial(int n) {
    if (n == 0 || n == 1) {
      return 1;
    }
    return n * calculateFactorial(n - 1);
  }
}
