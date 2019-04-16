package CN;

import java.util.Arrays;

public class Triplet {


    public static void FindTriplet(int[] arr, int x) {
        /* Your class should be named TripletSum.
         * Don't write main().
         * Don't read input, it is passed as function argument.
         * Print output and don't return it.
         * Taking input is handled automatically.
         */
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int c = x - (arr[i] + arr[j]);
                for (int k = j + 1; k < arr.length; k++) {
                    if (arr[k] == c)
                        System.out.println(arr[i] + " " + arr[j] + " " + c);
                }
            }

        }
    }

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        FindTriplet(arr, 12);

    }
}
