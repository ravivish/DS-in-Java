package DP_1;

public class Minimum_Count_Of_Sequare {


    public static int minCount(int n) {
        if (n <= 3) {
            return n;
        }
// getMinSquares rest of the table using recursive
// formula
        int res = n; // Maximum squares required is
// n (1*1 + 1*1 + ..)

// Go through all smaller numbers
// to recursively find minimum
        for (int x = 1; x <= n; x++) {
            int temp = x * x;
            if (temp > n)
                break;
            else
                res = Math.min(res, 1 + minCount(n - temp));
        }
        return res;
    }


    public static void main(String[] args) {

        System.out.println(minCount(12));
    }
}
