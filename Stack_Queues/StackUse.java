package Stack_Queues;

public class StackUse {

    public static void main(String[] args) throws StackEmptyException {
//        StackUsingArray stackUsingArray = new StackUsingArray(3);
//        for (int i = 1; i <= 5; i++) {
//            stackUsingArray.push(i);
//        }
//        while (!stackUsingArray.isEmpty()) {
//            System.out.print( stackUsingArray.pop()+" ");
//        }

        StackUsingLL<Integer> stackUsingLL = new StackUsingLL<>();
        for (int i = 10; i <= 15; i++) {
            stackUsingLL.push(i);
        }
        while (!stackUsingLL.isEmpty()) {
            System.out.print(stackUsingLL.pop()+" ");
        }
    }
}
