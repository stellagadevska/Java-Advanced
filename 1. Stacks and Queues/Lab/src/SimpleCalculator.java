import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;
import java.util.Scanner;

public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] tokens = scanner.nextLine().split("\\s+");

        Deque<String> stack = new ArrayDeque<>();
        // Adds collection to another collection
        Collections.addAll(stack, tokens);

        // 3 + 4 - 2

        // 2
        // -
        // 4
        // +
        // 3

        while (stack.size() > 1) {
            int first = Integer.parseInt(stack.pop());
            String sign = stack.pop();
            int second = Integer.parseInt(stack.pop());

            switch (sign) {
                case "+":
                    stack.push(String.valueOf(first + second));
                    break;
                case "-":
                    stack.push(String.valueOf(first - second));
                    break;
            }
        }

        System.out.println(stack.pop());
    }
}
