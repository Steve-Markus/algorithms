public class TowerOfHanoi {

  private static Long counter = 0L;

  public static void main(String[] args) {
    // number of disks
    int numDisks = 3;
    // rods
    char sourceRod = 'A';
    char auxiliaryRod = 'B';
    char destinationRod = 'C';

    System.out.println("Tower of Hanoi with " + numDisks + " disks:");
    solveHanoi(numDisks, sourceRod, auxiliaryRod, destinationRod);
    System.out.println(counter + " moves needed.");
  }

  private static void solveHanoi(int numDisks, char sourceRod, char auxiliaryRod,
      char destinationRod) {
    // increase counter
    counter++;
    if (numDisks == 1) {
      // base case: move the top disk from source to destination
      System.out.println("Move disk 1 from " + sourceRod + " to " + destinationRod);
      return;
    }

    // move (numDisks -1) disks from source to auxiliary rod using destination rod
    solveHanoi(numDisks - 1, sourceRod, destinationRod, auxiliaryRod);

    // move the remaining disk from source to destination rod
    System.out.println("Move disk " + numDisks + " from " + sourceRod + " to " + destinationRod);

    // move (numDisks - 1) disks from auxiliary rod to destination rod using source rod
    solveHanoi(numDisks - 1, auxiliaryRod, sourceRod, destinationRod);
  }
}
