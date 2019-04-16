import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class WaysToHashMapAccess {

    private static void hashmap() {
        String[] names = {"Java", "JavaScript", "Python", "C", "Ruby", "Java"};

        // First solution : finding duplicates using brute force method
        System.out.println("Finding duplicate elements in array using brute force method");
        for (int i = 0; i < names.length; i++) {
            for (int j = i + 1; j < names.length; j++) {
                if (names[i].equals(names[j])) {
                    // got the duplicate element
                }
            }
        }

        // Second solution : use HashSet data structure to find duplicates
        System.out.println("Duplicate elements from array using HashSet data structure");
        Set<String> store = new HashSet<>();

        for (String name : names) {
            if (store.add(name) == false) {
                System.out.println("found a duplicate element in array : "
                        + name);
            }
        }

        // Third solution : using Hash table data structure to find duplicates
        System.out.println("Duplicate elements from array using hash table");
        Map<String, Integer> nameAndCount = new HashMap<>();

        // build hash table with count
        for (String name : names) {
            Integer count = nameAndCount.get(name);
            if (count == null) {
                nameAndCount.put(name, 1);
            } else {
                nameAndCount.put(name, ++count);
            }
        }

        // Print duplicate elements from array in Java
//        Set<Entry<String, Integer>> entrySet = nameAndCount.entrySet();
//        for (Entry<String, Integer> entry : entrySet) {
//
//            if (entry.getValue() > 1) {
//                System.out.println("Duplicate element from array : "
//                        + entry.getKey());
//            }
//        }
    }

    private static void fun(int[] A) {
        /*
         * find a unique number in array which is not repeated twice in an array
         * */
        HashMap<Integer, Integer> h = new HashMap<>();
        for (Integer i : A) {
            Integer count = h.get(i);
            if (count == null) {
                h.put(i, 1);
            } else {
                h.put(i, ++count);
            }
        }

        Set<Integer> set = h.keySet();//To traverse on all keys we need to create a set of keys
//        for(Integer i:set){
        for (Integer i : A) {//This will also work to get all keys using advanced for loop and this will only work when we have array(A)
            if (h.get(i) == 1) {
                System.out.print(i + " ");
                break;
            }
        }
    }

    public static void main(String[] args) {
//       hashmap();
        int[] a = {1, 1, 2, 2, 3, 3, 4};
        fun(a);
    }
}
