package CN;

public class SumOfArrays {

    public static int sum(int input[]) {
        if (input.length <= 1) {
            return input[0];
        }

        int smallInput[] = new int[input.length - 1];
        for (int i = 1; i < input.length; i++) {
            smallInput[i - 1] = input[i];
        }
        int s = input[(input.length - smallInput.length) - 1];
        return s + sum(smallInput);
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 5, 6};
        int ans = sum(arr);
        System.out.println(ans);
    }
}
