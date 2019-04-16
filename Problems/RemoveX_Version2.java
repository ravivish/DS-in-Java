package CN;

public class RemoveX_Version2 {

    public static String removeX(String input) {
        if (input.length() == 0){
            return input;
        }
        String ans="";
        if (input.charAt(0) != 'x'){
            ans = ans + input.charAt(0);
        }
        String smallAns = removeX(input.substring(1));
        return ans+smallAns;
    }
    public static void main(String[] args) {
        String str="xabxcxd";
        System.out.println(removeX(str));
    }
}
