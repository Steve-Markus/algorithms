public class CollatzConjectureExample {

  public static void main(String[] args) {
    int startNumber = 6;
    System.out.println("Collatz conjecture starting with " + startNumber + ":");
    printCollatzConjecture(startNumber);
  }

  private static void printCollatzConjecture(int n) {
    while (n != 1) {
      System.out.print(n + " -> ");
      if (n % 2 == 0) {
        // if even, divide by 2
        n /= 2;
      } else {
        // if odd, multiply by 3 and add 1
        n = 3 * n + 1;
      }
    }
    // sequence always ends with 1
    System.out.println("1");
  }
}
