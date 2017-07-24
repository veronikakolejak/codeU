package RearrangingCars;

import org.junit.Test;

import static org.junit.Assert.*;

public class RearrangeCarsTest {
  @Test
  public void ExampleTestCase() {
    assertArrayEquals(RearrangeCars.getFinalCarArray(new int[]{1, 2, 0, 3}, new int[]{3, 1, 2, 0}), new int[]{3, 1, 2, 0});
  }

  @Test
  public void IdenticalOrder() {
    assertArrayEquals(RearrangeCars.getFinalCarArray(new int[]{0, 1, 2, 3, 4}, new int[]{0, 1, 2, 3, 4}), new int[]{0, 1, 2, 3, 4});
  }

  @Test
  public void InverslyOrderedNumbers() {
    assertArrayEquals(RearrangeCars.getFinalCarArray(new int[]{0, 1, 2, 3, 4}, new int[]{4, 3, 2, 1, 0}), new int[]{4, 3, 2, 1, 0});
  }

  @Test
  public void InverslyOrderedNumbersEmptyFirst() {
    assertArrayEquals(RearrangeCars.getFinalCarArray(new int[]{1, 2, 0, 3, 4}, new int[]{0, 4, 3, 2, 1}), new int[]{0, 4, 3, 2, 1});
  }
}