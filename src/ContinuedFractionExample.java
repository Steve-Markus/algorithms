public class ContinuedFractionExample {

  public static void main(String[] args) {
    double result = computeContinuedFraction(1, 2, 3, 4, 5);
    System.out.println("Result of the continued fraction: " + result);
  }

  private static double computeContinuedFraction(int... coefficients) {
    int n = coefficients.length;

    if (n == 0) {
      return 0.0;
    }

    double result = coefficients[n - 1];
    for (int i = n - 2; i >= 0; i--) {
      result = coefficients[i] + 1.0 / result;
    }

    return result;
  }
}
