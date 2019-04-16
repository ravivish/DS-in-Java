package CN;

/*
*
* Given an integer array A of size N, check if the input array can be splitted in two parts such that -
    - Sum of both parts is equal
    - All elements in the input, which are divisible by 5 should be in same group.
    - All elements in the input, which are divisible by 3 (but not divisible by 5) should be in other group.
    - Elements which are neither divisible by 5 nor by 3, can be put in any group.

*   Groups can be made with any set of elements,
    i.e. elements need not to be continuous.
    And you need to consider each and every element of input array in some group.

*   Return true, if array can be split according to the above rules,
*   else return false.
* */
public class SplitArray_Test1 {

    public static boolean splitArray(int input[]) {
        /* Your class should be named solution
         * Don't write main().
         * Don't read input, it is passed as function argument.
         * Return output and don't print it.
         * Taking input and printing output is handled automatically.
         */

            if (input.length == 0) {
                return false;
            }
            int count = 0, count1 = 0, count2 = 0;

            for (int i = 0; i < input.length; i++) {
                if (input[i] % 3 == 0 && input[i] % 5 != 0) {
                    count+=input[i];
                    System.out.println("count : "+count);
                }
                else if (input[i] % 5 == 0) {
                    count1+=input[i];
                    System.out.println("count1 : "+count1);
                }
//                else {
//                    count2++;
//                }
            }
            if (count1  == count)
                return true;
            return false;
    }

    public static void main(String[] args) {

        int[] in = {1, 4, 3};
        System.out.println(splitArray(in));
    }
}
