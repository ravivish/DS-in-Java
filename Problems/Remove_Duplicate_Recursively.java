package CN;

public class Remove_Duplicate_Recursively {

    public static String helper(String s,char a,String ans,int si) {
        if (si == s.length())
            return ans;
        if (s.charAt(si) == a) {
            return helper(s, a, ans, si + 1);
        } else {
            a = s.charAt(si);
            ans = ans + s.charAt(si);
            return helper(s, a, ans, si + 1);
        }
    }

    public static String removeConsecutiveDuplicates(String s) {
//        // Write your code here
        String ans=helper(s,s.charAt(0),s.substring(0,1),1);
        return ans;
    }


    public static void main(String[] args) {
        String str = "aabc";
        System.out.println(removeConsecutiveDuplicates(str));
    }
}
