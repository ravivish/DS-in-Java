package CN;

public class Return_Permutation_String {


    public static String[] permutationOfString(String input){
        // Write your code here

        if (input.length() == 0){
            String[] ans={""};
            return ans;
        }

        String[] smallAns = permutationOfString(input.substring(1));
        String[] ans=new String[input.length()*smallAns.length];
        int k=0;

        for (int i=0;i<smallAns.length;i++){
            for (int j=0;j<input.length();j++){
                ans[k++]=smallAns[i].substring(0,j)+input.charAt(0)+smallAns[i].substring(j);
            }
        }

        return ans;

    }
    public static void main(String[] args) {
        String str="xyz";
        String[] ans=permutationOfString(str);
        for (int i=0;i<ans.length;i++){
            System.out.println(ans[i]);
        }
    }
}
