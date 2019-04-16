package DP_2;

public class Matrix_Chain_Multiplication {

    /*
    * DP Approach
    * */

    public static int mcmDP(int[] p){

        /* For simplicity of the program, one extra row and one
        extra column are allocated in m[][].  0th row and 0th
        column of m[][] are not used */

        int length=p.length;
        int arr[][] = new int[length][length];
        int m,j, k, q;

        /* m[i,j] = Minimum number of scalar multiplications needed
        to compute the matrix A[i]A[i+1]...A[j] = A[i..j] where
        dimension of A[i] is p[i-1] x p[i] */

        // cost is zero when multiplying one matrix.
        for ( m = 1; m < length; m++)
            arr[m][m] = 0;

        // L is chain length.
        for (int L=2; L<length; L++)
        {
            for (m=1; m<length-L+1; m++)
            {
                j = m+L-1;
                if(j == length) continue;
                arr[m][j] = Integer.MAX_VALUE;
                for (k=m; k<=j-1; k++)
                {
                    // q = cost/scalar multiplications
                    q = arr[m][k] + arr[k+1][j] + p[m-1]*p[k]*p[j];
                    if (q < arr[m][j])
                        arr[m][j] = q;
                }
            }
        }

        return arr[1][length-1];
    }




    /*
    * Recursive Approach
    *
    * */
    private static int mcmHelper(int[] p,int i,int j){

        if (i == j)
            return 0;

        int min = Integer.MAX_VALUE;

        // place parenthesis at different places between first
        // and last matrix, recursively calculate count of
        // multiplications for each parenthesis placement and
        // return the minimum count
        for (int k=i; k<j; k++)
        {
            int count = mcmHelper(p, i, k) +
                    mcmHelper(p, k+1, j) +
                    p[i-1]*p[k]*p[j];

            if (count < min)
                min = count;
        }

        // Return minimum count
        return min;

    }

    public static int mcm(int[] p) {

        int ans = mcmHelper(p, 1, p.length - 1);
        return ans;

    }

    public static void main(String[] args) {
        int []arr={10,15,20,25};
        System.out.println(mcmDP(arr));
    }

}
