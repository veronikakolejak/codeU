package Assignment2;

import junit.framework.TestCase;
import org.junit.Before;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;

public class BinaryTreeTest extends TestCase {
  private BinaryTreeNode root;
  @Before
  public void setUp() throws Exception {
    this.root = new BinaryTreeNode(16);
    root.left = new BinaryTreeNode(9);
    root.right = new BinaryTreeNode(18);
    root.left.left = new BinaryTreeNode(3);
    root.left.right = new BinaryTreeNode(14);
    root.right.left = new BinaryTreeNode(20);
    root.right.right = new BinaryTreeNode(19);
    root.left.left.left = new BinaryTreeNode(1);
    root.left.left.right = new BinaryTreeNode(5);
  }

  public void testPrintAncestorsExample() {
    BinaryTree tree = new BinaryTree();
    assertThat(tree.getAncestorsKeys(root, 5), is(new Integer[]{3, 9, 16}));
  }

  public void testPrintAncestorsRoot() {
    BinaryTree tree = new BinaryTree();
    assertThat(tree.getAncestorsKeys(root, 16), is(new Integer[]{}));
  }

  public void testPrintAncestorsRightmost() {
    BinaryTree tree = new BinaryTree();
    assertThat(tree.getAncestorsKeys(root, 19), is(new Integer[]{18, 16}));
  }

  public void testCommonAncestorExample() {
    BinaryTree tree = new BinaryTree();
    assertThat(tree.lowestCommonAncestor(root, root.left.left.right, root.left.right), is(root.left));
  }

  public void testCommonAncestorRoot() {
    // One of the two nodes is root
    BinaryTree tree = new BinaryTree();
    assertThat(tree.lowestCommonAncestor(root, root, root.left.right), is(root));
  }

  public void testCommonAncestorRoot2() {
    // The two nodes are on completely opposite sides of the tree
    BinaryTree tree = new BinaryTree();
    assertThat(tree.lowestCommonAncestor(root, root.left.left.left, root.right.right), is(root));
  }

  public void testCommonAncestorLinearListTree() {
    root = new BinaryTreeNode(16);
    root.left = new BinaryTreeNode(9);
    root.left.left = new BinaryTreeNode(3);
    root.left.left.left = new BinaryTreeNode(1);
    root.left.left.left.left = new BinaryTreeNode(5);
    BinaryTree tree = new BinaryTree();
    assertThat(tree.lowestCommonAncestor(root, root.left.left.left, root.left), is(root.left));
  }

  public void testCommonAncestorNonexistentNode() {
    BinaryTree tree = new BinaryTree();
    assertNull(tree.lowestCommonAncestor(root, root.left.left.right, new BinaryTreeNode<>(23)));
  }
}