package CN;

public class CheckAB {

    private static boolean checkAB(String input) {

        if(input.length() == 0 || (input.length() == 1 && input.charAt(0) == 'a')  )
        {
            return true ;
        }

        if(input.charAt(0) == 'a')
        {
            if(input.length() >= 1 && input.charAt(1) == 'a')
            {
                return checkAB(input.substring(1)) ;
            }
            else if(input.length() >= 2 && input.charAt(1) == 'b' && input.charAt(2) == 'b')
            {
                return checkAB(input.substring(3)) ;
            }
            else
            {
                return false ;
            }

        }
        else
        {
            return false ;
        }

    }

    public static void main(String[] args) {
        String str = "abbc";
        System.out.println(checkAB(str));
    }
}
