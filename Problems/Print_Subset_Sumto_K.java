package CN;


import java.util.Arrays;

public class Print_Subset_Sumto_K {

    public static int[][] helper(int input[], int k, int index) {
        if (index == input.length) {
            if (k == 0) {
                int[][] res = new int[1][];
                res[0] = new int[0];
                return res;
            } else {
                int[][] res = new int[0][];
                return res;
            }
        }

        // do not include element in the sum
        int ans1[][] = helper(input, k, index + 1);

        // include in sum

        int ans2[][] = helper(input, k - input[index], index + 1);

        int finalresult[][] = new int[ans1.length + ans2.length][];

        int l = 0;

        // do not include vale ko as it is copy krdia


        for (int i = 0; i < ans1.length; i++) {
            finalresult[l] = ans1[i];
            l++;
        }


        // include vale me input[index] haar subset me daalenege

        for (int i = 0; i < ans2.length; i++) {
            finalresult[l] = new int[ans2[i].length + 1];
            finalresult[l][0] = input[index];

            for (int j = 0; j < ans2[i].length; j++) {
                finalresult[l][j + 1] = ans2[i][j];
            }

            l++;
        }


        return finalresult;


    }


    public static void printSubsetsSumTok(int input[], int k) {
        // Write your code here

        int[][] ans = helper(input, k, 0);
//        System.out.println(ans.length);
        for (int i = 0; i < ans.length; i++) {
            for (int j = i; j < ans[i].length; j++) {
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[] arr = {5, 12, 3, 17, 15};
        printSubsetsSumTok(arr, 20);
    }
}
