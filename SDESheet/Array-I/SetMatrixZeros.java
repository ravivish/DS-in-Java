package Array-I;

public class SetMatrixZeros {
    public static void main(String[] args) {
        int[][] mat = new int[][]{{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        printMatrix(mat);
        setZeroes(mat);
        printMatrix(mat);
    }

    public static void setZeroes(int[][] matrix) {
        int rows = matrix.length, cols = matrix[0].length;
        int col0 = 1;
        for (int i = 0; i < rows; i++) {
            if (matrix[i][0] == 0) col0 = 0;
            for (int j = 1; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = matrix[j][0] = 0;
                }
            }
        }
        for (int i = rows - 1; i >= 0; i--) {
            for (int j = cols - 1; j >= 1; j--) {
                if (matrix[i][0] == 0 || matrix[j][0] == 0) {
                    matrix[i][j] = 0;
                }
            }
            if (col0 == 0) matrix[i][0] = 0;
        }
    }

    private static void printMatrix(int[][] mat) {
        for (int[] ints : mat) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }


}
