package CN;

public class SumofDigit {


    public static int sumOfDigits(int input) {
        // Write your code here
        if (input <= 0)
            return 0;
        int n = input % 10;
        return n + sumOfDigits(input / 10);

    }

    public static void main(String[] args) {
        int n = 1234;
        int m = sumOfDigits(n);
        System.out.println(m);
    }
}
