package CountIslands;

import org.junit.Test;
import static org.junit.Assert.*;

public class CountIslandsTest {

  @Test
  public void testSimpleCase() {
    // T F T F T
    // T F T F T
    // T F T F T
    // T F T F T

    boolean[][] map = {
      {true, false, true, false, true},
      {true, false, true, false, true},
      {true, false, true, false, true},
      {true, false, true, false, true}
    };

    assertEquals(3, CountIslands.islandsCount(4, 5, map));
  }

  @Test
  public void testSimpleSquareCase() {
    // F F T F T
    // T T T F T
    // T F T F T
    // T F T F T
    // T F T F T

    boolean[][] map = {
      {false, false, true, false, true},
      {true, true, true, false, true},
      {true, false, true, false, true},
      {true, false, true, false, true},
      {true, false, true, false, true}
    };

    assertEquals(2, CountIslands.islandsCount(5, 5, map));
  }

  @Test
  public void testSingleIsland() {
    // T T F T T
    // T T T T T
    // T F F T T
    // T T T T F

    boolean[][] map = {
      {true, true, true, false, true},
      {true, true, true, true, true},
      {true, false, false, true, true},
      {true, true, true, true, false}
    };

    assertEquals(1, CountIslands.islandsCount(4, 5, map));
  }

  @Test
  public void testDiagonals() {
    // F T F F
    // F F T T
    // F F T T
    // F T F F
    // T F T F

    boolean[][] map = {
      {false, true, false, false},
      {false, false, true, true},
      {false, false, true, true},
      {false, true, false, false},
      {true, false, true, false}
    };

    assertEquals(5, CountIslands.islandsCount(5, 4, map));
  }

  @Test
  public void testNoIsland() {
    // F F F F
    // F F F F
    // F F F F
    // F F F F
    // F F F F

    boolean[][] map = {
      {false, false, false, false},
      {false, false, false, false},
      {false, false, false, false},
      {false, false, false, false},
      {false, false, false, false}
    };

    assertEquals(0, CountIslands.islandsCount(5, 4, map));
  }

  @Test
  public void testHorizontal() {
    // F F T F T T F T T F T

    boolean[][] map = {
      {false, false, true, false, true, true, false, true, true, false, true}
    };

    assertEquals(4, CountIslands.islandsCount(1, 11, map));
  }

  @Test
  public void testVertical() {
    // F
    // F
    // T
    // F
    // T
    // T
    // F
    // T

    boolean[][] map = {
      {false},
      {false},
      {true},
      {false},
      {true},
      {true},
      {false},
      {true}
    };

    assertEquals(3, CountIslands.islandsCount(8, 1, map));
  }
}
