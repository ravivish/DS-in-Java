package CN;

public class Check_Array_Rotation {

    public static int arrayRotateCheck(int[] arr){
        /* Your class should be named CheckRotation
         * Don't write main().
         * Don't read input, it is passed as function argument.
         * Return output and don't print it.
         * Taking input and printing output is handled automatically.
         */
        int min = arr[0], min_index = 0;
        for (int i = 0; i < arr.length; i++)
        {
            if (min > arr[i])
            {
                min = arr[i];
                min_index = i;
            }
        }
        return min_index;
    }

    public static void main(String[] args) {
        int[] arr={3 ,6, 8 ,9, 10};
        System.out.println(arrayRotateCheck(arr));
    }
}
