package CN;

public class Merge_Sort {

    private static void merge(int[] array,int lowerIndex, int middle, int higherIndex) {
        int[] tempMergArr=new int[array.length];
        for (int i = lowerIndex; i <= higherIndex; i++) {
            tempMergArr[i] = array[i];
        }
        int i = lowerIndex;
        int j = middle + 1;
        int k = lowerIndex;
        while (i <= middle && j <= higherIndex) {
            if (tempMergArr[i] <= tempMergArr[j]) {
                array[k] = tempMergArr[i];
                i++;
            } else {
                array[k] = tempMergArr[j];
                j++;
            }
            k++;
        }
        while (i <= middle) {
            array[k] = tempMergArr[i];
            k++;
            i++;
        }

    }


    private static void mergeSort(int[] input,int lowerIndex, int higherIndex) {

        if (lowerIndex < higherIndex) {
            int middle = lowerIndex + (higherIndex - lowerIndex) / 2;
            mergeSort(input,lowerIndex, middle);
            mergeSort(input,middle + 1, higherIndex);
            merge(input,lowerIndex, middle, higherIndex);
        }
    }
    public static void mergeSort(int[] input){
        // Write your code here

        mergeSort(input,0,input.length-1);
    }
    public static void main(String[] args) {

        int[] inputArr = {45,23,11,89,77,98,4,28,65,43};
        mergeSort(inputArr);
        for (int i:inputArr) {
            System.out.print(i);
            System.out.print(" ");
        }

    }
}
