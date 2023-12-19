public class Staircase_Search {

    public static boolean staircaseSearch(int matrix[][], int key) {
        int row = 0, col = matrix[0].length - 1;

        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] == key) {
                System.out.println("Found at cell (" + row + "," + col + ")");
                return true;
            } else if (key < matrix[row][col]) {
                col--;
            } else {
                row++;
            }
        }
        System.out.println("Key is Not Found");
        return false;
    }

    public static boolean secStaircaseSearchApproach(int matrix[][], int key) {
        int row = matrix.length - 1, col = 0;

        while (row >= 0 && col < matrix.length - 1) {

            if (matrix[row][col] == key) {
                System.out.println("Found at cell (" + row + "," + col + ")");
                return true;
            } else if (key < matrix[row][col]) {
                row--;
            } else {
                col++;
            }

        }
        System.out.println("Key is Not Found");
        return false;
    }

    public static void main(String[] args) {
        int matrix[][] = {
                { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 },
                { 13, 14, 15, 16 }
        };
        staircaseSearch(matrix, 14);
        secStaircaseSearchApproach(matrix, 14);
    }
}
