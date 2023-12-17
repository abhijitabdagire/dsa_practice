import java.util.*;

public class Linear_Search {

    public static int linearSearch(int number[], int key) {
        for (int i = 0; i < number.length; i++) {

            if (number[i] == key) {
                return i;
            }

        }
        return -1;

    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        // int number[];

        System.out.print("Enter Size of Array : ");
        int size = sc.nextInt();

        int number[] = new int[size];

        System.out.println("Enter the Number of array : ");
        for (int i = 0; i < size; i++) {
            number[i] = sc.nextInt();
        }

        System.out.println("Enter the key :");
        int key = sc.nextInt();

        // int number[] = {10,20,60,30,80,90}
        // int key = 30;

        int index = linearSearch(number, key);

        if (index == -1) {
            System.out.println("Number is NOT Found");
        } else {
            System.out.println("Key is Found at index is: " + index);

        }
    }
}