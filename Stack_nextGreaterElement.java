import java.util.Stack;

public class Stack_nextGreaterElement {
    public static void main(String[] args) {
        int arr[] = { 6, 8, 0, 1, 3 };
        Stack<Integer> s = new Stack<>();
        int nextGreater[] = new int[arr.length];

        for (int i = arr.length - 1; i >= 0; i--) {

            // Step 1 -> While loop
            while (!s.isEmpty() && arr[s.peek()] <= arr[i]) {
                s.pop();
            }

            // Step 2 -> if-else
            if (s.isEmpty()) {
                nextGreater[i] = -1;
            } else {
                nextGreater[i] = arr[s.peek()];
            }

            // Step 3 -> push element
            s.push(i);
        }

        // print

        for (int i = 0; i < nextGreater.length; i++) {
            System.out.println(nextGreater[i] + " ");
        }
        System.out.println();
    }
}
