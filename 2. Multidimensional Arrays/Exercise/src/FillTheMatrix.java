import java.util.Scanner;

public class FillTheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(", ");
        int size = Integer.parseInt(input[0]);
        String type = input[1];

        int[][] matrix = new int[size][size];

        int startNumber = 1;
        if (type.equals("A")) {
            fillPatternA(size, matrix, startNumber);
        } else if (type.equals("B")) {
            fillPatterB(size, matrix, startNumber);
        }

        printMatrix(matrix, size);
    }

    private static void fillPatterB(int size, int[][] matrix, int startNumber) {
        int count = 1;
        for (int col = 0; col < size; col++) {
            if (count % 2 != 0) {
                for (int row = 0; row < size; row++) {
                    matrix[row][col] = startNumber++;
                }
            } else {
                for (int row = size - 1; row >= 0; row--) {
                    matrix[row][col] = startNumber++;
                }
            }
            count++;
        }
    }

    private static void fillPatternA(int size, int[][] matrix, int startNumber) {
        for (int col = 0; col < size; col++) {
            for (int row = 0; row < size; row++) {
                matrix[row][col] = startNumber++;
            }
        }
    }

    private static void printMatrix(int[][] matrix, int size) {
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}
