package CN;

public class Print_Permutation_String {

    private static String[] helper(String input){


        if (input.length() == 0){
            String[] ans={""};
            return ans;
        }

        String[] smallAns = helper(input.substring(1));
        String[] ans=new String[input.length()*smallAns.length];
        int k=0;

        for (int i=0;i<smallAns.length;i++){
            for (int j=0;j<input.length();j++){
                ans[k++]=smallAns[i].substring(0,j)+input.charAt(0)+smallAns[i].substring(j);
            }
        }

        return ans;
    }


    public static void permutations(String input){
        // Write your code here
        String[] ans=helper(input);
        for (int i=0;i<ans.length;i++){
            System.out.println(ans[i]);
        }

    }
    public static void main(String[] args) {
        String str="xyz";
        permutations(str);

    }
}
