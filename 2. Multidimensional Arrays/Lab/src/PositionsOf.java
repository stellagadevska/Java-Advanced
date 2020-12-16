import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PositionsOf {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read a line as an array ( rows and columns)
        String[] tokens = scanner.nextLine().split("\\s+");

        // Split the array
        int rows = Integer.parseInt(tokens[0]);
        int cols = Integer.parseInt(tokens[1]);

        int[][] matrix = readMatrix(scanner, rows, cols);

        int num = Integer.parseInt(scanner.nextLine());

        List<int[]> indexes = new ArrayList<>();

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                int currentNumber = matrix[row][col];
                if (currentNumber == num) {
                    int[] rowsAndCols = {row, col};
                    indexes.add(rowsAndCols);
                }
            }
        }

        if (indexes.isEmpty()) {
            System.out.println("not found");
        } else {
            for (int[] index : indexes) {
                System.out.println(index[0] + " " + index[1]);
            }
        }

        // or with a flag boolean isFound
    }

    // Read a matrix from the console
    public static int[][] readMatrix(Scanner scanner, int rows, int cols) {

        // Create new matrix with given rows and cols
        int[][] matrix = new int[rows][cols];

        // Iterate through the matrix and store into matrix
        for (int r = 0; r < rows; r++) {
            String[] line = scanner
                    .nextLine()
                    .split("\\s+");
            for (int c = 0; c < cols; c++) {
                matrix[r][c] = Integer.parseInt(line[c]);
            }
        }

        return matrix;

        // Other way
//        int[][] matrix = new int[rows][cols];
//
//        for (int i = 0; i < rows; i++) {
//            int[] arr = Arrays.stream(scanner.nextLine().split("\\s+"))
//                    .mapToInt(Integer::parseInt)
//                    .toArray();
//
//            matrix[i] = arr;
//        }
    }
}
