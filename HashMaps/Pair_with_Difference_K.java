package HashMaps;

import java.util.HashMap;

public class Pair_with_Difference_K {

    public static void findPairsDifferenceK(int[] input, int k) {
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        for (int i : input) {
            int z1 = i + k;
            boolean flag = false;
            if (i == z1) {
                flag = true;
            }
            if (hm.containsKey(z1)) {
                int s1 = hm.get(z1);
                for (int j = 0; j < s1; j++) {
                    if (z1 < i) {
                        System.out.println(z1 + " " + i);
                    } else {
                        System.out.println(i + " " + z1);
                    }
                }
            }
            int z2 = i - k;
            if (hm.containsKey(z2) && !flag) {
                int s2 = hm.get(z2);
                for (int j = 0; j < s2; j++) {
                    if (z2 < i) {
                        System.out.println(z2 + " " + i);
                    } else {
                        System.out.println(i + " " + z2);
                    }
                }
            }
            if (hm.containsKey(i)) {
                hm.put(i, hm.get(i) + 1);
            } else {
                hm.put(i, 1);
            }
        }

    }


    public static void main(String[] args) {

        int[] arr = {5, 1, 2, 4};
        findPairsDifferenceK(arr, 3);

    }

}
