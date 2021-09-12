package algos;

public class ReverseOps {

   public static class Node {
        int data;
        Node next;
        Node(int x) {
            data = x;
            next = null;
        }
    }

    public static Node reverse(Node head) {
        // Write your code here
        Node leftOdd = head;
        Node rightOddOrNull = null;
        while(leftOdd != null && isNotOdd(leftOdd)) {
            leftOdd = leftOdd.next;
        }

        if(leftOdd == null) return head;
        rightOddOrNull = leftOdd.next;
        while(rightOddOrNull != null && isNotOdd(rightOddOrNull)) {
            rightOddOrNull = rightOddOrNull.next;
        }



        Node previous = leftOdd.next;
        Node current = previous.next;
        while (current.data != 9) {
            System.out.println(current.data);
            Node nextNode = current.next;
            current.next = previous;
            previous = current;
            current = nextNode;
        }

        leftOdd.next = previous;
        if(rightOddOrNull != null) {
            rightOddOrNull.next = previous;
        }

        return head;
    }

    public static boolean isNotOdd(Node node) {
       return (node.data & 1) != 1;
    }
}
