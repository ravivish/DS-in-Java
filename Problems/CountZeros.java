package CN;

public class CountZeros {

    private static int countZerosRec(int input,int count){

//        if (input < 0)
//            return 0;
        if(input<=0)
            count++;
        return count+countZerosRec(input/10,count);


    }
// Hello this is my code line tool for development
    public static int countZerosRec(int input) {
        // Write your code here
//        int m=countZerosRec(input,0);
        if (input==0)
            return 0;
        if(input%10==0){
            return 1+countZerosRec(input/10);
        }
        else
            return countZerosRec(input/10);
    }

    public static void main(String[] args) {
        int n = 1020450030;
        int m = countZerosRec(n);
        System.out.println(m);
    }
}
