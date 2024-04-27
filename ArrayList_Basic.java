import java.util.ArrayList;

public class ArrayList_Basic {

    public static void main(String[] args) {

        // syntax
        ArrayList<Integer> list = new ArrayList<>();
        // String, Boolean, Float

        // Operation on ArrayList

        // add
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        // System.out.println(list);

        // get
        list.get(2);
        // System.out.println(list);

        // remove
        list.remove(1);

        // set
        list.set(3, 10);

        // contain
        System.out.println(list.contains(1));

        // size
        System.out.println(list.size());

        // print
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println(); // nextLine
    }
}