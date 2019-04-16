package Stack_Queues;

public class Reverse_Queue {

    public static void reverseQueue(QueueUsingLL<Integer> q) throws QueueEmptyException {
        // Write your code here
        if(q.isEmpty())
        {
            return ;
        }

        int val = q.dequeue();
        reverseQueue(q) ;

        q.enqueue(val) ;


    }
}
