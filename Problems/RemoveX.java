package CN;

public class RemoveX {


    private static String removeX(StringBuilder string, int index) {

        if (index < 0) {
            String str1 = new String(string);
            return str1;
        }
        if (string.charAt(index) == 'x') {
            string.deleteCharAt(index);
        }
        String str = removeX(string, index - 1);
        return str;
    }

    public static String removeX(String input) {
        // Write your code here
        StringBuilder str = new StringBuilder(input);
        String str1 = removeX(str, str.length()-1);
        return str1;
    }

    public static void main(String[] args) {
        String str = "xaxbxc";
        System.out.println("Char at 0 "+str.charAt(1)+" length -2 = "+str.charAt(str.length()-1));
        String string = removeX(str);
        System.out.println(string);
    }
}
