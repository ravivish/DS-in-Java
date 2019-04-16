package CN;

public class Duplicate {
/*
* return one element which is repeated twice
* */
    public static int duplicate(int[] arr){
        /* Your class should be named DuplicateInArray
         * Don't write main().
         * Don't read input, it is passed as function argument.
         * Return output and don't print it.
         * Taking input and printing output is handled automatically.
         */
        int sum=0;
        for (int i=0;i<arr.length;i++){
            sum += arr[i];
        }
        int sum2 = ((arr.length-1)*(arr.length-2))/2;
        int duplicate = sum - sum2;
        return duplicate;

    }
    public static void main(String[] args) {
        int[] arr={0 ,7 ,2 ,5, 4, 1, 3, 6, 6};
        System.out.println(duplicate(arr));
    }
}
