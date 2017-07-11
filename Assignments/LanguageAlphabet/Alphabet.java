package LanguageAlphabet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Alphabet {
  private static String[] dictionary;
  private static ArrayList<Character> alphabetChars = new ArrayList<>();
  private static HashMap<Character, Node> graph = new HashMap<>();
  private ArrayList<Character> result = new ArrayList<>();

  public Alphabet(String[] dict) {
    this.dictionary = dict;
  }

  public Character[] findAlphabet() {
    // It is assumed that the dictionary given is sound and correct
    buildGraph();
    sortTopologically();

    Character[] alphabet = new Character[result.size()];
    alphabet = result.toArray(alphabet);
    return alphabet;
  }

  public void buildGraph() {
    // Since we don't know what is the number of 'letters' in the alphabet, we have to check every character in every word
    for (int word = 0; word < dictionary.length; word++) {
      for (int letter = 0; letter < dictionary[word].length(); letter++) {
        getNodeByChar(dictionary[word].charAt(letter));
      }
    }

    // Cycle through the dictionary, always looking at two neighboring words
    for (int i = 0; i < dictionary.length - 1; i++) {
      int index = indexOfMismatch(dictionary[i], dictionary[i + 1]);

      // if it is possible that some information can be inferred from these two words, do so
      if (index > -1) {
        // Add the letters to the alphabet if not already there
        Node firstNode = getNodeByChar(dictionary[i].charAt(index));
        Node secondNode = getNodeByChar(dictionary[i + 1].charAt(index));

        firstNode.addNext(secondNode);
        secondNode.incrementIncomingCount();
      }
    }
  }

  public void sortTopologically() {
    Queue<Node> q = new LinkedList<>();

    // Find all nodes that could be first in the alphabet and add them to the queue
    for (Character ch : alphabetChars) {

      Node node = graph.get(ch);
      if (node.getIncomingCount() == 0) {
        q.add(node);
      }
    }

    // Remove those nodes from other node's dependencies
    while (!q.isEmpty()) {
      Node current = q.poll();
      result.add(current.getValue());

      // Decrease number of dependencies for each outgoing node
      for (Node node : current.getAdjacent()) {
        if (node.decrementedIncomingCount() == 0) {
          q.add(node);
        }
      }
    }
  }

  public Node getNodeByChar(Character ch) {
    if (graph.containsKey(ch)) {
      return graph.get(ch);
    }

    Node node = new Node(ch);

    graph.put(ch, node);
    alphabetChars.add(ch);

    return node;
  }

  public static int indexOfMismatch(String word1, String word2) {
    int i = 0;

    while (i < word1.length() && i < word2.length() && word1.charAt(i) == word2.charAt(i)) {
      i++;
    }

    if (i == word1.length() || i == word2.length()) {
      return -1;
    }

    return i;
  }

  public static void main(String args[]) {
    System.out.println(indexOfMismatch("hello", "hell"));
    System.out.println(indexOfMismatch("hello", "pam"));

    Alphabet a = new Alphabet(new String[]{"ART", "RAT", "CATB!3", "CARX"});

    Character[] alphabet = a.findAlphabet();

    for (Character ch : alphabet) {
      System.out.print(ch + " ");
    }
    System.out.println();
  }
}
