package Stack_Queues;

public class BalancedParenthesis {


    public static boolean checkBalance(String str) {
        StackUsingLL<Character> stack = new StackUsingLL<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '[' || ch == '(' || ch == '{') {
                stack.push(ch);
            } else if ((ch == ']' || ch == '}' || ch == ')')
                    && (!stack.isEmpty())) {
                try {
                    if (((char) stack.top() == '(' && ch == ')')
                            || ((char) stack.top() == '{' && ch == '}')
                            || ((char) stack.top() == '[' && ch == ']')) {
                        stack.pop();
                    } else {
                        return false;//"Not Balanced";
                    }
                } catch (StackEmptyException e) {
                    e.printStackTrace();
                }
            } else {
                if ((ch == ']' || ch == '}' || ch == ')')) {
                    return false;//"Not Balanced";
                }
            }
        }
        if (stack.isEmpty())
            return true;//"Balanced Parenthisis";
        else
            return false;//"Not Balanced";
    }

    public static void main(String[] args) {

        String str = "{ a + [ b - c } ]";
        boolean status = checkBalance(str);
        System.out.println("status = " + status);

//        assertTrue(checkBalance("{}([])"));
//        assertFalse(checkBalance("([}])"));
//        assertTrue(checkBalance("([])"));
//        assertTrue(checkBalance("()[]{}[][]"));
    }
}
