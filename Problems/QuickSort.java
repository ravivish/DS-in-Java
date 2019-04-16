package CN;

public class QuickSort {

    private static void swap(int[] arr,int si,int ei){
        int temp = arr[si];
        arr[si] = arr[ei];
        arr[ei] = temp;
     }

    public static void quickSort(int[] input, int l, int h) {

        int i = l;
        int j = h;
        int pivot = input[l + (h - l) / 2];
        while (i < j) {

            while (input[i]<pivot){
                i++;
            }
            while (input[j]>pivot){
                j--;
            }
            if (i<=j){
                swap(input,i,j);
                i++;
                j--;
            }

        }
        if (l < j)
            quickSort(input,l,j);
        if (i < h)
            quickSort(input,i,h);

    }

    public static void quickSort(int[] input) {
        /* Your class should be named Solution
         * Don't write main().
         * Don't read input, it is passed as function argument.
         * No need to print or return the output.
         * Taking input and printing output is handled automatically.
         */
        if (input.length <= 0) {
            return;
        }
        quickSort(input, 0, input.length - 1);

    }

    public static void main(String[] args) {
        int[] input = {24, 2, 45, 20, 56, 75, 2, 56, 99, 53, 12};
        quickSort(input);
        for (int i : input) {
            System.out.print(i+" ");
//            System.out.print(" ");
        }
    }
}
