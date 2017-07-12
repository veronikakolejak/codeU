package LanguageAlphabet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Alphabet {
  private static String[] dictionary;
  private static ArrayList<Character> alphabetChars;
  private static HashMap<Character, Node> graph;
  private ArrayList<Character> result;

  public Alphabet(String[] dict) {
    this.dictionary = dict;
    this.graph = new HashMap<>();
    this.alphabetChars = new ArrayList<>();
    this.result = new ArrayList<>();
  }

  public Character[] findAlphabet() {
    // Assumed the dictionary given is sound and correct, if not, return an empty alphabet array
    // Uppercase and lowercase characters of the same letter are considered different letters of an alphabet
    buildGraph();
    sortTopologically();

    Character[] alphabet = new Character[result.size()];
    alphabet = result.toArray(alphabet);
    return alphabet;
  }

  public void buildGraph() {
    // Since the number of letters in the alphabet is unknown, check every character in every word
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

    // Keep count of already ordered alphabet characters
    int count = 0;

    // Remove nodes with 0 incoming edges from other node's dependencies
    while (!q.isEmpty()) {
      Node current = q.poll();
      result.add(current.getValue());
      count++;

      // Decrease the number of dependencies for each outgoing node
      for (Node node : current.getAdjacent()) {
        if (node.decrementedIncomingCount() == 0) {
          q.add(node);
        }
      }
    }

    // If some characters are missing, there must have been a cycle in the graph and an incorrect dictionary as the input
    if (count < alphabetChars.size()) {
      result = new ArrayList<>();
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
}
