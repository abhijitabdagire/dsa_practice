import java.util.*;

class Pair {
    int max;
    int min;
}

public class Max_Min_Array {

    static Pair max_minElementArray(int number[]) {
        Pair minmax = new Pair();
        Arrays.sort(number);
        minmax.min = number[0];
        minmax.max = number[number.length - 1];
        return minmax;

    }

    public static void main(String args[]) {
        int number[] = { 7, 6, 4, 2, 3, 4 };
        Pair minmax = max_minElementArray(number);
        System.out.println("Minimum element is " + minmax.min);
        System.out.println("Maximum element is " + minmax.max);
    }

}
