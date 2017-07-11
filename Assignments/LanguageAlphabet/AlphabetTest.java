package LanguageAlphabet;

import junit.framework.TestCase;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;

public class AlphabetTest extends TestCase {

  public void testSimpleExample() {
    String[] dictionary = new String[]{"ART", "RAT", "CAT", "CAR"};
    Alphabet alphabet = new Alphabet(dictionary);
    assertThat(alphabet.findAlphabet(), is(new Character[]{'A', 'T', 'R', 'C'}));
  }

  public void testIncludesAllCharacters() {
    String[] dictionary = new String[]{"ART", "RATS", "CATB", "CAR"};
    Alphabet alphabet = new Alphabet(dictionary);
    assertThat(alphabet.findAlphabet(), is(new Character[]{'A', 'T', 'S', 'B', 'R', 'C'}));
  }

  public void testCharactersThatCanGoAnywhere() {
    String[] dictionary = new String[]{"ART", "RAT", "CATB!3", "CARX"};
    Alphabet alphabet = new Alphabet(dictionary);
    assertThat(alphabet.findAlphabet(), is(new Character[]{'A', 'T', 'B', '!', '3', 'X', 'R', 'C'}));
  }

  public void testUniqueCharactersInAlphabet() {
    String[] dictionary = new String[]{"ART", "RAAAAATTTT", "CAT", "CAR"};
    Alphabet alphabet = new Alphabet(dictionary);
    assertThat(alphabet.findAlphabet(), is(new Character[]{'A', 'T', 'R', 'C'}));
  }

  public void testNewCharsButNoChangeToOldOnes() {
    String[] dictionary = new String[]{"ART", "RAT", "RAD", "RADS", "CAT", "CAR", "SOS", "SOA"};
    Alphabet alphabet = new Alphabet(dictionary);
    assertThat(alphabet.findAlphabet(), is(new Character[]{'S', 'A', 'T', 'D', 'R', 'C', 'O'}));
  }

}
