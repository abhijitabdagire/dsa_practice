import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class Queue_usingLinkedList {
    // Implementation of Queue using LinkedList

    // static class Node {
    // int data;
    // Node next;

    // Node(int data) {
    // this.data = data;
    // this.next = null;
    // }
    // }

    // static class Queue {
    // static Node head = null;
    // static Node tail = null;

    // public static boolean isEmpty() {
    // return head == null && tail == null;
    // }

    // // add
    // public static void add(int data) {
    // Node newNode = new Node(data);
    // if (head == null) {
    // head = tail = newNode;
    // return;
    // }
    // tail.next = newNode;
    // tail = newNode;
    // }

    // // remove
    // public static int remove() {
    // if (isEmpty()) {
    // System.out.println("Empty Queue");
    // return -1;
    // }

    // int front = head.data;
    // // Single Element
    // if (tail == head) {
    // tail = head = null;
    // } else {
    // head = head.next;
    // }
    // return front;
    // }

    // // peek
    // public static int peek() {
    // if (isEmpty()) {
    // System.out.println("Empty Queue");
    // return -1;
    // }
    // return head.data;
    // }
    // }

    public static void main(String[] args) {
        // Queue q = new Queue();
        // Using Java Collection frameWork
        // Queue<Integer> q = new LinkedList<>();
        Queue<Integer> q = new ArrayDeque<>();
        q.add(1);
        q.add(2);
        q.add(3);
        // 1 2 3

        while (!q.isEmpty()) {
            System.out.println(q.peek());
            q.remove();
        }

    }
}
