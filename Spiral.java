public class Spiral {

    public static void printSpiral(int matrix[][]) {
        int startRow = 0;
        int startCol = 0;
        int endRow = matrix.length - 1;
        int endCol = matrix[0].length - 1;

        while (startRow <= endRow && startCol <= endCol) {
            // i is for Row
            // j is for Col

            // top - constant is startRow
            for (int j = startCol; j <= endCol; j++) {
                System.out.print(matrix[startRow][j] + " ");

            }

            // right - constant is endCol
            for (int i = startRow + 1; i <= endRow; i++) {
                System.out.print(matrix[i][endCol] + " ");

            }

            // bottom - constant is endRow
            for (int j = endCol - 1; j >= startCol; j--) {
                if (startRow == endRow) {
                    break;
                }
                System.out.print(matrix[endRow][j] + " ");

            }

            // Left - constant is startCol
            for (int i = endRow - 1; i >= startRow + 1; i--) {
                if (startCol == endCol) {
                    break;
                }
                System.out.print(matrix[i][startCol] + " ");

            }

            startRow++;
            startCol++;
            endRow--;
            endCol--;
        }

    }

    public static void main(String[] args) {
        int matrix[][] = {
                { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 },
                { 13, 14, 15, 16 }
        };
        System.out.print("Spiral Matrix is : ");
        printSpiral(matrix);
    }
}
