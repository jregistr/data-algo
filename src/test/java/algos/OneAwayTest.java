package algos;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class OneAwayTest {

    @Test
    void testOneAway() {
        assertTrue(OneAway.isOneAway("abcde", "abcd"));
        assertTrue(OneAway.isOneAway("abcd", "abcde"));
        assertTrue(OneAway.isOneAway("a", "a"));
        assertTrue(OneAway.isOneAway("abcdef", "abqdef"));
        assertTrue(OneAway.isOneAway("abcdef", "abccef"));
        assertTrue(OneAway.isOneAway("abcdef", "abcde"));
    }

    @Test
    void testNotOneAway() {
        assertFalse(OneAway.isOneAway("axcde", "abcd"));
        assertFalse(OneAway.isOneAway("abcde", "abc"));
        assertFalse(OneAway.isOneAway("abc", "abcde"));
        assertFalse(OneAway.isOneAway("abc", "bcc"));
    }
}
