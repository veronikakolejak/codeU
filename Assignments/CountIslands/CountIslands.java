package CountIslands;

import java.util.LinkedList;
import java.util.Queue;

public class CountIslands {

  public static int islandsCount(int width, int height, boolean[][] map) {
    boolean[][] visitedTiles = new boolean[width][height];
    int count = 0;

    for (int y = 0; y < height; y++) {
      for (int x = 0; x < width; x++) {
        // unvisited land tile found
        if (!visitedTiles[x][y] && map[x][y]) {
          bfs(x, y, map, visitedTiles);
          count++;
        }
      }
    }

    return count;
  }

  public static void bfs(int x, int y, boolean[][] map, boolean[][] visitedTiles) {
    Queue<Integer> q = new LinkedList<>();

    q.add(x);
    q.add(y);

    int[] deltaX = {-1, 1, 0, 0};
    int[] deltaY = {0, 0, 1, -1};

    while (!q.isEmpty()) {
      int curX = q.poll();
      int curY = q.poll();

      visitedTiles[curX][curY] = true;

      for (int i = 0; i < deltaX.length; i++) {
        int newX = curX + deltaX[i];
        int newY = curY + deltaY[i];

        // Check if the new coordinates are in the correct range
        if (newX < 0 || newX >= map.length || newY < 0 || newY >= map[0].length) {
          continue;
        }

        if(!visitedTiles[newX][newY] && map[newX][newY]) {
          q.add(newX);
          q.add(newY);
        }
      }
    }
  }
}
