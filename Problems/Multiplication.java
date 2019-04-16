package CN;

public class Multiplication {

    public static int multiplyTwoIntegers(int m, int n) {
        // Write your code here
        if (n== 0)
            return 0;
        if (n>0)
            return m+multiplyTwoIntegers(m,n-1);
        if (n<0)
            return multiplyTwoIntegers(m,-n);
        return -1;

    }

    public static void main(String[] args) {
        int m = 3, n = 5;
        int result = multiplyTwoIntegers(m, n);
        System.out.println(result);
    }
}
