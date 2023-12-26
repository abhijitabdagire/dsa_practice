public class Basic_StringSec {

    public static String printSubtring(String str, int si, int ei) {
        String substr = "";
        for (int i = si; i < ei; i++) {
            substr += str.charAt(i);
        }
        return substr;
    }

    public static void main(String[] args) {

        // Compare String
        String str1 = "Abhi";
        String str2 = "Abhi";

        String str3 = new String("Abhi");

        // Here print the first part beacuse of same pointing loaction in memory
        if (str1 == str2) {
            System.out.println("String are Equals");
        } else {
            System.out.println("String are Not Equals");
        }

        // Here print the else part becuase of new location is created...
        if (str1 == str3) {
            System.out.println("String are Equals");
        } else {
            System.out.println("String are Not Equals");
        }

        // SubString
        String temp = "HelloWorld";
        System.out.println(printSubtring(temp, 0, 5));

        // StringBuilder
        StringBuilder sb = new StringBuilder("");
        for (char ch = 'a'; ch <= 'z'; ch++) {
            sb.append(ch);
        }
        // time complexity - O(26)
        // O(n^2)
        System.out.println(sb);
    }

}
