package DP_2;

public class Min_Cast_Path_Recursive {


    public static int minCostPath(int[][] input) {

        return minCostPath(input, 0, 0);

    }

    private static int minCostPath(int[][] input, int i, int j) {

        int m = input.length;
        int n = input[0].length;
        if (i == m - 1 && j == n - 1) {
            return input[i][j];
        }
        if (i >= m || j >= n) {
            return Integer.MAX_VALUE;
        }

        int opt1 = minCostPath(input, i, j + 1);
        int opt2 = minCostPath(input, i + 1, j + 1);
        int opt3 = minCostPath(input, i+1, j );
        return input[i][j]+Math.min(opt1,Math.min(opt2,opt3));
    }

    public static void main(String[] args) {

        int[][] arr={{3,4,1,2},
                {2,1,8,9},
                {4,7,8,1}};

        System.out.println(minCostPath(arr));
    }
}
