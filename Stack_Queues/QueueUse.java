package Stack_Queues;

public class QueueUse {

    public static void main(String[] args) throws QueueEmptyException, QueueFullException {
//        QueueUsingArray q=new QueueUsingArray(3);
//        for (int i=1;i<=5;i++){
//            q.enqueue(i);
//        }
//        while (!q.isEmpty()){
//            System.out.print(q.dqueue()+" ");
//        }

        QueueUsingLL<Integer> q = new QueueUsingLL<>();
        for (int i = 1; i <= 5; i++) {
            q.enqueue(i);
        }
        while (!q.isEmpty()){
            System.out.print(q.dequeue()+" ");
        }
    }
}
