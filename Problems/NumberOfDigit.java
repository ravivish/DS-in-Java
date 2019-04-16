package CN;

public class NumberOfDigit {


    public static int count(int n){

        if(n <= 0){
            return 0;
        }
        int sa=count(n/10);
        return sa+1;
    }
    public static void main(String[] args) {
        int c=count(123456);
        System.out.println(c);
    }
}
