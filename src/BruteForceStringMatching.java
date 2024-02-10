public class BruteForceStringMatching {

  public static void main(String[] args) {
    // read input
    String text = "ABCABCD";
    String pattern = "ABC";

    int result = bruteForceSearch(text, pattern);

    if (result != -1) {
      System.out.println("Pattern found at index " + result);
    } else {
      System.out.println("Pattern not found in the text");
    }
  }

  private static int bruteForceSearch(String text, String pattern) {
    int n = text.length();
    int m = pattern.length();

    for (int i = 0; i <= n - m; i++) {
      int j;
      for (j = 0; j < m; j++) {
        if (text.charAt(i + j) != pattern.charAt(j)) {
          break;
        }
      }
      if (j == m) {
        // pattern fount at index i in the text
        return i;
      }
    }
    // pattern not found in the text
    return -1;
  }
}
