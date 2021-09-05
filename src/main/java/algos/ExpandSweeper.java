package algos;

import java.util.*;

public class ExpandSweeper {

    public static int[][] click(int[][] field, int numRows, int numCols, int givenI, int givenJ) {
        Queue<Integer[]> queue = new ArrayDeque<>();
        queue.offer(new Integer[]{givenI, givenJ});

        while (queue.peek() != null) {
            Integer[] pos = queue.poll();
            int row = pos[0];
            int col = pos[1];
            if (field[row][col] == 0) {
                field[row][col] = -2;

                for (int i = row - 1; i <= row + 1; i++) {
                    for (int j = col - 1; j < col + 1; j++) {
                        if (inBound(i, j, numRows, numCols) && field[i][j] == 0) {
                            queue.offer(new Integer[]{i, j});
                        }
                    }
                }
            }
        }

        return field;
    }

    private static boolean inBound(int row, int col, int numRows, int numCols) {
        if (row < 0 || col < 0) return false;
        return row < numRows && col < numCols;
    }
}
