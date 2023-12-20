import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MinimumCoinChange {

  public static void main(String[] args) {
    // read input
    int[] coins = {1, 2, 5};
    int amount = 11;

    List<Integer> usedCoins = minCoins(coins, amount);

    System.out.println(
        "Minimum number of coins needed to make " + amount + ": " + usedCoins.size());
    System.out.println("Used coins: " + usedCoins);
  }

  private static List<Integer> minCoins(int[] coins, int target) {
    int[] dp = new int[target + 1];
    Arrays.fill(dp, Integer.MAX_VALUE);
    dp[0] = 0;

    List<List<Integer>> usedCoins = new ArrayList<>();
    for (int i = 0; i <= target; i++) {
      usedCoins.add(new ArrayList<>());
    }

    for (var coin : coins) {
      for (int i = coin; i <= target; i++) {
        if (dp[i - coin] != Integer.MAX_VALUE && dp[i - coin] + 1 < dp[i]) {
          dp[i] = dp[i - coin] + 1;
          usedCoins.get(i).clear();
          usedCoins.get(i).addAll(usedCoins.get(i - coin));
          usedCoins.get(i).add(coin);
        }
      }
    }

    return usedCoins.get(target).isEmpty() ? Collections.emptyList() :
        usedCoins.get(target);
  }
}
