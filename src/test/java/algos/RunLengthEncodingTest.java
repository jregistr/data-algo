package algos;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RunLengthEncodingTest {

    @Test
    void simpleTest() {
        assertEquals("4A2B", RunLengthEncoding.runLengthEncoding("AAAABB"));
    }

    @Test
    void testLongerThan9Seq() {
        String test = "AAAAAAAAAAABBBCDD";
        String expected = "9A2A3B1C2D";
        assertEquals(expected, RunLengthEncoding.runLengthEncoding(test));
    }
}
