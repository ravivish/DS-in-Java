package Priority_Queue;

public class BuyTheTicket {

    public static int buyticket(int[] input, int k) {
        int time = 0;
        int co = 0;
        int c = input[k];
        for (int i = 0; i < input.length; i++) {
            if (input[i] > c)
                time = time + 1;
            if (input[i] == c) {
                co = co + 1;
                //time = time + 1;
            }
        }
        if (co == 1)
            time = time + 1;

        return time;
    }

    public static void main(String[] args) {
        int[] arr={3,9,4};
        System.out.println(buyticket(arr,2));
        int[] arr1={2,3,2,2,4};
        System.out.println(buyticket(arr1,3));
    }
}
