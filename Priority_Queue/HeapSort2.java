package Priority_Queue;


/*
 * heap sort using MaxHeap so it will be in ascending order
 * and the time complexity of heap sort is O(nlogn) and
 * space complexity is O(1)
 * */


public class HeapSort2 {

    private static void insertIntoVirtualHeap(int[] arr, int i) {
        int childIndex = i;
        int parentIndex = (childIndex - 1) / 2;
        while (childIndex > 0) {
            if (arr[childIndex] > arr[parentIndex]) {
                int temp = arr[childIndex];
                arr[childIndex] = arr[parentIndex];
                arr[parentIndex] = temp;
                childIndex = parentIndex;
                parentIndex = (childIndex - 1) / 2;

            } else {
                return;
            }
        }
    }


    public static void main(String[] args) {
        int[] arr = {-5,5, 1, 9, 2, 0, 6};
        for (int i = 0; i < arr.length; i++) {
            insertIntoVirtualHeap(arr, i);
        }
        for (int i = 0; i < arr.length; i++) {
            arr[arr.length - 1 - i] = removeFromVirtualHeap(arr, arr.length - i);
        }

        for (int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }

    }

    private static int removeFromVirtualHeap(int[] arr, int heapsize) {

        int temp = arr[0];
        arr[0] = arr[heapsize - 1];
        heapsize--;
        int index = 0;
        int leftChildIndex = 2 * index + 1;
        int rightChildIndex = 2 * index + 2;
        while (leftChildIndex < heapsize) {
            int minIndex = index;
            if (arr[leftChildIndex] > arr[minIndex]) {
                minIndex = leftChildIndex;
            }
            if (arr[rightChildIndex] > heapsize && arr[rightChildIndex] > arr[minIndex]) {
                minIndex = rightChildIndex;
            }
            if (minIndex != index) {
                int temp1 = arr[index];
                arr[index] = arr[minIndex];
                arr[minIndex] = temp1;
                index = minIndex;
                leftChildIndex = 2 * index + 1;
                rightChildIndex = 2 * index + 2;

            }
            else {
                break;
            }
        }

        return temp;
    }

}
