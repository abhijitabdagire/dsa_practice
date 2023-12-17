public class Max_SubArray_Product {
    public static int maxProduct(int[] nums) {
        int maxProduct = Integer.MIN_VALUE;
        int currProduct = 1;

        for (int i = 0; i < nums.length; i++) {
            currProduct = currProduct * nums[i];

            if (currProduct < 0) {
                currProduct = 0;
            }

            maxProduct = Math.max(currProduct, maxProduct);
        }

        return maxProduct;

    }

    public static void main(String args[]) {
        int nums[] = { 2, 3, -2, 4 };
        System.out.println("Max Product SubArray is " + maxProduct(nums));
    }
}
