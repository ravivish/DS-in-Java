package DP_1;

public class Number_Of_BalancedBT {

    public static int balancedTreesOfHeightH(int height) {

        int mod=(int)Math.pow(10,9)+7;
        return balancedTreesOfHeightH(height,mod);
    }

    public static int balancedTreesOfHeightH(int height,int mod){

        if (height == 0 || height == 1) {
            return 1;
        }

        int x = balancedTreesOfHeightH(height - 1);
        int y = balancedTreesOfHeightH(height - 2);

        long res1=(long)x*x;
        long res2=(long)2*x*y;
        int value1=(int)(res1%mod);
        int value2=(int)(res2%mod);

        return (value1+value2)%mod;

    }

    public static void main(String[] args) {
        int h=4;
        System.out.println(balancedTreesOfHeightH(h));


    }
}
