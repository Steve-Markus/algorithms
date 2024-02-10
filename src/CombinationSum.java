import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {

  public static void main(String[] args) {
    // input data
    int[] candidates = {2, 3, 6, 7};
    int target = 10;

    List<List<Integer>> result = combinationSum(candidates, target);

    System.out.println("Combinations for target " + target + ":");
    for (List<Integer> combination : result) {
      System.out.println(combination);
    }
  }

  private static List<List<Integer>> combinationSum(int[] candidates, int target) {
    // sort the candidates to handle duplicates
    Arrays.sort(candidates);
    List<List<Integer>> result = new ArrayList<>();
    backtrack(result, new ArrayList<>(), candidates, target, 0);
    return result;
  }

  private static void backtrack(List<List<Integer>> result, List<Integer> current, int[] candidates,
      int remaining, int start) {
    if (remaining < 0) {
      // exceeds the target, stop exploring this path
      return;
    } else if (remaining == 0) {
      // found a valid combination
      result.add(new ArrayList<>(current));
    } else {
      for (int i = start; i < candidates.length; i++) {
        // include current candidate
        current.add(candidates[i]);
        // continue exploring with the same candidate, since it can be used multiple times
        backtrack(result, current, candidates, remaining - candidates[i], i);
        current.remove(current.size() - 1);
        // backtrack
      }
    }
  }
}
