package Priority_Queue;

public class Check_Max_Heap {


    public static boolean checkMaxHeap(int arr[]) {

        for (int i = 0; i <= (arr.length - 2) / 2; i++) {
            if (arr[i] < arr[2 * i + 1] || ((2 * i + 2 != arr.length) && arr[i] < arr[2 * i + 2])) {
                    return false;
            }
        }
        return true;

    }

    public static void main(String[] args) {

    }
}
