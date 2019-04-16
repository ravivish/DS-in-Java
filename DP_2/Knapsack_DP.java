package DP_2;

public class Knapsack_DP {

    /*
    * Both approach are the same
    * */

    public static int knapsacK(int[] weight,int[] value,int maxweight){

        int[][] temp = new int[weight.length+1][maxweight+1];

        for (int row = 0; row <= weight.length; row++) {
            for (int col = 0; col <= maxweight; col++) {

                //Represent 0 item OR Sack with capacity 0
                if(row==0 || col==0){
                    continue;
                }

                //If col represent Sack weight and if it is >= item weight,
                //it means item is eligible to be picked.
                if(col >= weight[row-1]){

                    //Checking picking the item will give Max profit or not picking the item will give Max profit.
                    temp[row][col] = Math.max(value[row-1]+temp[row-1][col-weight[row-1]], temp[row-1][col]);
                }else{

                    //Sack weight is less than item weight, So can't pick item and Max profit we
                    //can get at this point is profit we got in previous step by not picking current item
                    temp[row][col] = temp[row-1][col];
                }
            }
        }
        return temp[weight.length][maxweight];

    }
    public static int knapsack(int[] weight,int[] value,int maxweight){

        int[][] dp = new int[weight.length][maxweight + 1];
        dp[0][0] = 0;
        for(int i = 1 ; i < dp[0].length; i++){
            if(weight[0] <= i){
                dp[0][i] = value[0];
            }else{
                dp[0][i] = 0;
            }
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                // if a weight is more than the allowed weight, that weight cannot be picked.
                if(weight[i] > j){
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], value[i] + dp[i-1][j-weight[i]]);
                }
            }
        }
        return dp[dp.length-1][maxweight];
    }

    public static void main(String[] args) {

        int arr1[]={1,2,4,5};
        int arr2[]={5,4,8,6};
        System.out.println(knapsack(arr1,arr2,5));

    }
}
