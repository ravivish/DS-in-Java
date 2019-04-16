package CN;

public class Return_All_Code_Strong {

    public static String[] getCode(String input) {

        if (input.length() == 0) {
            String res[] = new String[1];
            res[0] = "";
            return res;
        }

        char element1 = input.charAt(0);

        String[] ans1 = getCode(input.substring(1));

        char code1 = (char) (element1 - '1' + 'a');

        for (int i = 0; i < ans1.length; i++) {
            ans1[i] = code1 + ans1[i];
        }

        if (input.length() >= 2) {
            String element2 = input.substring(0, 2);
            int number = Integer.parseInt(element2);


            if (number >= 10 && number <= 26) {
                String ans2[] = getCode(input.substring(2));

                char code2 = (char) ('a' + number - 1);

                for (int i = 0; i < ans2.length; i++) {
                    ans2[i] = code2 + ans2[i];
                }


                String finalres[] = new String[ans1.length + ans2.length];

                int k = 0;

                for (int i = 0; i < ans1.length; i++) {
                    finalres[k] = ans1[i];
                    k++;
                }


                for (int i = 0; i < ans2.length; i++) {
                    finalres[k] = ans2[i];
                    k++;
                }


                return finalres;

            }

        }
        return ans1;

    }


    public static void main(String[] args) {
        String arr = "1123";
        String[] ans = getCode(arr);
        for (int i = 0; i < ans.length; i++) {
            System.out.println(ans[i]);
        }
    }
}
