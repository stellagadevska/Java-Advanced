import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistoryUpgrade {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // used as a stack
        ArrayDeque<String> history = new ArrayDeque<>();
        // used as a queue
        ArrayDeque<String> forwardInfo = new ArrayDeque<>();
        String current = "";

        String navigation = scanner.nextLine();
        while (!navigation.equals("Home")) {
            if (navigation.equals("back")) {
                if (history.isEmpty()) {
                    System.out.println("no previous URLs");
                    navigation = scanner.nextLine();
                    continue;
                } else {
                    if (current != null) {
                        forwardInfo.push(current);
                    }
                    current = history.pop();
                }
            } else if (navigation.equals("forward")) {
                if (forwardInfo.isEmpty()) {
                    System.out.println("no next URLs");
                    navigation = scanner.nextLine();
                    continue;
                } else {
                    if (current != null) {
                        history.push(current);
                    }
                    current = forwardInfo.poll();
                }
            } else {
                if (!current.isEmpty()) {
                    history.push(current);
                    if (!forwardInfo.isEmpty()) {
                        forwardInfo.clear();
                    }
                }

                current = navigation;
            }

            System.out.println(current);

            navigation = scanner.nextLine();
        }
    }
}
