package LC;

public class Shortest_SubaArray_With_Sum_Atleast_K {

    public int shortestSubarray(int[] A, int K) {

        if(A.length<=0){
            return -1;
        }
        int sum=0;
        for (int i=0;i<A.length;i++){
            if (A[i]==K){
                return i+1;
            }
            sum+=A[i]+sum;
            if (sum==K){
                return i+1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {


    }

}

