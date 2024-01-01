import java.util.ArrayList;
import java.util.List;

public class CombinationsExample {

  public static void main(String[] args) {
    // values
    int[] nums = {1, 2, 3, 4};
    // slots
    int r = 3;

    List<List<Integer>> combinations = generateCombinations(nums, r);
    System.out.println("Combinations: ");
    combinations.forEach(e -> System.out.println(e.toString()));
  }

  private static List<List<Integer>> generateCombinations(int[] nums, int r) {
    List<List<Integer>> result = new ArrayList<>();
    generateCombinationsHelper(nums, new ArrayList<>(), 0, r, result);
    return result;
  }

  private static void generateCombinationsHelper(int[] nums, List<Integer> current, int start,
      int r, List<List<Integer>> result) {
    if (r == 0) {
      // base case
      result.add(new ArrayList<>(current));
      return;
    }

    for (int i = start; i < nums.length; i++) {
      current.add(nums[i]);
      generateCombinationsHelper(nums, current, i + 1, r - 1, result);
      current.remove(current.size() - 1);
    }
  }
}
