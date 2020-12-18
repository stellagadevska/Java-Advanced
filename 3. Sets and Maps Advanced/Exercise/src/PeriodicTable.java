import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class PeriodicTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<String> chemicalElements = new TreeSet<>();
        int num = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < num; i++) {
            String[] elements = scanner.nextLine().split("\\s+");
            chemicalElements.addAll(Arrays.asList(elements));
        }

        System.out.println(String.join(" ", chemicalElements));
    }
}
