package CN;

public class FirstIndexOfNumber {
    private static int firstIndex(int input[], int startIndex, int x) {

        if (startIndex >= input.length - 1) {
            return -1;
        } else if (x == input[startIndex]) {
            return startIndex;
        }
        else
        return firstIndex(input, startIndex + 1, x);

    }

    public static int firstIndex(int input[], int x) {

        return firstIndex(input, 0, x);

    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 3};
        int n =4 ;
        int m = firstIndex(arr, n);
        System.out.println(m);

    }
}
