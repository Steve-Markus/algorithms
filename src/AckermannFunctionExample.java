public class AckermannFunctionExample {

  public static void main(String[] args) {
    int m = 2;
    int n = 1;
    int result = ackermannFunction(m, n);
    System.out.println("A(" + m + ", " + n + ") = " + result);
  }

  private static int ackermannFunction(int m, int n) {
    // base case
    if (m == 0) {
      return n + 1;
      // call recursion
    } else if (m > 0 && n == 0) {
      return ackermannFunction(m - 1, 1);
    } else {
      return ackermannFunction(m - 1, ackermannFunction(m, n - 1));
    }
  }
}
