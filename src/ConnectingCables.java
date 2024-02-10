import java.util.Arrays;
import java.util.Comparator;

public class ConnectingCables {

  public static void main(String[] args) {
    // input data
    int[] a = {1, 2, 3, 4};
    int[] b = {2, 3, 4, 5};

    int result = maxConnections(a, b);

    System.out.println("Maximum number of non-crossing connections: " + result);
  }

  private static int maxConnections(int[] a, int[] b) {
    int n = a.length;
    // create pairs array to store the endpoints of the cables
    int[][] pairs = new int[n][2];

    for (int i = 0; i < n; i++) {
      pairs[i][0] = a[i];
      pairs[i][1] = b[i];
    }

    // sort pairs based on the first endpoint
    Arrays.sort(pairs, Comparator.comparingInt(pair -> pair[0]));

    // dynamic programming table to store the maximum connections at each point
    int[] dp = new int[n];
    Arrays.fill(dp, 1);

    // calculate maximum connections
    for (int i = 1; i < n; i++) {
      for (int j = 0; j < i; j++) {
        if (pairs[i][1] > pairs[j][1]) {
          dp[i] = Math.max(dp[i], dp[j] + 1);
        }
      }
    }

    // find the maximum connections in the dp array
    return Arrays.stream(dp).max().orElse(0);
  }
}
