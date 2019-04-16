package CN;

public class TowerOfHanoi {



    public static void towerOfHanoi(int disks, char source, char auxiliary, char destination) {
        // Write your code here
            if (disks == 0) {
//                System.out.println(source + " " + destination); // it only need when ur base case is disk==1
                return;
            } else {
                towerOfHanoi(disks - 1, source, destination, auxiliary);
                System.out.println(source + " " + destination);
                towerOfHanoi(disks - 1, auxiliary, source, destination);
            }

    }


    public static void main(String[] args) {
        char a='a';
        char b='b';
        char c='c';
        towerOfHanoi(2,a,b,c);

    }
}
