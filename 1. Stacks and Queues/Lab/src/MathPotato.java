import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;
import java.util.Scanner;

public class MathPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deque<String> children = new ArrayDeque<>();

        String[] names = scanner.nextLine().split("\\s+");
        int tossCount = Integer.parseInt(scanner.nextLine());

        // Adds collection to another collection
        Collections.addAll(children, names);

        int cycle = 1;
        while (children.size() > 1) {

            for (int i = 1; i < tossCount; i++)
                children.offer(children.poll());

            if (isPrime(cycle)) {
                System.out.println("Prime " + children.peek());
            } else {
                System.out.println("Removed " + children.poll());
            }

            cycle++;
        }

        System.out.println("Last is " + children.poll());
    }

    private static boolean isPrime(int cycle) {
        int m = 0;
        int flag = 0;

        m = cycle/ 2;

        if (cycle == 0 || cycle == 1) {
            return false;
        } else  {
            for (int i = 2; i <= m; i++) {
                if (cycle % i == 0) {
                    flag = 1;
                    break;
                }
            }

        }

        return flag == 0;
    }


}
