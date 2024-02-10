import java.util.ArrayList;
import java.util.List;

public class AmicableNumbers {
  // Amicable numbers are two numbers where the sum of the proper divisors of each number is
  // equal to the other number. Here's an example of finding amicable numbers in a given range
  // using Java

  public static void main(String[] args) {
    // read input
    int rangeStart = 1;
    int rangeEnd = 1000;

    List<Integer[]> amicablePairs = findAmicablePairs(rangeStart, rangeEnd);

    System.out.println(
        "Amicable Number Pairs in the range [" + rangeStart + ", " + rangeEnd + "]:");
    for (Integer[] pair : amicablePairs) {
      System.out.println("(" + pair[0] + ", " + pair[1] + ")");
    }
  }

  private static List<Integer[]> findAmicablePairs(int start, int end) {
    List<Integer[]> amicablePairs = new ArrayList<>();

    for (int i = start; i <= end; i++) {
      int sumDivisorA = sumOfProperDivisors(i);

      // check for amicable pair
      if (sumDivisorA > i && sumDivisorA <= end) {
        int sumDivisorB = sumOfProperDivisors(sumDivisorA);
        if (sumDivisorB == i) {
          Integer[] pair = {i, sumDivisorA};
          amicablePairs.add(pair);
        }
      }
    }
    return amicablePairs;
  }

  private static int sumOfProperDivisors(int n) {
    int sum = 1;
    for (int i = 2; i <= Math.sqrt(n); i++) {
      if (n % i == 0) {
        sum += i;
        if (i != n / i) {
          sum += n / i;
        }
      }
    }
    return sum;
  }
}
