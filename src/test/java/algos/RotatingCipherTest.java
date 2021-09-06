package algos;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RotatingCipherTest {

    @Test
    void testSimple() {
        String toChange = "abc1-";
        assertEquals("bcd2-", RotatingCipher.rotationalCipher(toChange, 1));
    }
}
