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
    /* Return if there are no more nodes to explore on this path, the base case for the recursion */
    if (root == null) {
      return null;
    }
    if (root == node1 || root == node2 ) {
      return root;
    }

    BinaryTreeNode lookLeft = helperCommonAncestor(root.left, node1, node2);
    BinaryTreeNode lookRight = helperCommonAncestor(root.right, node1, node2);

    /* If they are both non-null then they are on separate sides and this is the common ancestor */
    if (lookLeft != null && lookRight != null) {
      return root;
    }

    return (lookLeft != null) ? lookLeft : lookRight;
  }
}
