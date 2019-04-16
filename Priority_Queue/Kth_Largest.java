package Priority_Queue;

import java.util.PriorityQueue;

public class Kth_Largest {

    public static void printKLargest(int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int i = 0;
        for (; i < k; i++) {
            pq.add(arr[i]);
        }
        for (;i<arr.length;i++){
            int min=pq.element();
            if (min<arr[i]){
                pq.remove();
                pq.add(arr[i]);
            }
        }
        while (!pq.isEmpty()){
            System.out.println(pq.remove());
        }

    }


}
