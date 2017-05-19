package Q2KthToLastElement;

public class KthToLastElement {

    public static Node kthElement(Node head, int k) {
        if (k < 0) return null;         // Elements with a negative number of elements from the end are undefined

        /* Keep track of two pointers */
        Node pointer1 = head;
        Node pointer2 = head;

        /* Move pointer1 exactly k elements ahead */
        for (int i = 0; i < k; i++) {
            if (pointer1.next == null) return null;    // Check if k is not larger than the number of elements in the list - 1
            pointer1 = pointer1.next;
        }

        /* Move both pointers at the same pace, when pointer1 reaches the end, pointer2 is k elements from it */
        while (pointer1.next != null) {
            pointer1 = pointer1.next;
            pointer2 = pointer2.next;
        }

        return pointer2;
    }


    public static void main(String[] args) {
        int[] nodeData = {5, 6, 7, 8, 9, 10, 11, 12};
        int k = 3;

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
