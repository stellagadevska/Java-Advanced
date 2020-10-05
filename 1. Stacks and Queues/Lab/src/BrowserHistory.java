import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> history = new ArrayDeque<>();
        String current = "";

        String navigation = scanner.nextLine();
        while (!navigation.equals("Home")) {
            if (navigation.equals("back")) {
                if (history.isEmpty()) {
                    System.out.println("no previous URLs");
                    navigation = scanner.nextLine();
                    continue;
                } else {
                    current = history.pop();
                }
            } else {
                if (!current.isEmpty()) {
                    history.push(current);
                }

                current = navigation;
            }

            navigation = scanner.nextLine();

            System.out.println(current);
        }
    }
}
