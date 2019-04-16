package CN;

public class BinarySearch_Recursive {
    private static int binarySearch(int input[],int l,int h, int element) {

        if (l == h) {

            if(input[l] == element)
                return l;
            else
                return -1;
        }
        else {
            int mid = (l+h)/2;
            if (input[mid] == element)
                return mid;
            if ( element < input[mid])
                return binarySearch(input, l ,mid-1 ,element);
            else
                return binarySearch(input, mid+1, h, element);
        }
    }
    public static int binarySearch(int input[], int element) {
        // Write your code here
        int ans=binarySearch(input, 0 , input.length-1 ,element);
        return ans;

    }

    public static void main(String[] args) {
        int []ints={1,2,5,6,9};
        System.out.println(binarySearch(ints,6));
    }
}
