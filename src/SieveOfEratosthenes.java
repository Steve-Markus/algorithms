import java.util.Arrays;

public class SieveOfEratosthenes {

  public static void main(String[] args) {
    // the limit we want
    int limit = 30;
    sieveOfEratosthenes(limit);
  }

  private static void sieveOfEratosthenes(int limit) {
    boolean[] isPrime = new boolean[limit + 1];
    Arrays.fill(isPrime, true);

    for (int p = 2; p * p <= limit; p++) {
      if (isPrime[p]) {
        for (int i = p * p; i <= limit; i += p) {
          isPrime[i] = false;
        }
      }
    }
    // Print the prime numbers
    System.out.println("Prime numbers up to " + limit);
    for (int i = 2; i <= limit; i++) {
      if (isPrime[i]) {
        System.out.print(i + " ");
      }
    }
  }
}
