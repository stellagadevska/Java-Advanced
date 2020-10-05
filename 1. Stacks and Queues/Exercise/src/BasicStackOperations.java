import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class BasicStackOperations {
    public static void main(String[] args) {
        // N - number of elements to push onto the stack
        // S - number of elements to pop from the stack
        // X - element that you should check whether is present in the stack

        // If it is, print true on the console. If it’s not, print the smallest element currently present in the stack.

        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        String[] input = scanner.nextLine().split("\\s+");
        int N = Integer.parseInt(input[0]);
        int S = Integer.parseInt(input[1]);
        int X = Integer.parseInt(input[2]);

        String[] numbers = scanner.nextLine().split("\\s+");

        // N
        for (int i = 0; i < N; i++) {
            stack.push(Integer.parseInt(numbers[i]));
        }

        // S
        for (int i = 0; i < S; i++) {
            stack.pop();
        }

        // X
        if (stack.isEmpty()) {
            System.out.println(0);
        } else {
            if (stack.contains(X)) {
                System.out.println("true");
            } else {
                System.out.println(Collections.min(stack));
            }

        }

    }
}
