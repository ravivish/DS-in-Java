package CN;

public class AllIndicesOfNumber {
    private static int allIndexes(int input[], int startIndex, int lastIndex, int x, int arr[]) {

        if (startIndex >= lastIndex ) {
            return -1;
        }  if (input[startIndex] == x) {
            arr[startIndex] = x;
        }  if (x == input[lastIndex]) {
            arr[lastIndex] = x;
        }
        return allIndexes(input, startIndex + 1, lastIndex - 1, x, arr);
    }

    public static int[] allIndexes(int input[], int x) {
        int arr[] = new int[input.length];
        allIndexes(input, 0, input.length - 1, x, arr);
        int count=0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == x) {
                count++;
            }
        }
        int arr1[]=new int[count];
        int count1=0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == x) {
                arr1[count1]=i;
                count1++;
            }
        }
        return arr1;
    }

    public static void main(String[] args) {
        int arr[] = {9, 8, 10, 8};
        int n = 8;
        int m[] = allIndexes(arr, n);
        for (int i = 0; i < m.length; i++) {
            System.out.println(m[i]);
        }
    }
}
