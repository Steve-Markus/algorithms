import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SetCover {

  public static void main(String[] args) {
    // read input
    List<Integer> universe = List.of(1, 2, 3, 4, 5);
    int[] a = {1, 2, 3, 4, 5};
    int[] b = {2, 3, 4, 5};
    int[] c = {5};
    int[] d = {3};
    List<int[]> sets = List.of(a, b, c, d);

    List<int[]> res = chooseSets(sets, universe);
    res.forEach(e -> System.out.println(Arrays.toString(e)));
  }

  private static List<int[]> chooseSets(List<int[]> sets, List<Integer> universe) {
    // selected sets
    List<int[]> selectedSets = new ArrayList<>();
    Set<Integer> universeSet = new HashSet<>(universe);
    // while we have nums left in universe
    while (!universeSet.isEmpty()) {
      int notChosenCount = 0;
      int[] chosenSet = sets.get(0);
      for (int[] set : sets) {
        int count = 0;
        for (int element : set) {
          // if element is present
          if (universeSet.contains(element)) {
            count++;
          }
        }
        if (notChosenCount < count) {
          notChosenCount = count;
          chosenSet = set;
        }
      }
      selectedSets.add(chosenSet);
      // remove nums if visited
      Arrays.stream(chosenSet).boxed().toList().forEach(universeSet::remove);
    }
    // remove result
    return selectedSets;
  }
}
