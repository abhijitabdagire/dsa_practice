import java.util.*;

public class Binary_Search {

    public static int binarySearch(int number[], int key) {
        int start = 0;
        int end = number.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (number[mid] == key) {
                return mid;
            }
            if (number[mid] > key) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        // int number[] = { 1, 2, 3, 4, 5, 6 };
        // int key = 6;

        int size;
        System.out.println("Enter the Size of array : ");
        size = sc.nextInt();

        int number[] = new int[size];

        System.out.println("Enter The Element of array : ");
        for (int i = 0; i < size; i++) {
            number[i] = sc.nextInt();
        }

        System.out.println("Enter The Key element in array : ");
        int key = sc.nextInt();

        int index = binarySearch(number, key);

        if (index == -1) {
            System.out.println("The Number is Not Found in array!");
        }
        System.out.println("Number is Found at index : " + index);

    }
}
