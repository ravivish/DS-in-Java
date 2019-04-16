package Stack_Queues;

import java.util.Stack;

public class Minimum_Bracket_Reversal {

    public static int countBracketReversals(String input){

        // Write your code here
        int len = input.length();

        if (len%2 != 0)
            return -1;

        Stack<Character> stack=new Stack<>();

        for (int i=0; i<len; i++)
        {
            char c = input.charAt(i);
            if (c =='}' && !stack.empty())
            {
                if (stack.peek()=='{')
                    stack.pop();
                else
                    stack.push(c);
            }
            else
                stack.push(c);
        }

        int red_len = stack.size();
        int n = 0;
        while (!stack.empty() && stack.peek() == '{')
        {
            stack.pop();
            n++;
        }

        return (red_len/2 + n%2);
    }

    public static void main(String[] args) {

        String str="{{{";
        System.out.println(countBracketReversals(str));

    }
}
