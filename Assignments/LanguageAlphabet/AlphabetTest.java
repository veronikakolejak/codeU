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

  public void testNewCharInRespectToFirstOld() {
    // S should come before A and O should come after A
    String[] dictionary = new String[]{"ART", "RAT", "CAT", "CAR", "COS", "COA"};
    Alphabet alphabet = new Alphabet(dictionary);
    assertThat(alphabet.findAlphabet(), is(new Character[]{'T', 'S', 'A', 'R', 'O', 'C'}));
  }

  public void testInvalidDictionary() {
    // S comes after A but also before A and S comes after C but also before C
    String[] dictionary = new String[]{"ART", "RAT", "CAT", "CAR", "SOS", "COA"};
    Alphabet alphabet = new Alphabet(dictionary);
    Character[] emptyArray = {};
    assertThat(alphabet.findAlphabet(), is(emptyArray));
  }

  public void testEmptyDictionary() {
    // S comes after A but also before A and S comes after C but also before C
    String[] dictionary = new String[]{""};
    Alphabet alphabet = new Alphabet(dictionary);
    Character[] emptyArray = {};
    assertThat(alphabet.findAlphabet(), is(emptyArray));
  }
}
