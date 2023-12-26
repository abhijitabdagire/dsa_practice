import java.util.Scanner;

public class Basic_Strings {

    public static void printStringChar(String str) {
        for (int i = 0; i < str.length(); i++) {
            System.out.print(str.charAt(i) + " ");
        }
    }

    public static void main(String[] args) {

        char arr[] = { 'a', 'b', 'c', 'd' };

        String str1 = "abcd";
        String str2 = new String("xyz");

        // String are IMMUTABLE

        // Input
        Scanner sc = new Scanner(System.in);
        // String name = sc.next(); -> Only one word are input
        // if we have input line so that another function which is nextLine()
        // System.out.println("Enter The Name : ");
        // String name = sc.nextLine();
        // System.out.println(name);

        // Contraction (+)
        String firstName = "Abhijit";
        String lastName = "Abdagire";

        String fullName = firstName + " " + lastName;
        System.out.println(fullName);

        printStringChar(fullName);

    }
}
