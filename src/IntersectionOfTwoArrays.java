import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class IntersectionOfTwoArrays {

  public static void main(String[] args) {
    // read input
    int[] nums1 = {1, 2, 3, 4};
    int[] nums2 = {1, 2};
    int[] res = intersection(nums1, nums2);
    System.out.println(Arrays.toString(res));
  }

  private static int[] intersection(int[] nums1, int[] nums2) {
    Set<Integer> container = new HashSet<>();
    Set<Integer> output = new HashSet<>();

    for (var num : nums1) {
      container.add(num);
    }
    for (var num : nums2) {
      if (container.contains(num)) {
        output.add(num);
      }
    }
    int[] outputArray = new int[output.size()];
    int index = 0;
    for (var x : output) {
      outputArray[index] = x;
      index++;
    }

    return outputArray;
  }
}
