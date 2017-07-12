package Assignment2;

import java.util.ArrayList;

public class BinaryTree {
  public static void printAncestors(BinaryTreeNode<Integer> root, Integer key) {
    Integer[] result = getAncestorsKeys(root, key);

    for (int i =  0; i < result.length; i++) {
      System.out.print(result[i] + " ");
    }
    System.out.println();
  }

  public static Integer[] getAncestorsKeys(BinaryTreeNode<Integer> root, Integer key) {
    ArrayList<Integer> ancestors = new ArrayList<>();
    findAncestors(root, key, ancestors);

    Integer[] ancestorsArray = new Integer[ancestors.size()];
    ancestorsArray = ancestors.toArray(ancestorsArray);
    return ancestorsArray;
  }

  public static boolean findAncestors(BinaryTreeNode<Integer> root, Integer targetKey, ArrayList<Integer> ancestors) {
    /* Return if there are no more nodes on this path - base case for the recursion */
    if (root == null) {
      return false;
    }

    Integer currentKey = root.data;
    /* Return true if the current node is the key */
    if (currentKey == targetKey) {
      return true;
    }

    if (findAncestors(root.left, targetKey, ancestors) || findAncestors(root.right, targetKey, ancestors)) {
      ancestors.add(currentKey);
      return true;
    }

    return false;
  }

  public static BinaryTreeNode<Integer> lowestCommonAncestor(BinaryTreeNode<Integer> root, BinaryTreeNode<Integer> node1, BinaryTreeNode<Integer> node2) {
    /* Check if the two nodes are actually present in the tree */
    if (!presentInSubtree(root, node1) || !presentInSubtree(root, node2)) {
      return null;
    }

    return helperCommonAncestor(root, node1, node2);
  }

  public static boolean presentInSubtree(BinaryTreeNode<Integer> root, BinaryTreeNode<Integer> node) {
    if (root == null) {
      return false;
    }

    if (root == node) {
      return true;
    }

    return presentInSubtree(root.left, node) || presentInSubtree(root.right, node);
  }

  public static BinaryTreeNode<Integer> helperCommonAncestor(BinaryTreeNode<Integer> root, BinaryTreeNode<Integer> node1, BinaryTreeNode<Integer> node2) {
    /* Return if there are no more nodes to explore on this path, also the base case for the recursion */
    if (root == node1 || root == node2 || root == null) {
      return root;
    }

    boolean node1InLeftSubtree = presentInSubtree(root.left, node1);
    boolean node2InLeftSubtree = presentInSubtree(root.left, node2);

    /* If they are on the separate sides, exit this level */
    if (node1InLeftSubtree != node2InLeftSubtree) {
      return root;
    }

    if (node1InLeftSubtree) {
      return helperCommonAncestor(root.left, node1, node2);
    } else {
      return helperCommonAncestor(root.right, node1, node2);
    }
  }
}
