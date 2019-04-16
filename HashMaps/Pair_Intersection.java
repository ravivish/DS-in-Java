package HashMaps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Pair_Intersection {


    public static void intersection(int[] arr1, int[] arr2) {

        HashMap<Integer, Integer> hmap = new HashMap<>();
        ArrayList<Integer> arr3 = new ArrayList<>();
        for (int i = 0; i < arr1.length; i++) {
            int key = arr1[i];
            if (hmap.containsKey(key)) {
                int freq = hmap.get(key);
                freq++;
                hmap.put(key, freq);
            } else {
                hmap.put(key, 1);
            }
        }
        for (int i = 0; i < arr2.length; i++) {

            int key = arr2[i];
            if (hmap.containsKey(key)) {

                int freq = hmap.get(key);
                if (freq == 1) {
                    hmap.remove(key);
                } else {
                    System.out.println(hmap.get(key));
                    freq--;
                    hmap.put(key, freq);

                }
                System.out.println(key);
            } else
                continue;
        }


    }


    public static void main(String[] args) {

        int[] arr1 = {2, 6, 8, 5, 4, 3};
        int[] arr2 = {2, 3, 4, 7};
        intersection(arr1, arr2);

    }
}
