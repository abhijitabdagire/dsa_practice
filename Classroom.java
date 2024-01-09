
// Whenever Linked List in Java Collection Framework is used 
// First import the LinkedList.
import java.util.LinkedList;

public class Classroom {
    public static void main(String[] args) {
        // create - object int, float, char here object are create Interger,Float,
        // Character.
        LinkedList<Integer> ll = new LinkedList<>();

        // add
        ll.addLast(1);
        ll.addLast(2);
        ll.addFirst(0);
        // 0->1->2

        // print
        System.out.println(ll);

        // remove
        ll.removeLast();
        ll.removeFirst();

        System.out.println(ll);
    }
}
