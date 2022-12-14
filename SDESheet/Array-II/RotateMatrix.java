package ArrayI;

public class RotateMatrix {
    public static void main(String[] args) {
        int[][] mat = new int[][]{{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        printMatrix(mat);
        //setZeroes(mat);
        printMatrix(mat);
    }

    public static void RotateMatrix(int[][] matrix) {
        
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
