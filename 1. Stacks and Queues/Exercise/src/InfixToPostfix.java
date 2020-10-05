import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class InfixToPostfix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read expression
        String[] expression = scanner.nextLine().split("\\s+");

        Deque<String> outputQueue = new ArrayDeque<>();
        Deque<String> operatorStack = new ArrayDeque<>();

        // Convert
        for (String s : expression) {
            String token = String.valueOf(s);

            switch (token) {
                case "+":
                case "-":
                    while (!operatorStack.isEmpty() && !operatorStack.peek().equals("(")) {
                        outputQueue.offer(operatorStack.pop());
                    }
                    operatorStack.push(token);
                    break;
                case "*":
                case "/":
                    if ((operatorStack.peek().equals("*")) || (operatorStack.peek().equals("/"))) {
                        outputQueue.offer(operatorStack.pop());
                        operatorStack.push(token);
                    } else {
                        operatorStack.push(token);
                    }
                    break;
                case "(":
                    operatorStack.push(token);
                    break;
                case ")":
                    while (!(operatorStack.peek().equals("("))) {
                        outputQueue.offer(operatorStack.pop());
                    }
                    if ((operatorStack.peek().equals("(")))
                        operatorStack.pop();
                    break;
                default:
                    outputQueue.offer(token);
                    break;
            }
        }
        while (!operatorStack.isEmpty()) {
            outputQueue.offer(operatorStack.pop());
        }

        // Output
        while (!outputQueue.isEmpty()) {
            System.out.print(outputQueue.poll() + " ");
        }

    }
}

