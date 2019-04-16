package CN;

public class StringToInteger {
    public static int convertStringToInt(String input) {
        if (input.equals("")) {
            return 0;
        }

        int x = 1;
        for (int i = 0; i < input.length() - 1; i++) {
            x = x * 10;
        }
        x = x * Integer.parseInt(input.substring(0, 1));
        return x + convertStringToInt(input.substring(1));
    }

    public static void main(String[] args) {
        String s = "123";
        int ans = convertStringToInt(s);
        System.out.println(ans);
    }
}
