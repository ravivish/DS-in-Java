package HashMaps;

import java.util.HashMap;
import java.util.Map;

public class Max_Frequency {

    public static int maxFrequencyNumber(int[] arr) {
        HashMap<Integer, Integer> hp =
                new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            int key = arr[i];
            if (hp.containsKey(key)) {
                int freq = hp.get(key);
                freq++;
                hp.put(key, freq);
            } else {
                hp.put(key, 1);
            }
        }

        // find max frequency.
        int max_count = 0, res = -1;
        for (int i = 0; i < arr.length; i++) {
            int key = arr[i];
            if (hp.containsKey(key)) {
                if(hp.get(key) > max_count ){
                    res=key;
                    max_count=hp.get(key);
                }
                hp.remove(key);
            }
        }

        return res;
    }

    public static void main(String[] args) {

        int []a={1 ,4 ,5,1};
        System.out.println(maxFrequencyNumber(a));
    }
}

