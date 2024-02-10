public class NQueensProblem {

  private static long counter;

  public static void main(String[] args) {
    // Change this value to solve for different board sizes
    int n = 4;
    solveNQueens(n);
    System.out.println("Total variants: " + counter);
  }

  private static void solveNQueens(int n) {
    int[] queensPlacement = new int[n];
    placeQueens(queensPlacement, 0, n);
  }

  private static void placeQueens(int[] queensPlacement, int row, int n) {
    if (row == n) {
      // base case
      printQueens(queensPlacement);
      counter++;
      return;
    }

    for (int col = 0; col < n; col++) {
      if (isSafe(queensPlacement, row, col)) {
        queensPlacement[row] = col;
        placeQueens(queensPlacement, row + 1, n);
      }
    }
  }

  private static boolean isSafe(int[] queensPlacement, int row, int col) {
    for (int prevRow = 0; prevRow < row; prevRow++) {
      int prevCol = queensPlacement[prevRow];

      // Check if the queen can be placed in the current position
      if (prevCol == col || Math.abs(prevRow - row) == Math.abs(prevCol - col)) {
        return false;
      }
    }
    return true;
  }

  private static void printQueens(int[] queensPlacement) {
    int n = queensPlacement.length;
    for (int i : queensPlacement) {
      for (int col = 0; col < n; col++) {
        if (i == col) {
          System.out.print("Q ");
        } else {
          System.out.print(". ");
        }
      }
      System.out.println();
    }
    System.out.println();
  }
}
