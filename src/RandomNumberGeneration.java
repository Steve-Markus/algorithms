import java.util.Random;

public class RandomNumberGeneration {

  public static void main(String[] args) {
    int maxRange = 100;
    int minRange = 1;
    // change ranges if needed

    // generate a random number within the specified range
    int randomNumber = generateRandomNumber(minRange, maxRange);

    System.out.println(
        "Random number between " + minRange + " and " + maxRange + ": " + randomNumber);
  }

  private static int generateRandomNumber(int min, int max) {
    // to get a number between min (inclusive) and max (exclusive), add min to the result
    return new Random().nextInt(max - min) + min;
  }
}
