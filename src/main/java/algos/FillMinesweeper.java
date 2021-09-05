package algos;

public class FillMinesweeper {
    public static int[][] mineSweeper(int[][] bombs, int numRows, int numCols) {
        int[][] field = new int[numRows][numCols];
        fillBombs(bombs, field);
        for(int[] bomb : bombs) {
            int row = bomb[0];
            int col = bomb[1];
            for(int i = row - 1; i <= row + 1; i ++) {
                for(int j = col - 1; j <= col + 1; j++) {
                    if(inBound(i, j, numRows, numCols) && field[i][j] != -1) {
                        field[i][j] ++;
                    }
                }
            }
        }
        return field;
    }

    private static boolean inBound(int row, int col, int numRows, int numCols) {
        if(row < 0 || col < 0) return false;
        return row < numRows && col < numCols;
    }

    private static void fillBombs(int[][] bombs, int[][] field) {
        for(int[] bomb : bombs) {
            int row = bomb[0];
            int col = bomb[1];
            field[row][col] = -1;
        }
    }
}
