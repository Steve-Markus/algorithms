import java.util.Random;

public class LabyrinthGenerator {

  private static final int WALL = 0;
  private static final int PATH = 1;

  private static final Random random = new Random();

  public static void main(String[] args) {
    // change if needed
    int rows = 5;
    // also this
    int cols = 5;

    int[][] randomLabyrinth = new int[rows][cols];

    // Generate random Labyrinth - top-left corner to the bottom-right
    generateRandomLabyrinth(randomLabyrinth);

    // Print the random Labyrinth
    System.out.println("Random Labyrinth:");
    printLabyrinth(randomLabyrinth);
  }

  private static void generateRandomLabyrinth(int[][] maze) {
    int rows = maze.length;
    int cols = maze[0].length;

    for (int i = 0; i < rows; i++) {
      for (int c = 0; c < cols; c++) {
        maze[i][c] = getRandomWallOrPath();
      }
    }
  }

  private static int getRandomWallOrPath() {
    // adjust the probabilities as needed
    return random.nextInt(4) == 0 ? WALL : PATH;
  }

  private static void printLabyrinth(int[][] maze) {
    for (int[] row : maze) {
      for (int cell : row) {
        System.out.print(cell + " ");
      }
      System.out.println();
    }
  }
}
