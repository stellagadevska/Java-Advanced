import java.util.Scanner;

public class MatrixShuffling {
    public static int rows = 0;
    public static int cols = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] dimensions = scanner.nextLine().split(" ");
        rows = Integer.parseInt(dimensions[0]);
        cols = Integer.parseInt(dimensions[1]);

        String[][] matrix = new String[rows][cols];

        for (int row = 0; row < rows; row++) {
            matrix[row] = scanner.nextLine().split(" ");
        }

        String command = scanner.nextLine();
        while (!"END".equals(command)) {
            String[] commandLine = command.split(" ");
            if (commandLine[0].equals("swap") && commandLine.length == 5) {
                int row1 = Integer.parseInt(commandLine[1]);
                int col1 = Integer.parseInt(commandLine[2]);
                int row2 = Integer.parseInt(commandLine[3]);
                int col2 = Integer.parseInt(commandLine[4]);

                if (row1 >= 0 && row1 < rows && row2 >= 0 && row2 < rows
                        && col1 >= 0 && col1 < cols && col2 >= 0 && col2 < cols) {
                    swap(row1, col1, row2, col2, matrix);
                    printMatrix(matrix);
                } else {
                    System.out.println("Invalid input!");
                }
            } else {

                System.out.println("Invalid input!");
            }

            command = scanner.nextLine();
        }
    }


    private static void swap(int row1, int col1, int row2, int col2, String[][] matrix) {
        String temp = matrix[row1][col1];
        matrix[row1][col1] = matrix[row2][col2];
        matrix[row2][col2] = temp;
    }


    private static void printMatrix(String[][] matrix) {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

}
