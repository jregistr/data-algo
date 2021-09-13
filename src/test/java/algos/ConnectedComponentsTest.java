package algos;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConnectedComponentsTest {

    @Test
    void testExample() {
        //Input: n = 5, edges = [[0, 1], [1,2], [3, 4]]
        int n = 5;
        int[][] edges = {
                {0, 1},
                {1, 2},
                {3, 4}
        };
        int expected = 2;

        assertEquals(expected, ConnectedComponents.countComponent(n, edges));
    }
}
