import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MostFreqTests {

    private MostFreq mostFreq;

    @BeforeEach
    void setUp() {
        mostFreq = new MostFreq();
    }

    @Test
    void testTheExpected() {
        assertEquals(mostFreq.mostFreq(new int[]{1,2,1,3}), 1);
    }
}
