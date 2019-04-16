package Stack_Queues;

import java.util.Stack;

public class Stack_Span {

    public static int[] stockSpan(int[] price) {
        // Write your code here
        int s[] = new int[price.length];
        s[0] = 1;

        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for (int i = 1; i < price.length; i++) {
            while (!stack.isEmpty() && price[stack.peek()] < price[i])
                stack.pop();
            s[i] = stack.isEmpty() ? (i + 1) : i - stack.peek();
            stack.push(i);
        }
        return s;
    }


    /*  Algorithm
    * 1.Initialize span of day 1 as 1.
    * 2.Put day 1 on to stack.
    * 3.For all days starting from day 2, repeat following steps.
    *  a.If price of stock on day at top of stack is less
            than price of stock on current day, Pop the index from stack.
    *  b.If price of stock on the day on top of stack is
            greater than price of stock on current day,
            calculate span as current day – day at top of stack.
    *  c.Push current day index on to stack.
    * */
    public static void main(String[] args) {

        int[] span = {60, 70, 80, 100, 90, 75, 80, 120};
//        int[] span = {1, 1, 1, 1};
        int[] res = stockSpan(span);
        for (int i = 0; i < res.length; i++)
            System.out.print(res[i] + " ");


    }
}
