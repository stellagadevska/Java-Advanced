import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class PoisonousPlants {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfPlants = Integer.parseInt(scanner.nextLine());
        int[] plants = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        int[] days = new int[numberOfPlants];

        Deque<Integer> temp = new ArrayDeque<>();
        temp.push(0);

        for (int i = 1; i < plants.length; i++) {
            int maxDays = 0;


            while (temp.size() > 0 && plants[temp.peek()] >= plants[i]) {
                maxDays = Math.max(maxDays, days[temp.pop()]);
            }

            if (temp.size() > 0) {
                days[i] = maxDays + 1;
            }

            temp.push(i);

        }

        System.out.println(Arrays.stream(days).max().getAsInt());
    }
}
