package algos;

import algos.ReverseOps.Node;
import org.junit.jupiter.api.Test;

public class ReverseOpsTest {

    void printLinkedList(Node head) {
        System.out.print("");
        while (head != null) {
            System.out.print(head.data);
            head = head.next;
            if (head != null)
                System.out.print(" --> ");
            if(head == null)
                System.out.print(" --> null");
        }
        System.out.print("");
        System.out.println();
    }

    Node createLinkedList(int[] arr) {
        Node head = null;
        Node tempHead = head;
        for (int v : arr) {
            if (head == null) {
                head = new Node(v);
                tempHead = head;
            } else {
                head.next = new Node(v);
                head = head.next;
            }
        }
        return tempHead;
    }

    @Test
    void testing() {
        int[] arr = {1, 2, 8, 9, 12, 16};
        Node head = createLinkedList(arr);
        printLinkedList(head);
        System.out.println("-----------------");
        ReverseOps.reverse(head);
//        printLinkedList(ReverseOps.reverse(head));
    }
}
