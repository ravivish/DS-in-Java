package CN;

public class LastIndexOfNumber {
    private static int firstIndex(int input[], int startIndex, int x) {

        if(startIndex<0){
            return -1;
        }
        if (x == input[startIndex]) {
            return startIndex;
        }
        return firstIndex(input, startIndex - 1, x);

    }

    public static int firstIndex(int input[], int x) {

        return firstIndex(input, input.length - 1, x);

    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5, 3, 4, 6, 4, 3, 4};
        int n = 4;
        int m = firstIndex(arr, n);
        System.out.println(m);

    }
}
