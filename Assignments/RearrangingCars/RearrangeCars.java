package RearrangingCars;

import java.util.ArrayList;

public class RearrangeCars {
  public static void printCarMoves(int[] original, int[] target) {
    ArrayList<Move> result = new ArrayList<>();
    result = RearrangeCars(original, target);

    for (Move m : result) {
      m.printMove();
    }
  }
  public static ArrayList<Move> RearrangeCars(int[] original, int[] target) {
    if (original.length != target.length) {
      return null;
    }

    ArrayList<Move> movesList = new ArrayList<>();
    int[] positions = new int[original.length];

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
          swap(movesList, positions, original, i, positions[0]);

          // Swap the current empty spot with the target number
          swap(movesList, positions, original, positions[target[i]], positions[0]);
        }
      }
    }

    return movesList;
  }

  private static void swap(ArrayList<Move> list, int[] positions, int[] currentArray, int currentIndex, int emptyIndex) {
    int currentNumber = currentArray[currentIndex];
    if (currentNumber == 0) {
      return;
    }

    currentArray[emptyIndex] = currentNumber;
    positions[currentNumber] = emptyIndex;

    currentArray[currentIndex] = 0;
    positions[0] = currentIndex;

    list.add(new Move(currentNumber, currentIndex, emptyIndex));
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
    printCarMoves(new int[]{1, 2, 0, 3}, new int[]{3, 1, 2, 0});
  }
}
