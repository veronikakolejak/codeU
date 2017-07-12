package LanguageAlphabet;

import java.util.ArrayList;
import java.util.HashSet;

public class Node {
  private ArrayList<Node> adjacent = new ArrayList<Node>();
  private HashSet values = new HashSet();
  private Character symbol;
  private int incomingEdgesCount;

  public Node(Character value) {
    symbol = value;
    incomingEdgesCount = 0;
  }

  public void addNext(Node node) {
    if (!values.contains(node.getValue())) {
      adjacent.add(node);
      values.add(node.getValue());
    }
  }

  public void incrementIncomingCount() {
    incomingEdgesCount++;
  }

  public int decrementedIncomingCount() {
    incomingEdgesCount--;
    return incomingEdgesCount;
  }

  public ArrayList<Node> getAdjacent() {
    return adjacent;
  }

  public Character getValue() {
    return symbol;
  }

  public int getIncomingCount() {
    return incomingEdgesCount;
  }
}
