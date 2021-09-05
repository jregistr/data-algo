package algos;

public class RotateArray {

    public static int[][] rotate(int[][] a, int n) {
        int[][] rotated = new int[n][n];
        for(int i = 0; i < n; i ++) {
            int column = n - i - 1;
            for(int j = 0; j < n; j ++) {
                rotated[j][column] = a[i][j];
            }
        }
        return rotated;
    }

    public static int[][] rotateInPlace(int[][] a, int n) {
        transposeMatrix(a, n);
        reverseColumnOrder(a, n);
        return a;
    }

    private static void transposeMatrix(int[][] a, int n) {
        for(int i = 0; i < n; i ++) {
            for(int j = i; j < n; j ++) {

                int temp = a[i][j];
                a[i][j] = a[j][i];
                a[j][i] = temp;
            }
        }
    }

    private static void reverseColumnOrder(int[][] a, int n) {
        int halfN = n / 2;
        for(int i = 0; i < n; i ++) {
            for(int j = 0; j < halfN; j ++) {
                int col = n - j - 1;
                int temp = a[i][j];
                a[i][j] = a[i][col];
                a[i][col] = temp;
            }
        }
    }
}
