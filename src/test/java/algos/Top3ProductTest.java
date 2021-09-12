package algos;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;


public class Top3ProductTest {

    @Test
    void test1() {
        int[] arr = {1, 2, 3, 4, 5};
        int[] expected = {-1, -1, 6, 24, 60};

        assertArrayEquals(expected, Top3Product.findMaxProduct(arr));
    }
}
