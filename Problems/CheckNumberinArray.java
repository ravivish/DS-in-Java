package CN;

public class CheckNumberinArray {

    public static boolean checkNumber(int input[], int x) {

        if (input.length <= 0) {
            return false;
        }

        if (input[0] == x) {
            return true;
        }

        int smallInput[] = new int[input.length - 1];
        for (int i = 1; i < input.length; i++) {
            smallInput[i - 1] = input[i];
        }
        boolean smallAns = checkNumber(smallInput, x);
        return smallAns;
    }

    public static void main(String[] args) {
        int arr[] = {9, 8, 10};
        int n = 8;
        boolean status = checkNumber(arr, n);
        System.out.println(status);
    }
}
