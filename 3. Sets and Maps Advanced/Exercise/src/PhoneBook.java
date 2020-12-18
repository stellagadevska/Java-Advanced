import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class PhoneBook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, String> phoneBook = new LinkedHashMap<>();


        while (true) {
            String input = scanner.nextLine();

            if (input.equals("search")) {
                String searchedName = scanner.nextLine();
                while (!searchedName.equals("stop")) {
                    if (!phoneBook.containsKey(searchedName)) {
                        System.out.println("Contact " + searchedName + " does not exist.");
                    } else {
                        System.out.println(searchedName + " -> " + phoneBook.get(searchedName));
                    }
                    searchedName = scanner.nextLine();
                }
                break;
            } else {
                String[] parts = input.split("-");
                String name = parts[0];
                String number = parts[1];

                phoneBook.put(name, number);
            }
        }
    }
}
