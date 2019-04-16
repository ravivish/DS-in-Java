package CN;

/*
* Does s contains t in same order as in t then
* return true
* */
public class DoesScontainT_Test1 {
    private static boolean check(String a,String b,int index){

        if (a.contains(b)){
            return true;
        }
        return check(a,b,index+1);
    }

    public static boolean checkSequence(String a, String b) {
        /* Your class should be named Solution
         * Don't write main().
         * Don't read input, it is passed as function argument.
         * Return output and don't print it.
         * Taking input and printing output is handled automatically.
         */
        if (a.length() == 0){
            return false;
        }
        if (b.length() == 0){
            return false;
        }

        return true;

    }
    public static void main(String[] args) {
        String s="abcde";
        String t="aeb";
        System.out.println(checkSequence(s,t));

    }
}
