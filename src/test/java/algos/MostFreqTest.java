package algos;

import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class MostFreqTest {

    private MostFreq solution;

    @BeforeEach
    void setUp() {
        solution = new MostFreq();
    }

    @Test
    void validResults() {
        assertEquals(solution.mostFreq(new int[]{1, 3, 1, 3, 2, 1}), 1);
        assertEquals(solution.mostFreq(new int[]{0, -1, 10, 10, -1, 10, -1, -1, -1, 1}), -1);
    }
}
