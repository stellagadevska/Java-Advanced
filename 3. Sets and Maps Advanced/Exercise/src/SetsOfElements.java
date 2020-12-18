import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class SetsOfElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        int firstSetSize = Integer.parseInt(input.split(" ")[0]);
        int secondSetSize = Integer.parseInt(input.split(" ")[1]);

        Set<Integer> set1 = new LinkedHashSet<>();
        Set<Integer> set2 = new LinkedHashSet<>();

        for (int i = 0; i < firstSetSize; i++) {
            int num = Integer.parseInt(scanner.nextLine());
            set1.add(num);
        }

        for (int i = 0; i < secondSetSize; i++) {
            int num = Integer.parseInt(scanner.nextLine());
            set2.add(num);
        }

        set1.retainAll(set2);

        for (Integer integer : set1) {
            System.out.print(integer + " ");
        }
    }
}
