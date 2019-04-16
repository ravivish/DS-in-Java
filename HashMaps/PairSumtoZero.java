package HashMaps;

import java.util.HashMap;

public class PairSumtoZero {


    public static void PairSum(int[] input, int size) {

        HashMap<Integer, Integer> hmap = new HashMap<>();

        for (int i = 0; i < size; i++) {

            int key = input[i];
            if (hmap.containsKey(key)) {
                int freq = hmap.get(key);
                freq++;
                hmap.put(key, freq);
            } else {
                hmap.put(key, 1);
            }
        }


        for (int i = 0; i < size; i++) {
            if (hmap.containsKey(input[i]) && hmap.containsKey(-input[i])) {
                for (int j = (hmap.get(input[i]) * hmap.get(-input[i])); j != 0; j--) {
                    if (input[i] < 0) {
                        System.out.println(input[i] + " " + (-input[i]));
                    } else {

                        System.out.println((-input[i]) + " " + (input[i]));
                    }
                }
                hmap.remove(input[i]);
                hmap.remove(-input[i]);
            }
        }


    }

    public static void main(String[] args) {

        int[] arr = {2, 1, -2, 2, 3};
        PairSum(arr, arr.length);

    }
}
