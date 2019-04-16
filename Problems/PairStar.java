package CN;

public class PairStar {

    private static String addStars(StringBuilder str,int index ){

        if (index >= str.length()){
            String string=new String(str);
            return string;
        }
        if (str.charAt(index-1)==str.charAt(index)){
            str.insert(index,'*');
        }
        String str1=addStars(str,index+1);
        return str1;
    }
	public static String addStars(String s) {
		// Write your code here
      StringBuilder str=new StringBuilder(s);
        String str1=addStars(str,1);
        return str1;
	}

    public static void main(String[] args) {
        String str="hello";
        String ans=addStars(str);
        System.out.println(ans);
    }
}
