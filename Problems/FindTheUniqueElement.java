package CN;

import java.util.Arrays;

public class FindTheUniqueElement {



    public static int findUnique(int[] arr) {
        /* Your class should be named FindUnique
         * Don't write main().
         * Don't read input, it is passed as function argument.
         * Return output and don't print it.
         * Taking input and printing output is handled automatically.
         */
        Arrays.sort(arr);
        int ans=0;
        for (int i=0;i<arr.length;i++) {
            ans^=arr[i];
        }
        return ans;

    }

    public static void main(String[] args) {
        int arr1[]={2,3,1,6,3,6,2,1};
        System.out.println(findUnique(arr1));
    }
}
