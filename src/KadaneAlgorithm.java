public class KadaneAlgorithm {

  public static void main(String[] args) {
    int[] array = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
    int maxSum = findMaxSubarraySum(array);
    System.out.println("Maximum subarray sum is: " + maxSum);
  }

  private static int findMaxSubarraySum(int[] array) {
    int maxSoFar = array[0];
    int maxEndingHere = array[0];

    for (int i = 1; i < array.length; i++) {
      maxEndingHere = Math.max(array[i], maxEndingHere + array[i]);
      maxSoFar = Math.max(maxSoFar, maxEndingHere);
    }

    return maxSoFar;
  }
}
