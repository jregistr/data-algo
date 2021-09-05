package algos;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class NonRepeatingTest {

    @Test
    void testExpectedResults() {
        assertEquals( 'c', NonRepeating.nonRepeating("abcab"));
    }
}
