package CN;


import java.util.Arrays;

public class Array_Intersection {



    public static void intersection(int[] arr1, int[] arr2) {
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        int i = 0, j = 0;
        while (i < arr1.length - 1 && j < arr2.length - 1) {
                if (arr1[i] == arr2[j]) {
                    System.out.print(arr1[i] + " ");
                    i++;
                    j++;
                } else if (arr1[i] < arr2[j])
                    i++;
                else
                    j++;
            }
//        }


    }

    public static void main(String[] args) {
        int[] arr1 = {2 ,6 ,8 ,5 ,4 ,3};
        int[] arr2 = {2, 7, 4, 3,};
        intersection(arr1, arr2);
    }
}
