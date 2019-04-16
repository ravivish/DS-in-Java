package HashMaps;

import javafx.print.Collation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Longest_Consecutive_Subsequence {

    public static ArrayList<Integer> longestSubsequence(int[] arr) {

        HashMap<Integer, Integer> hashMap = new HashMap<>();
        ArrayList<Integer> ans = new ArrayList<>();
        int freq = 1;
        for (int i = 0; i < arr.length; i++) {
            int keys = arr[i];
            if (!hashMap.containsKey(keys)) {
                hashMap.put(keys, freq);
                freq++;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            ArrayList<Integer> tempList = new ArrayList<Integer>();
            int t = arr[i];
            int tp = arr[i] - 1;
            int tf = arr[i] + 1;
            tempList.add(t);
            while (hashMap.containsKey(tp)) {
                tempList.add(0, tp);
                hashMap.remove(tp);
                tp--;
            }
            while (hashMap.containsKey(tf)) {
                tempList.add(tf);
                hashMap.remove(tf);
                tf++;
            }

            if (tempList.size() > ans.size())
                ans = tempList;
            else if (tempList.size() == ans.size()) {

                int j = 0;
                for (; j < arr.length; j++) {
                    if (arr[j] == ans.get(0))
                        break;
                }
                if (j > i)
                    ans = tempList;
            }
        }
        return ans;

    }

    public static void main(String[] args) {
        int[] arr = {2, 12, 9, 16, 10, 5, 3, 20, 25, 11, 1, 8, 6};
        ArrayList<Integer> ans = longestSubsequence(arr);
//        System.out.println(ans.toString());
    }
}
