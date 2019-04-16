package CN;

public class CheckPalindrome {
    private static boolean isStringPalindrome(String input, int startIndex, int endIndex) {

        if (startIndex == endIndex)
            return true;
        if (input.charAt(startIndex) != input.charAt(endIndex)) {
            return false;
        }
        if (startIndex < endIndex + 1) {
            return isStringPalindrome(input, startIndex + 1, endIndex - 1);
        }
        return true;

    }

    public static boolean isStringPalindrome(String input) {

        int n = input.length();
        if (n == 0)
            return true;
        boolean status = isStringPalindrome(input, 0, n - 1);
        return status;

    }

    public static void main(String[] args) {

        String s = "pabola";
        boolean check = isStringPalindrome(s);
        System.out.print(check);
    }
}
