public class Recusion_printDec {

    public static void printDec(int n) {
        // Base Case
        if (n == 1) {
            System.out.println(n);
            return;
        }
        // Kaaam
        System.out.print(n + " ");
        // Inner calls
        printDec(n - 1);
    }

    public static void main(String[] args) {
        int n = 10;
        printDec(n);
    }
}
