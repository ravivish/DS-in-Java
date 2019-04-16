package CN;

public class GeometricSum {

    public static double findGeometricSum(int k){
        // Write your code here
            if (k == 0) {
                return 1;
            }
            return findGeometricSum(k-1) + Math.pow(2, -k);


    }

    public static void main(String[] args) {
        int n=3;
        double ans=findGeometricSum(n);
        System.out.println(ans);
    }
}
