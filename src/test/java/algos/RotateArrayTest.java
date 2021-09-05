package algos;

import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import java.util.Arrays;

public class RotateArrayTest {

    int[][] a1 = null;
    int[][] a2 = null;

    @BeforeEach
    void setUp() {
        a1 = new int[][]{
                new int[]{1, 2, 3},
                new int[]{4, 5, 6},
                new int[]{7, 8, 9}
        };
        a2 = new int[][]{
                new int[]{1, 2, 3, 4},
                new int[]{5, 6, 7, 8},
                new int[]{9, 10, 11, 12},
                new int[]{13, 14, 15, 16}
        };
    }

    @Test
    void testRotateA1() {
        int[][] expected = new int[][]{
                new int[]{7, 4, 1},
                new int[]{8, 5, 2},
                new int[]{9, 6, 3}
        };

        assertTrue(Arrays.deepEquals(
                RotateArray.rotate(a1, 3),
                expected
        ));
    }

    @Test
    void testRotateA1InPlace() {
        int[][] expected = new int[][]{
                new int[]{7, 4, 1},
                new int[]{8, 5, 2},
                new int[]{9, 6, 3}
        };
        assertTrue(Arrays.deepEquals(
                RotateArray.rotateInPlace(a1, 3),
                expected
        ));
    }

    @Test
    void testRotateA2() {
        int[][] expected = new int[][]{
                new int[]{13, 9, 5, 1},
                new int[]{14, 10, 6, 2},
                new int[]{15, 11, 7, 3},
                new int[]{16, 12, 8, 4}
        };
        assertTrue(Arrays.deepEquals(
                RotateArray.rotate(a2, 4),
                expected
        ));
    }

    @Test
    void testRotateA2InPlace() {
        int[][] expected = new int[][]{
                new int[]{13, 9, 5, 1},
                new int[]{14, 10, 6, 2},
                new int[]{15, 11, 7, 3},
                new int[]{16, 12, 8, 4}
        };

        int[][] result = RotateArray.rotateInPlace(a2, 4);
        assertTrue(Arrays.deepEquals(result, expected));
    }
}
