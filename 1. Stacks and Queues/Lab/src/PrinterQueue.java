import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class PrinterQueue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deque<String> printSessions = new ArrayDeque<>();
        String command = scanner.nextLine();

        while (!command.equals("print")) {
            if (command.equals("cancel")) {
                if (printSessions.isEmpty()) {
                    System.out.println("Printer is on standby");
                } else {
                    String session = printSessions.poll();
                    System.out.printf("Canceled %s%n", session);
                }
            } else {
                printSessions.offer(command);
            }
            command = scanner.nextLine();
        }

        while (!printSessions.isEmpty()) {
            System.out.println(printSessions.poll());
        }
    }
}
