public class GoldenRatioExample {

  public static void main(String[] args) {
    // calculate the golden ratio
    double goldenRatio = calculateGoldenRatio();
    System.out.println("Golden ratio: " + goldenRatio);

    // use result in a simple context
    int w = 10;
    int h = (int) (w * goldenRatio);
    System.out.println("Rectangle dimensions: " + w + " x " + h);
  }

  private static double calculateGoldenRatio() {
    // using formula: (1 + sqrt(5)) / 2
    return (1 + Math.sqrt(5)) / 2;
  }
}
