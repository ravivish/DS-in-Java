package Stack_Queues;

import java.util.Stack;

public class Reverse_Stack {

    public static void reverseStack(Stack<Integer> s1, Stack<Integer> s2) {
//        System.out.print("before: ");

        if (s1.size() == 0){
            return;
        }
        int val=s1.pop();

        reverseStack(s1,s2);
        
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }
        s1.push(val);
        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }
    }

    public static void main(String[] args) {
        Stack<Integer> stack1=new Stack<>();
        stack1.push(1);
        stack1.push(2);
        stack1.push(3);
        stack1.push(4);
        Stack<Integer> stack2=new Stack<>();
        reverseStack(stack1,stack2);
    }
}
