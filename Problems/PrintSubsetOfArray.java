package CN;

public class PrintSubsetOfArray {


    private static void printSubsets(int[] input, boolean[] print, int start, int rem) {
        if (rem == 0) {
            for (int i = 0; i < print.length; i++) {
                if (print[i])
                    System.out.print(input[i] + " ");
            }
            System.out.println();
        } else {
            if (start+rem>input.length);
            for (int i = start; i < input.length; i++) {

                if (!print[i]){
                    print[i]=true;
                    printSubsets(input,print,i+1,rem-1);
                    print[i]=false;
                }
            }
        }
    }

    public static void printSubsets(int input[]) {
        // Write your code here
        for (int i = 0; i <= input.length; i++) {
            boolean print[] = new boolean[input.length];
            printSubsets(input, print, 0, i);
        }

    }

    public static void main(String[] args) {
        int[] input={15,20,10};
        printSubsets(input);
    }
}
