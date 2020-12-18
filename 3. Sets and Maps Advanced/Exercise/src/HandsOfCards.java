import java.util.*;

public class HandsOfCards {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Set<String>> playersPoints = new LinkedHashMap<>();

        String input = scanner.nextLine();

        while (!input.equals("JOKER")) {
            // Pesho: 2C, 4H, 9H, AS, QS
            String[] parts = input.split(": ");
            String name = parts[0];
            String[] cardsArray = parts[1].split(", ");

            Set<String> cards = new HashSet<>(Arrays.asList(cardsArray));

            if (!playersPoints.containsKey(name)) {
                playersPoints.put(name, cards);
            } else {
                Set<String> currentCards = playersPoints.get(name);
                currentCards.addAll(cards);
                playersPoints.put(name, currentCards);
            }
            input = scanner.nextLine();
        }

        // name -> cards
        for (Map.Entry<String, Set<String>> player : playersPoints.entrySet()) {
            int points = calculatePoints(player.getValue());
            System.out.printf("%s: %d%n", player.getKey(), points);
        }
    }

    private static int calculatePoints(Set<String> cards) {
        int sum = 0;
        Map<Character, Integer> powers = getLettersPower();
        for (String card : cards) {
            if (card.contains("10")) {
                sum += 10 * powers.get(card.charAt(2));
                continue;
            }
            char first = card.charAt(0);
            char second = card.charAt(1);

            sum += powers.get(first) * powers.get(second);
        }

        return sum;
    }

    private static HashMap<Character, Integer> getLettersPower(){
        HashMap<Character, Integer> powers = new HashMap<>();
        powers.put('1', 1);
        powers.put('2', 2);
        powers.put('3', 3);
        powers.put('4', 4);
        powers.put('5', 5);
        powers.put('6', 6);
        powers.put('7', 7);
        powers.put('8', 8);
        powers.put('9', 9);
        powers.put('J', 11);
        powers.put('Q', 12);
        powers.put('K', 13);
        powers.put('A', 14);
        powers.put('S', 4);
        powers.put('H', 3);
        powers.put('D', 2);
        powers.put('C', 1);

        return powers;
    }
}
