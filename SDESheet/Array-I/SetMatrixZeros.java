package Array-I;

public class SetMatrixZeros {
    public static void main(String[] args) {
        int[][] mat = new int[][]{{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
        printMatrix(mat);
        System.out.println("=============");
        setZeroes(mat);
        printMatrix(mat);
    }

    public static void setZeroes(int[][] matrix) {
        int rows = matrix.length, cols = matrix[0].length;
        boolean col0 = false;
        for (int i = 0; i < rows; i++) {
            if (matrix[i][0] == 0) col0 = true;
            for (int j = 1; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }
        for (int i = rows - 1; i >= 0; i--) {
            for (int j = cols - 1; j >= 1; j--) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
            if (col0) matrix[i][0] = 0;
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
