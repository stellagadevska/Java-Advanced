import java.util.ArrayDeque;
import java.util.Scanner;

public class DecimalToBinary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> binaryStack = new ArrayDeque<>();

        // read decimal number
        int decimal = Integer.parseInt(scanner.nextLine());

        // convert

        // 10 / 2 -> 5 /2 ->
        while (decimal != 0) {
            binaryStack.push(decimal % 2);
            decimal /= 2;
        }

        // print binary number
        while (!binaryStack.isEmpty()) {
            System.out.print(binaryStack.pop());
        }
    }
}
