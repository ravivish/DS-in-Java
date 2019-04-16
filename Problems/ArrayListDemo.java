package CN;

import java.util.ArrayList;

public class ArrayListDemo {

    public static void main(String[] args) {

        ArrayList<Integer> list=new ArrayList<>();
        System.out.println("Current size: "+list.size());

        list.add(15);
        list.add(20);
        list.add(25);
        list.add(2,50);

        for (int i:list)
        {
            System.out.print(i+" ");
        }

        System.out.println();

        for (int i=0;i<list.size();i++) {
            System.out.print(list.get(i) + " ");
        }
    }
}
