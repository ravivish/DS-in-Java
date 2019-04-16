package CN;

public class Calculate_Power {
    public static int power(int x,int n){
        if(n==0){
            return 1;
        }
        return power( x,n - 1 ) *x;
    }

    public static void main(String[] args) {
      int n1=  power(5,2);
        System.out.println(n1);
    }
}
