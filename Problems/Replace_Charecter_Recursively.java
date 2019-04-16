package CN;

public class Replace_Charecter_Recursively {

//    private static String replaceCharacter2(StringBuffer ans, char c1, char c2) {{
//        if (ans.length() == 0){
//            String str=new String(ans);
//            return str;
//        }
//        if (ans.charAt(0) == c1) {
//
//            ans.deleteCharAt(0);
//            ans.insert(0,c2);
//        }
//        String small=replaceCharacter2(ans.substring(1),c1,c2);
//        return small;
//    }

    public static String replaceCharacter(String input, char c1, char c2) {
        /* Your class should be named Solution
         * Don't write main().
         * Don't read input, it is passed as function argument.
         * Return output and don't print it.
         * Taking input and printing output is handled automatically.
         */
//        StringBuffer ans=new StringBuffer(input);
//        replaceCharacter2(ans,c1,c2);
        if (input.length() == 0){
            return input;
        }

        String s1=input.replace(c1,c2);
        return s1;

    }
    public static void main(String[] args) {

        String str="abacd";
        System.out.println(replaceCharacter(str,'a','x'));
    }
}
