package Q2KthToLastElement;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class KthToLastElementTest extends TestCase {

  Node head;

  @Before
  public void setUpLinkedList() {
    int[] nodeData = {5, 6, 7, 8, 9, 10, 11, 12};

    head = new Node(nodeData[0]);
    Node node = head;

    for (int i = 1; i < nodeData.length; i++) {
      Node newNode = new Node(nodeData[i]);
      node.next = newNode;
      node = node.next;
    }
  }

  @Test
  public void testKthToLastElement() {
    Node singleNode = new Node(5);
    assertEquals(singleNode, KthToLastElement.kthElement(singleNode, 0));

    setUpLinkedList();
    assertEquals(12, KthToLastElement.kthElement(head, 0).data);
    assertEquals(11, KthToLastElement.kthElement(head, 1).data);
    assertEquals(6, KthToLastElement.kthElement(head, 6).data);
    assertEquals(5, KthToLastElement.kthElement(head, 7).data);

    try {
      KthToLastElement.kthElement(head, -2);
      Assert.fail();
    }
    catch (Exception e) {
      assertEquals(e.getClass(), IndexOutOfBoundsException.class);
    }

    try {
      KthToLastElement.kthElement(head, 20);
      Assert.fail();
    }
    catch (Exception e) {
      assertEquals(e.getClass(), java.util.NoSuchElementException.class);
    }

    try {
      KthToLastElement.kthElement(null, 0);
      Assert.fail();
    }
    catch (Exception e) {
      assertEquals(e.getClass(), NullPointerException.class);
    }
  }
}