package HashMaps;

import java.util.HashMap;

public class Extract_Unique_Character {

    //
    public static String uniqueChar(String str) {
        // Write your code here
        HashMap<Character,Integer> hmap=new HashMap<>();

        for(int i = 0 ; i < str.length() ;i++)
        {
            hmap.put(str.charAt(i) , 0 ) ;
        }

        String res = "" ;

        for(int i = 0 ; i < str.length() ;i++)
        {
            if(hmap.containsKey(str.charAt(i)))
            {
                res = res + str.charAt(i) ;
                hmap.remove(str.charAt(i)) ;
            }
        }

        return res ;
    }

    public static void main(String[] args) {

//        String string=
        System.out.println(uniqueChar("ababacd"));
    }
}
