package CN;

import java.util.Arrays;

public class Rotate {

    public static void rotate(int[] arr, int d) {
        /* Your class should be named ArrayRotate
         * Don't write main().
         * Don't read input, it is passed as function argument.
         * No need to print or return the output.
         * Taking input and printing the output is handled automatically.
         */
        System.out.println("Original Array : "+Arrays.toString(arr));
        int[] temp=new int[d];
        for (int i = 0; i < d; i++) {
            temp[i]=arr[i];
        }
        for (int i = d; i < arr.length; i++) {
            arr[i-d]=arr[i];
        }
        for (int i = 0; i < temp.length; i++) {
            arr[arr.length-d]=temp[i];
            d--;
        }
        System.out.println("Rotated Array :  "+Arrays.toString(arr));

    }

    public static void main(String[] args) {
        int[] arr={1 ,2 ,3 ,4 ,5 ,6,7 };
        rotate(arr,2);

    }
}
