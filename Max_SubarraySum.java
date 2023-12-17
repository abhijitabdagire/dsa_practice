import java.util.*;

public class Max_SubarraySum {

    public static void maxSubarraySum(int number[]) {
        int currSum = 0;
        int maxSum = Integer.MIN_VALUE;
        int prefix[] = new int[number.length];

        prefix[0] = number[0];
        for (int i = 1; i < number.length; i++) {
            prefix[i] = prefix[i - 1] + number[i];
        }

        for (int i = 0; i < number.length; i++) {
            int start = i;

            for (int j = i; j < number.length; j++) {
                int end = j;
                currSum = 0;
                // for (int k = start; k <= end; k++) {

                // currSum += number[k];
                // }
                // time complexity is O(n`3)

                currSum = start == 0 ? prefix[end] : prefix[end] - prefix[start - 1];

                // System.out.println(currSum);

                if (maxSum < currSum) {
                    maxSum = currSum;
                }
            }
        }
        System.out.println("Max Subarray sum is : " + maxSum);
    }

    public static void kadanes(int number[]) {
        int ms = Integer.MIN_VALUE;
        int cs = 0;

        for (int i = 0; i < number.length; i++) {
            cs = cs + number[i];

            if (cs < 0) {
                cs = 0;
            }
            ms = Math.max(cs, ms);
        }

        System.out.println("MAX SUBARRAY SUM BY USING KANADES ALGO. IS : " + ms);
    }

    public static void main(String args[]) {
        int number[] = { -2, -3, 4, -1, -2, 1, 5, -3 };
        maxSubarraySum(number);
        kadanes(number);
    }
}
