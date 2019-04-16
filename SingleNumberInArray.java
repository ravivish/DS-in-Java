import java.util.HashMap;

/*
 * Given a non-empty array of integers,
 * every element appears twice except for one. Find that single one.
 * */
public class SingleNumberInArray {

    public static int singleNumber(int[] nums) {
        int n = 0;

        HashMap<Integer, Integer> ht = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int v = 1;
            if (ht.containsKey(nums[i])) {
                v = ht.get(nums[i]);
//                v++;
                ht.put(nums[i], ++v);
            } else {
                ht.put(nums[i], 1);
            }
        }
        /*
         * Traversing the hash map for all values
         * */
        for (Integer key : ht.keySet()) {
            System.out.println(key + " " + ht.get(key));
            if(ht.get(key)==1){
                n=key;
            }
        }

        System.out.println("got the : "+n);
        return n;

    }

    public static void main(String[] args) {

        int[] a = {4, 1, 2, 1, 2};
        singleNumber(a);

    }
}
