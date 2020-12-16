import java.util.Scanner;

public class CompareMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[][] firstMatrix = readMatrix(scanner);
        int[][] secondMatrix = readMatrix(scanner);

        boolean areEqual = compareMatrices(firstMatrix, secondMatrix);

        String output = areEqual ? "equal" : "not equal";
        System.out.println(output);
    }

    private static boolean compareMatrices(int[][] firstMatrix, int[][] secondMatrix) {
        // length is the columns
        if (firstMatrix.length != secondMatrix.length) {
            return false;
        }

        for (int row = 0; row < firstMatrix.length; row++) {
            int[] firstArr = firstMatrix[row];
            int[] secondArr = secondMatrix[row];

            if (firstArr.length != secondArr.length) {
                return false;
            }

            for (int col = 0; col < firstArr.length; col++) {
                if (firstArr[col] != secondArr[col]) {
                    return false;
                }
            }
        }

        return true;
    }

    // Read a matrix from the console
    public static int[][] readMatrix(Scanner scanner) {
        // Read a line as an array ( rows and columns)
        String[] tokens = scanner.nextLine().split("\\s+");

        // Split the array
        int rows = Integer.parseInt(tokens[0]);
        int cols = Integer.parseInt(tokens[1]);

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
