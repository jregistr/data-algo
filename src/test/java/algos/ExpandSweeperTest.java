package algos;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.Arrays;

public class ExpandSweeperTest {
    int[][] field1 = null;
    int[][] field2 = null;

    @BeforeEach
    void setUp() {
        // field of 3, 5
        field1 = new int[][]{
                new int[]{0, 0, 0, 0, 0},
                new int[]{0, 1, 1, 1, 0},
                new int[]{0, 1, -1, 1, 0}
        };

        //field of 4, 4
        field2 = new int[][]{
                new int[]{-1, 1, 0, 0},
                new int[]{1, 1, 0, 0},
                new int[]{0, 0, 1, 1},
                new int[]{0, 0, 1, -1}
        };
    }

    @Test
    void testField1ClickRow2Col2() {
        // click 2,2 which has a bomb, so do nothing
        int[][] expected = new int[][]{
                new int[]{0, 0, 0, 0, 0},
                new int[]{0, 1, 1, 1, 0},
                new int[]{0, 1, -1, 1, 0}
        };

        assertTrue(Arrays.deepEquals(
                ExpandSweeper.click(field1, 3, 5, 2, 2),
                expected
        ));
    }

    @Test
    void testField1ClickRow1Col4() {
        // click 2,2 which has a bomb, so do nothing
        int[][] expected = new int[][]{
                new int[]{-2, -2, -2, -2, -2},
                new int[]{-2, 1, 1, 1, -2},
                new int[]{-2, 1, -1, 1, -2}
        };

        int[][] result = ExpandSweeper.click(field1, 3, 5, 1, 4);
        assertTrue(Arrays.deepEquals(result, expected));
    }

    @Test
    void testField2ClickRow0Col1() {
        // click 2,2 which has a bomb, so do nothing
        int[][] expected = new int[][]{
                new int[]{-1, 1, 0, 0},
                new int[]{1, 1, 0, 0},
                new int[]{0, 0, 1, 1},
                new int[]{0, 0, 1, -1}
        };

        int[][] result = ExpandSweeper.click(field2, 4, 4, 0, 1);
        assertTrue(Arrays.deepEquals(result, expected));
    }

    @Test
    void testField2ClickRow1Col3() {
        // click 2,2 which has a bomb, so do nothing
        int[][] expected = new int[][]{
                new int[]{-1, 1, -2, -2},
                new int[]{1, 1, -2, -2},
                new int[]{-2, -2, 1, 1},
                new int[]{-2, -2, 1, -1}
        };

        int[][] result = ExpandSweeper.click(field2, 4, 4, 1, 3);
        assertTrue(Arrays.deepEquals(result, expected));
    }
}
