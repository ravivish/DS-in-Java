package Stack_Queues;

import java.util.Stack;

public class Check_Redundant_Brackets {

    public static boolean checkRedundantBrackets(String input) {
        // Write your code here
        if (input.length() == 0) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        int index = 0;
        while(index < input.length()){
            char c = input.charAt(index);
            if(c == '(' || c == '+' || c == '-' || c == '*' || c == '/'){
                stack.push(c);
            }
            else if(c == ')'){
                if(stack.peek() == '('){
                    return true;
                } else{
                    while(!stack.isEmpty() && stack.peek() != '('){
                        stack.pop();
                    }
                    stack.pop();
                }
            }
            index++;
        }
        return false;
    }

    public static void main(String[] args) {
        String str = "(a + (b)) ";
        boolean status = checkRedundantBrackets(str);
        System.out.println("status = " + status);
    }


}
