public class PascalTriangle {

  public static void main(String[] args) {
    int numRows = 5;

    generateAndPrintPascalTriangle(numRows);
  }

  public static void generateAndPrintPascalTriangle(int numRows) {
    int[][] triangle = new int[numRows][];

    for (int i = 0; i < numRows; i++) {
      triangle[i] = new int[i + 1];
      triangle[i][0] = 1; // First element in each row is 1

      for (int j = 1; j < i; j++) {
        // Calculate each element based on the sum of the two elements above it
        triangle[i][j] = triangle[i - 1][j - 1] + triangle[i - 1][j];
      }

      triangle[i][i] = 1; // Last element in each row is 1

      // Center the output by adding spaces before the row
      for (int k = 0; k < numRows - i - 1; k++) {
        System.out.print("  ");
      }

      // Print the current row
      for (int j = 0; j <= i; j++) {
        System.out.print(triangle[i][j] + "   ");
      }
      System.out.println();
    }
  }
}