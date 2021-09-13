package algos;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class CommonElementsTest {

    @Test
    void testExpectedValues() {
        char[] bla = new char[10];
        System.out.println((int)bla[0]);
        System.out.println(Arrays.toString(bla));
        assertArrayEquals(CommonElements.commonElements(
                new int[]{1, 3, 4, 6, 7, 9},
                new int[]{1, 2, 4, 5, 9, 10}
        ), new Integer[]{1, 4, 9});
    }

    @Test
    void checkDiffSizeArrs() {
        assertArrayEquals(CommonElements.commonElements(
                new int[]{1, 2, 9, 10, 11, 12},
                new int[]{0, 1, 2, 3, 4, 5, 8, 9, 10, 12, 14, 15}
        ), new Integer[]{1, 2, 9, 10, 12});
    }

    @Test
    void withNegatives() {
        assertArrayEquals(CommonElements.commonElements(
                new int[]{-2, 0, 1, 2, 4, 6},
                new int[]{1, 2, 3, 5, 6}
        ), new Integer[]{1, 2, 6});
    }

    @Test
    void checkEmptyArrays() {
        assertArrayEquals(CommonElements.commonElements(
                new int[]{-2, 0, 1, 2, 4, 6},
                new int[]{}
        ), new Integer[]{});

        assertArrayEquals(CommonElements.commonElements(
                new int[]{},
                new int[]{-2, 0, 1, 2, 4, 6}
        ), new Integer[]{});
    }
}
