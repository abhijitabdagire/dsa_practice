public class LinkedList {
    // The above class LinkedList so in that we have create a object which is the
    // entire linkedlist
    // So that linkedlist contains the collection of node so we have create a class
    // of Node

    public static class Node {
        int data;
        Node next; // Node class ka obj which create in Node of next as parameter. next is point
                   // the another obj. in node class

        // This is constructor which is the pass the data and next is null
        // so we have consider the only one node in linked list.
        public Node(int data) {
            this.data = data;
            this.next = null;
        }

    }

    // In LinkedList there is only one HEAD and TAIL. Which are present in
    // linkedlist opp.side.
    // But in case of Only one node in linkedlist there are
    // point the HEAD and TAIL is same.
    public static Node head;
    public static Node tail;
    public static int size;

    // METHOD

    // addFirst()
    public void addFirst(int data) {
        // STEP 1 - Create a new Node
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
            return;
        }
        // STEP 2 - newNode next = head
        newNode.next = head;

        // STEP 3 - head = newNode
        head = newNode;
    }

    // addLast()
    public void addLast(int data) {
        // STEP 1 - create a new Node
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
            return;
        }
        // STEP 2 - tail next = newNode
        tail.next = newNode;

        // STEP 3 - tail = newNode
        tail = newNode;
    }

    // addMiddle or addAtIndex
    public void add(int idx, int data) {
        if (idx == 0) {
            addFirst(data);
        }
        Node newNode = new Node(data);
        size++;
        Node temp = head;
        int i = 0;

        while (i < idx - 1) {
            temp = temp.next;
            i++;
        }

        // i = idx-1; temp->prev
        newNode.next = temp.next;
        temp.next = newNode;
    }

    // print
    public void print() {
        if (head == null) {
            System.out.println("LinkedList is Empty");
            return;
        }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // Remove opration

    // removeFirst
    public int removeFirst() {
        if (size == 0) {
            System.out.println("LL is empty");
            return Integer.MIN_VALUE;
        } else if (size == 1) {
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }
        int val = head.data;
        head = head.next;
        size--;
        return val;
    }

    // removeLast
    public int removeLast() {
        if (size == 0) {
            System.out.println("LL is empty");
            return Integer.MIN_VALUE;
        } else if (size == 1) {
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }

        // prev : i = size-2
        Node prev = head;
        for (int i = 0; i < size - 2; i++) {
            prev = prev.next;
        }
        int val = prev.next.data; // tail.data
        prev.next = null;
        tail = prev;
        size--;
        return val;
    }

    // Search(Iterative)
    public int itrSearch(int key) { // 0(n)
        Node temp = head;
        int i = 0;

        while (temp != null) {
            if (temp.data == key) {
                return i;
            }
            temp = temp.next;
            i++;
        }
        return -1;
    }

    // recursiveSearch(Iterative)

    public int helper(Node head, int key) {
        if (head == null) {
            return -1;
        }

        if (head.data == key) {
            return 0;
        }
        int idx = helper(head.next, key);
        if (idx == -1) {
            return -1;
        }

        return idx + 1;
    }

    public int recSearch(int key) {
        return helper(head, key);
    }

    // Reverse Linked list
    public void reverse() {
        Node prev = null;
        Node curr = tail = head;
        Node next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev; // reverse
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    // Find and Remove Nth node from end
    public void deleteNthfromEnd(int n) {
        // n means which node is remove/deleted

        // Calculate the size
        int sz = 0;
        Node temp = head;
        while (temp != null) {
            temp = temp.next;
            sz++;
        }

        if (n == sz) {
            head = head.next;
            return;
        }

        // sz-n
        int i = 1;
        int iTOfind = sz - n;
        Node prev = head;
        while (i < iTOfind) {
            prev = prev.next;
            i++;
        }
        prev.next = prev.next.next;
        return;
    }

    // Floyd's CFA
    public static boolean isCycle() {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next; // +1
            fast = fast.next.next; // +2
            if (slow == fast) {
                return true; // Cycle exist
            }
        }
        return false; // Cycle Does't exist
    }

    // Remove a loop/cycle in a linked list.
    public static void removeCycle() {
        // Detect Cycle
        Node slow = head;
        Node fast = head;
        boolean cycle = false;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                cycle = true;
                break;
            }
        }
        if (cycle == false) {
            return;
        }

        // find meeting point first time meet.
        slow = head;
        Node prev = null; // last node
        while (slow != fast) {
            prev = fast;
            slow = slow.next;
            fast = fast.next;
        }

        // remove cycle -> last.next = null
        prev.next = null;
    }

    // Merge Sort on Linked List

    private Node getMid(Node head) {
        Node slow = head;
        Node fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next; // +1
            fast = fast.next.next; // +2
        }
        return slow; // which the middle node of the first half of last element.
    }

    private Node merge(Node head1, Node head2) {
        Node mergeLL = new Node(-1);
        Node temp = mergeLL;

        while (head1 != null && head2 != null) {
            if (head1.data <= head2.data) {
                temp.next = head1;
                head1 = head1.next;
                temp = temp.next;
            } else {
                temp.next = head2;
                head2 = head2.next;
                temp = temp.next;
            }

        }
        while (head1 != null) {
            temp.next = head1;
            head1 = head1.next;
            temp = temp.next;
        }
        while (head2 != null) {
            temp.next = head2;
            head2 = head2.next;
            temp = temp.next;
        }
        return mergeLL.next;
    }

    public Node mergeSort(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        // find mid
        Node mid = getMid(head);

        // left & right MS
        Node rightHead = mid.next;
        mid.next = null;
        Node newLeft = mergeSort(head);
        Node newRight = mergeSort(rightHead);

        // merge
        return merge(newLeft, newRight);
    }

    // Zig-Zag Linked List
    public void zigZag() {
        // find mid
        Node slow = head;
        Node fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        Node mid = slow;

        // reverse 2nd half
        Node curr = mid.next;
        mid.next = null;
        Node prev = null;
        Node next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        Node left = head;
        Node right = prev;
        Node nextL, nextR;

        // alt merge - zig-zag merge
        while (left != null && right != null) {
            nextL = left.next;
            left.next = right;
            nextR = right.next;
            right.next = nextL;

            right = nextR;
            left = nextL;
        }
    }

    public static void main(String[] args) {
        // Here we have create a Class of LinkedList of Object ll which is the
        // linkedlist.
        LinkedList ll = new LinkedList();

        // here the where the linkedlist of head create data which store the value 1 and
        // headof next which is the 2.
        // ll.head = new Node(1);
        // ll.head.next = new Node(2);

        // If we have opreated the all operation of linklist so do not write the main me
        // function
        // code. element ko(add, delete, update...etc)
        // So we have create the METHOD. which location we have create the METHOD in
        // LinkedList CLass. add(), remove() ...etc.
        // ll.print();
        ll.addFirst(2);
        // ll.print();
        ll.addFirst(1);
        // ll.print();
        ll.addLast(4);
        // ll.print();
        ll.addLast(5);
        // ll.print();

        ll.add(2, 3); // 1->2->9->3->4
        // ll.print();

        // SIZE OF LINKED LIST
        // System.out.println(ll.size);

        // REMOVE
        // ll.removeFirst();
        // ll.print();

        // ll.removeLast();
        // ll.print();

        // System.out.println(ll.size);

        // QUE - SEARCH KEY USING ITERATED
        // System.out.println(ll.itrSearch(3));
        // System.out.println(ll.itrSearch(10));

        // QUE - RECURSIVE SEARCH KEY USING ITERATED
        // System.out.println(ll.recSearch(2));

        // QUE - REVESER LINKED LIST
        // ll.print(); // 1->2->3->4->5
        // ll.reverse();
        // ll.print();

        // QUE - FIND AND REMOVE THE NTH NODE FROM END
        // ll.print(); // 1->2->3->4->5
        // ll.deleteNthfromEnd(3);
        // ll.print();

        // OUE - DETECT A LOOP / CYCLE IN A LINKED LIST
        // head = new Node(1);
        // Node temp = new Node(2);
        // head.next = temp;
        // // head.next = new Node(2);
        // head.next.next = new Node(3);
        // head.next.next.next = temp;
        // System.out.println(isCycle());
        // removeCycle();
        // System.out.println(isCycle());

        // OUE - MERGE SORT ON LINKED LIST
        // ll.addFirst(1);
        // ll.addFirst(2);
        // ll.addFirst(3);
        // ll.addFirst(4);

        // ll.print();
        // ll.head = ll.mergeSort(ll.head);
        // ll.print();

        // QUE - ZIG-ZAG LINKED LIST
        ll.print();
        ll.zigZag();
        ll.print();

    }
}
