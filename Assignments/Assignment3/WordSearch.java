package Assignment3;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class WordSearch {

  private static int[] deltaX = {-1, -1, 0, 1, 1, 1, 0, -1};
  private static int[] deltaY = {0, 1, 1, 1, 0, -1, -1, -1};

  public static ArrayList<String> findWords(int height, int width, char[][] grid, Dictionary dictionary) {
    /* Dictionary is assumed to correctly return isWord and isPrefix (dis)regarding letter case */

    Set<String> words = new HashSet<>();

    /* Checks every letter in the grid if it can make a valid word if its the first letter */
    for (int y = 0; y < height; y++) {
      for (int x = 0; x < width; x++) {

        /* The helper visited 2D array has to be set to 0 with every new letter visited as the first letter */
        boolean[][] visited = new boolean[height][width];
        findWordsHelper(grid, visited, x, y, dictionary, "", words);
      }
    }

    return new ArrayList<>(words);
  }

  private static Set<String> findWordsHelper(char[][] grid, boolean[][] visited, int curX, int curY, Dictionary dictionary, String currentWord, Set<String> words) {

    currentWord += grid[curY][curX];
    visited[curY][curX] = true;

    /* Does not try to match additional letters if the current prefix is not contained in any of the dictionary words */
    if (!dictionary.isPrefix(currentWord)) {
      return words;
    }

    if (dictionary.isWord(currentWord)) {
      words.add(currentWord);
    }

    for (int i = 0; i < deltaX.length; i++) {
      int newX = curX + deltaX[i];
      int newY = curY + deltaY[i];

      if (newX >= 0 && newX < visited[0].length && newY >= 0 && newY < visited.length && !visited[newY][newX]) {
        findWordsHelper(grid, visited, newX, newY, dictionary, currentWord, words);
        visited[newY][newX] = false;
      }

    }

    return words;
  }
}
