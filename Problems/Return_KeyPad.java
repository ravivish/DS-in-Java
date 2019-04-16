package CN;


public class Return_KeyPad {

       public static String[] keypad(int n) {
// Write your code here
        if (n == 0) {
            String[] ans = new String[1];
            ans[0] = "";
            return ans;
        }

        char[][] arr = {
                {'a', 'b', 'c'},
                {'d', 'e', 'f'},
                {'g', 'h', 'i'},
                {'j', 'k', 'l'},
                {'m', 'n', 'o'},
                {'p', 'q', 'r', 's'},
                {'t', 'u', 'v'},
                {'w', 'x', 'y', 'z'}
        };

        String s[] = keypad(n / 10);
        String output[] = new String[s.length * arr[n % 10 - 2].length];
        int k = 0;
        for (int i = 0; i <s.length;i++){
            for (int j = 0; j < arr[n%10-2].length;j++){
                output[k] = s[i] + arr[n % 10 - 2][j];
                k++;
            }
        }
        return output;
}

    public static void main(String[] args) {
        String str[] = keypad(23);
//        System.out.println(" " + Arrays.toString(str));
        for (int i = 0; i < str.length; i++) {
            System.out.println(str[i]);
        }
    }
}
