package RearrangingCars;

public class RearrangeCars {
  public static void RearrangeCars(int[] original, int[] target) {
    if (original.length != target.length) {
      return;
    }

    int[] positions = new int[original.length];

    printIntArray(original);
    // Get the positions of cars in the original array
    for (int i = 0; i < original.length; i++) {
      int currentNumber = original[i];
      positions[currentNumber] = i;
    }

    // Loop over numbers and swap those cars that need to change places
    for (int i = 0; i < original.length; i++) {
      if (original[i] != target[i]) {
        if (target[i] != 0) {
          // Swap the current number with an empty spot
          swap(positions, original, i, positions[0]);
          printIntArray(original);

          // Swap the current empty spot with the target number
          swap(positions, original, positions[target[i]], positions[0]);
          printIntArray(original);
        }
      }
    }
  }

  private static void swap(int[] positions, int[] currentArray, int currentIndex, int emptyIndex) {
    printSwap(currentArray[currentIndex], currentIndex, emptyIndex);

    currentArray[emptyIndex] = currentArray[currentIndex];
    positions[currentArray[currentIndex]] = emptyIndex;

    currentArray[currentIndex] = 0;
    positions[0] = currentIndex;
  }

  private static void printIntArray(int[] array) {
    for (int number : array) {
      System.out.print(number + " ");
    }
    System.out.println();
  }

  private static void printSwap(int first, int index1, int index2) {
    System.out.println("Move car number " + first + " at " + index1 + " to position " + index2);
  }

  public static void main(String[] args) {
    RearrangeCars(new int[]{1, 2, 0, 3}, new int[]{3, 1, 2, 0});
  }
}
