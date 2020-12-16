import java.util.ArrayDeque;
import java.util.Scanner;

public class FindTheRealQueen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char[][] matrix = new char[8][8];
        ArrayDeque<Integer> queueOfQueens = new ArrayDeque<>();

        for (int row = 0; row < matrix.length; row++) {
            String[] inputCharStr = scanner.nextLine().split(" ");
            for (int col = 0; col < inputCharStr.length; col++) {

                char checkForQueen = inputCharStr[col].charAt(0);
                // If char is 'q', save row and row in queue
                if (checkForQueen == 'q') {
                    queueOfQueens.offer(row);
                    queueOfQueens.offer(col);
                }
                matrix[row][col] = inputCharStr[col].charAt(0);
            }
        }

        boolean fakeQueen;

        while (!queueOfQueens.isEmpty()) {

            // check every direction

            fakeQueen = false;
            int rowToCheck = queueOfQueens.poll();
            int colToCheck = queueOfQueens.poll();

            // From left to q
            for (int col = 0; col < colToCheck; col++) {
                if (matrix[rowToCheck][col] == 'q') {
                    fakeQueen = true;
                    break;
                }
            }

            // From q to right end
            for (int col = colToCheck + 1; col < 8; col++) {
                if (matrix[rowToCheck][col] == 'q') {
                    fakeQueen = true;
                    break;
                }
            }

            // From up to q
            for (int row = 0; row < rowToCheck; row++) {
                if (matrix[row][colToCheck] == 'q') {
                    fakeQueen = true;
                    break;
                }
            }

            // From q to down
            for (int row = rowToCheck + 1; row < 8; row++) {
                if (matrix[row][colToCheck] == 'q') {
                    fakeQueen = true;
                    break;
                }
            }


            int counter = rowToCheck;
            for (int col = colToCheck + 1; col < 8; col++) { //from q to Right Down
                counter++;
                if (counter > 7) {
                    break;
                }
                if (matrix[counter][col] == 'q') {
                    fakeQueen = true;
                    break;
                }
            }

            counter = rowToCheck;
            for (int col = colToCheck - 1; col >= 0; col--) { //from q to Left Up
                counter--;
                if (counter < 0) {
                    break;
                }
                if (matrix[counter][col] == 'q') {
                    fakeQueen = true;
                    break;
                }
            }

            counter = rowToCheck;
            for (int col = colToCheck + 1; col < 8; col++) { //from q to Right Up
                counter--;
                if (counter < 0) {
                    break;
                }
                if (matrix[counter][col] == 'q') {
                    fakeQueen = true;
                    break;
                }
            }

            counter = rowToCheck;
            for (int col = colToCheck - 1; col >= 0; col--) { //from q to Left Down
                counter++;
                if (counter > 7) {
                    break;
                }
                if (matrix[counter][col] == 'q') {
                    fakeQueen = true;
                    break;
                }
            }


            if (!fakeQueen) {
                System.out.print(rowToCheck + " ");
                System.out.print(colToCheck);
                System.out.println();
            }
        }
    }
}