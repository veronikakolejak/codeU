package Q2KthToLastElement;

import java.util.Optional;

public class KthToLastElement {

    public static <T> Node<T> kthElement(Node<T> head, int k) {
        if (k < 0) {
          throw new IndexOutOfBoundsException();
        }

        /* Throws NullPointerException if head is null */
        Optional<Node<T>> pointer1 = Optional.of(head);
        Optional<Node<T>> pointer2 = Optional.of(head);

        /* Move pointer1 exactly k elements ahead */
        for (int i = 0; i < k; i++) {
            /* Advances the pointer while also checking for the end of the list - throws NoSuchElementException */
            pointer1 = Optional.ofNullable(pointer1.get().next);
        }

        /* Move both pointers at the same pace, when pointer1 reaches the end, pointer2 is k elements from it */
        while (pointer1.get().next != null) {
            pointer1 = Optional.of(pointer1.get().next);
            pointer2 = Optional.of(pointer2.get().next);
        }

        return pointer2.get();
    }


    public static void main(String[] args) {
        int[] nodeData = {5, 6, 7, 8, 9, 10, 11, 12};
        int k = -1;

        Node head = new Node(nodeData[0]);
        Node node = head;

        for (int i = 1; i < nodeData.length; i++) {
            Node newNode = new Node(nodeData[i]);
            node.next = newNode;
            node = node.next;
        }

        Node result = kthElement(head, k);
        if (result != null) System.out.println(result.data);
    }
}
