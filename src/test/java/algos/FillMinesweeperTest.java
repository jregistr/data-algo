package algos;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.Arrays;

public class FillMinesweeperTest {

    @Test
    void checkInput1() {
        int[][] bombs = new int[][]{new int[]{0, 2}, new int[]{2, 0}};
        int nR = 3;
        int nC = 3;
        int[][] expected = new int[][]{
                new int[]{0, 1, -1},
                new int[]{1, 2, 1},
                new int[]{-1, 1, 0}
        };

        int[][] field = FillMinesweeper.mineSweeper(bombs, nR, nC);
        System.out.println(Arrays.deepToString(field));

        assertTrue(Arrays.deepEquals(
                expected,
                field
        ));
    }

    @Test
    void checkInput2() {
        int[][] bombs = new int[][]{
                new int[]{1, 1},
                new int[]{1, 2},
                new int[]{2, 2},
                new int[]{4, 3},
        };
        int nR = 5;
        int nC = 5;

        int[][] expected = new int[][]{
                new int[]{1, 2, 2, 1, 0},
                new int[]{1, -1, -1, 2, 0},
                new int[]{1, 3, -1, 2, 0},
                new int[]{0, 1, 2, 2, 1},
                new int[]{0, 0, 1, -1, 1}
        };

        int[][] field = FillMinesweeper.mineSweeper(bombs, nR, nC);
        assertTrue(Arrays.deepEquals(
                expected,
                field
        ));
    }
}
