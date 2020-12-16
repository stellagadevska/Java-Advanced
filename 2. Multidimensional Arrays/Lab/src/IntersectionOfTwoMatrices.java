import java.util.Scanner;

public class IntersectionOfTwoMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());
        int cols = Integer.parseInt(scanner.nextLine());

        char[][] matrixOne = readMatrix(scanner, rows, cols);
        char[][] matrixTwo = readMatrix(scanner, rows, cols);

        char[][] output = new char[rows][cols];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                output[row][col] =
                        matrixOne[row][col] == matrixTwo[row][col]
                                ? matrixOne[row][col]
                                : '*';
            }
        }

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                char symbol = output[row][col];
                if (col == cols - 1) {
                    System.out.print("*");
                } else {
                    System.out.print(symbol + " ");
                }
            }
            System.out.println();
        }

    }

    private static char[][] readMatrix(Scanner scanner, int rows, int cols) {
        char[][] matrix = new char[rows][cols];

        for (int row = 0; row < rows; row++) {
            String[] symbols = scanner.nextLine().split("\\s+");
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = symbols[col].charAt(0);
            }
        }

        return matrix;
    }


}
