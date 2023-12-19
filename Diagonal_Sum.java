public class Diagonal_Sum {

    // O(n`2)
    public static int digonalSum(int matrix[][]) {

        int sum = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (i == j) {
                    sum += matrix[i][j];
                } else if (i + j == matrix.length - 1) {
                    sum += matrix[i][j];
                }
            }
        }
        return sum;
    }

    public static int optimal_digonalSum(int matrix[][]) {
        int addition = 0;
        for (int i = 0; i < matrix.length; i++) {
            addition += matrix[i][i];

            addition += matrix[i][matrix.length - i - 1];
        }
        return addition;
    }

    public static void main(String[] args) {
        int matrix[][] = {
                { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 },
                { 13, 14, 15, 16 }
        };
        System.out.println(digonalSum(matrix));
        System.out.print("The Optimal Solution for Diagonal Sum is : ");
        System.out.print(optimal_digonalSum(matrix));
    }
}
