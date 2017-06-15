package Assignment3;

import junit.framework.TestCase;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.not;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordSearchTest extends TestCase {
  public static Dictionary dict = new Dictionary() {

    List<String> words = new ArrayList<>(Arrays.asList(
      "car", "card", "cart", "cat", "cardc", "tata", "a", "ar", "pines", "dates", "pint"
    ));

    @Override
    public boolean isWord(String string) {
      return words.contains(string);
    }

    @Override
    public boolean isPrefix(String string) {
      for (String word : words) {
        if (word.startsWith(string)) {
          return true;
        }
      }
      return false;
    }
  };

  public void testFindWords() throws Exception {
    /* Grid example used for this test */
    // T C D
    // A A R
    char grid[][] = {{'a', 'a', 'r'}, {'t', 'c', 'd'}};

    List<String> words = WordSearch.findWords(2, 3, grid, dict);

    /* Check for all correct valid words from the dictionary */
    assertThat(words, hasItems("cat", "card", "cat", "a", "ar"));

    /* Check that it does not use a letter twice */
    assertThat(words, not(hasItems("tata")));

    /* Check that it does not cycle */
    assertThat(words, not(hasItems("tata")));

    /* Check that it does not output an empty string since it is not a word */
    assertThat(words, not(hasItems("")));

    /* Check that it does not use letters not present in the grid */
    assertThat(words, not(hasItems("hey")));

    /* Check that it does not output two appended dictionary words */
    assertThat(words, not(hasItems("aar")));

    /* Check that it does not use letters not present in the dictionary */
    assertThat(words, not(hasItems("tar")));
  }

  public void testFindWordsLargerGrid() throws Exception {
    /* Grid example used for this test adapted from http://coursera.cs.princeton.edu/algs4/assignments/boggle.html */
    // A T E L
    // A P Y O
    // T I N V
    // B D S E
    char grid[][] = {{'a', 't', 'e', 'l'}, {'a', 'p', 'y', 'o'}, {'t', 'i', 'n', 'v'}, {'b', 'd', 's', 'e'}};

    List<String> words = WordSearch.findWords(4, 4, grid, dict);

    /* Check for correct valid words from dictionary */
    assertThat(words, hasItems("pines"));

    /* Check that it does not find words whose letters are not adjacent or sequentially adjacent */
    assertThat(words, not(hasItems("dates", "pint")));
  }
}