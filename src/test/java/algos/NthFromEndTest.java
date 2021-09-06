package algos;

import org.junit.jupiter.api.BeforeEach;
import algos.NthFromEnd.Node;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class NthFromEndTest {

    Node head;

    @BeforeEach
    void setUp() {
        head = new Node(1, null);
        for(int i = 2; i < 8; i ++) {
            head = new Node(i, head);
        }
    }

    @Test
    void testFor5thFromLast() {
        assertEquals(5, NthFromEnd.nthFromLast(head, 5).value);
    }
}
