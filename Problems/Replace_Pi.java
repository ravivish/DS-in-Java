package CN;

public class Replace_Pi {

    // Return the changed string
  	private static String replace(StringBuilder str,int index ){

        if (index >= str.length()){
            String string=new String(str);
            return string;
        }
        if (str.charAt(index-1)=='p' &&  str.charAt(index)=='i') 
        {   
            // System.out.println("Before : "+str);
            str.deleteCharAt(index-1);
            // System.out.println("After index-1 : "+str);
            str.deleteCharAt(index-1);
            // System.out.println("After index : "+str);
            // System.out.println("Pring str : "+str);
            str.insert(index-1,"3.14");
            // System.out.println("After Adding pi : "+str);    
        }
        String str1=replace(str,index+1);
        return str1;
	}
	public static String replace(String input){
		// Write your code here
       StringBuilder str = new StringBuilder(input);
       String ans=replace(str,1);
       return ans;
	}
	
	public static void main(String []args){
	    String str="xpixpix";
	    String ans=replace(str);
	    System.out.println("Final string : "+ans);
	}
}
