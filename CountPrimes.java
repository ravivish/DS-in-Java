

public class CountPrimes {

    public static int countPrimes(int n) {
        int count = 0,flag;
        for (int j = 2; j <= n; j++) {
             flag = 0;
            for (int i = 2; i <= Math.sqrt(j); i++) {
//                System.out.println("Checking for Prime: " + j);
                if (j % i == 0) {
                    flag = 1;
                    break;
                }
            }
            if (flag == 0) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {

        System.out.println(countPrimes(1500000));
    }
}
