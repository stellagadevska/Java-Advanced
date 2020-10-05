import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;
import java.util.Scanner;

public class HotPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deque<String> children = new ArrayDeque<>();

        String[] names = scanner.nextLine().split("\\s+");
        int tossCount = Integer.parseInt(scanner.nextLine());

        // Adds collection to another collection
        Collections.addAll(children, names);

        while(children.size() > 1) {
            // penka ivanka gosho dida
            // 2
            for (int i = 1; i < tossCount; i++) {
                children.offer(children.poll());
            }
            System.out.println("Removed " + children.poll());
        }

        System.out.println("Last is " + children.poll());
    }
}
