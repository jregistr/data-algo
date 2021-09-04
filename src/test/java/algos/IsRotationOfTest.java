package algos;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class IsRotationOfTest {

    @Test
    void testFullArrays() {
        assertTrue(IsRotationOf.isRotationOf(
                new int[]{1, 2, 3, 4, 5, 6, 7},
                new int[]{4, 5, 6, 7, 1, 2, 3}
        ));

        assertTrue(IsRotationOf.isRotationOf(
                new int[]{1, 2, 3, 4, 5, 6, 7},
                new int[]{1, 2, 3, 4, 5, 6, 7}
        ));

        assertFalse(IsRotationOf.isRotationOf(
                new int[]{1, 2, 3, 4, 5, 6, 7},
                new int[]{4, 5, 6, 7, 8, 1, 2, 3}
        ));

        assertFalse(IsRotationOf.isRotationOf(
                new int[]{1, 2, 3, 4, 5, 6, 7},
                new int[]{4, 5, 6, 7, 8, 10, 2, 3}
        ));

        assertFalse(IsRotationOf.isRotationOf(
                new int[]{1, 2, 3, 4, 5, 6, 7},
                new int[]{4, 6, 5, 7, 1, 2, 3}
        ));
    }

    @Test
    void cornerCases() {
        //both empty
        assertTrue(IsRotationOf.isRotationOf(
                new int[]{},
                new int[]{}
        ));

        //different sizes
        assertFalse(IsRotationOf.isRotationOf(
                new int[]{12},
                new int[]{12, 14, 15}
        ));
    }

}
