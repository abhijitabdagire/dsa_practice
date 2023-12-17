public class Given_Pair_Sum {

    public static boolean givenPairSum(int arr[], int target) {
        for (int i = 0; i < arr.length; i++) {
            int curr = arr[i];

            for (int j = i + 1; j < arr.length; j++) {
                int sumIS = curr + arr[j];

                if (sumIS == target) {
                    return true;
                }
                // System.out.println("There is a pair " + "(" + curr + "," + arr[j] + ")");
            }
        }
        return false;
    }

    public static void main(String args[]) {
        int arr[] = { 11, 15, 26, 38, 9, 10 };
        int target = 45;
        // System.out.println("Given pair Sum is " + givenPairSum(arr, target));
        System.out.println("Given Pair of Sum is " + givenPairSum(arr, target));
        ;
    }
}
