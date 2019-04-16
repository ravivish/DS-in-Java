package DP_1;

public class Min_Step_to_1 {


    public static int countStepsTo1(int n) {

        int count = 0;
        if (n <= 1) {
            return 0;
        }
        int op1 = countStepsTo1(n - 1);
        int minSteps = op1;
        if (n % 3 == 0) {

            int op2 = countStepsTo1(n / 3);
            if (op2 < minSteps) {
                minSteps = op2;
            }
        }

        if (n % 2 == 0) {
            int op3 = countStepsTo1(n / 2);
            if (op3 < minSteps) {
                minSteps = op3;
            }
        }

        return 1 + minSteps;

    }

    public static int countStepsTo1M(int n) {
        int storage[] = new int[n + 1];
        return countStepsTo1M(n, storage);
    }

    private static int countStepsTo1M(int n, int[] storage) {

        if (n == 1) {
            storage[n] = 0;
            return storage[n];
        }
        if (storage[n] != 0) {
            return storage[n];
        }

        int op1 = countStepsTo1M(n - 1, storage);
        int minSteps = op1;
        if (n % 3 == 0) {

            int op2 = countStepsTo1M(n / 3, storage);
            if (op2 < minSteps) {
                minSteps = op2;
            }
        }

        if (n % 2 == 0) {
            int op3 = countStepsTo1M(n / 2, storage);
            if (op3 < minSteps) {
                minSteps = op3;
            }
        }
        storage[n] = 1 + minSteps;
        return storage[n];

    }

    public static int countStepsTo1DP(int n) {

        int storage[] = new int[n + 1];
        storage[1] = 0;

        for (int i = 2; i <= n; i++) {

            int min = storage[i - 1];
            if (i % 3 == 0) {
                if (min > storage[i / 3]) {
                    min = storage[i / 3];
                }
            }
            if (i % 2 == 0) {
                if (min > storage[i / 2]) {
                    min = storage[i / 2];
                }
            }

            storage[i] = 1 + min;

        }
        return storage[n];

    }


    public static void main(String[] args) {

        System.out.println(countStepsTo1DP(1000));
        System.out.println(countStepsTo1M(1000));
        System.out.println(countStepsTo1(1000));


    }

}
