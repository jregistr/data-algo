package algos;

import java.util.Objects;

public class NthFromEnd {
    public static class Node {
        int value;
        Node child;

        Node(int value, Node child) {
            this.value = value;
            this.child = child;
        }

        // The string representation of this node.
        // Will be used for testing.
        @Override
        public String toString() {
            return String.valueOf(value);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return value == node.value;
        }

        @Override
        public int hashCode() {
            return Objects.hash(value);
        }
    }

    public static Node nthFromLast(Node head, int n) {
        if(head == null) return null;
        Node leftP = head;
        Node rightP = head;

        for(int i = 0; i < n; i ++) {
            if(rightP == null) return null;
            rightP = rightP.child;
        }

        while(rightP != null) {
            rightP = rightP.child;
            leftP = leftP.child;
        }

        return leftP;
    }

    private static Node travelByN(Node head, int n) {
        Node pointer = head;
        for(int i = 0; i < n && pointer != null; i ++) {
            pointer = pointer.child;
        }
        return pointer;
    }
}
