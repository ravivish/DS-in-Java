package CN;

public class CheckSortedArray {

    public static boolean checkSorted(int input[]) {
        if (input.length <= 1) {
            return true;
        }
        if (input[0] > input[1]) {
            return false;
        }
        int smallInput[] = new int[input.length - 1];
        for (int i = 1; i < input.length; i++) {
            smallInput[i - 1] = input[i];
        }

        boolean smallAns = checkSorted(smallInput);
        return smallAns;
    }

    public static boolean checkSorted_2(int input[]) {
        if (input.length <= 1) {
            return true;
        }
        int smallInput[] = new int[input.length - 1];
        for (int i = 1; i < input.length; i++) {
            smallInput[i - 1] = input[i];
        }


        boolean smallAns = checkSorted(smallInput);

        if(!smallAns){
            return false;
        }
        if (input[0] <= input[1]) {
            return true;
        }
        else {
            return false;
        }
    }
    private static boolean checkSorted_3(int input[],int startIndex){

        if(startIndex == input.length-1){
            return true;
        }
        if(input[startIndex]>=input[startIndex+1]){
            return false;
        }
        boolean smallAns=checkSorted_3(input,startIndex+1);
        return smallAns;

    }
    public static boolean checkSorted_3(int input[]) {

        return checkSorted_3(input,0);

    }

        public static void main(String[] args) {
        System.out.println("Checking the array is sorted or not using recursion: ");
        int arr[] = {2, 1, 4, 5, 6};
        boolean status = checkSorted(arr);
        System.out.println("First Function(checkSorted) : "+status);
        int arr1[]={1,2,3,4};
        boolean ans=checkSorted_2(arr1);
        System.out.println("Second Function(checkSorted) : "+ans);
        int arr2[]={1,2,9,10};
        boolean ans1=checkSorted_3(arr2);
        System.out.println("Third and Better Function in terms of space complexity(checkSorted) : "+ans1);
    }
}
