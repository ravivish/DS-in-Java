package HashMaps;

import java.util.ArrayList;
import java.util.HashMap;

public class Remove_Duplicates {

    public static ArrayList<Integer> removeDuplicates(int[] a) {
        ArrayList<Integer> output = new ArrayList<>();
        HashMap<Integer, Boolean> seen = new HashMap<>();
        for (int i = 0; i < a.length; i++) {
            if (seen.containsKey(a[i])) {
                continue;
            } else {
                output.add(a[i]);
                seen.put(a[i], true);
            }
        }
        return output;
    }


    public static void main(String[] args) {

        int[] a = {1, 2, 3, 2, 1, 2, 3, 4, 5, 3, 1, 2, 3, 1, 2, 3, 6, 9, 7, 4, 5, 4, 5, 4, 5};
        ArrayList<Integer> ans = removeDuplicates(a);
        for (int i = 0; i < ans.size(); i++) {
            System.out.print(ans.get(i) + " ");
        }
    }
}
