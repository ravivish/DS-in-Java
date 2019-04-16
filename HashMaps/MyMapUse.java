package HashMaps;

public class MyMapUse {


    public static void main(String[] args) {
        MyMap<String, Integer> map = new MyMap<>();
        for (int i = 0; i < 20; i++) {
            map.insert("abc" + i, 1 + i);
            System.out.println("i = " + i + " lf = " + map.loadFactor());
        }

        map.removeKey("abc3");
        map.removeKey("abc7");

        for (int i = 0; i < 20; i++) {
            System.out.println("abc" + i + ":" + map.getValue("abc" + i));
        }

    }

}


