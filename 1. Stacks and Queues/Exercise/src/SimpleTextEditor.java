import java.util.ArrayDeque;
import java.util.Scanner;

public class SimpleTextEditor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numOfOperations = Integer.parseInt(scanner.nextLine());

        String text = "";
        ArrayDeque<String> history = new ArrayDeque<>();


        for (int i = 0; i < numOfOperations; i++) {
            String input = scanner.nextLine();
            String[] tokens = input.split("\\s+");
            int operation = Integer.parseInt(tokens[0]);

            switch (operation) {
                case 1:
                    history.push(text);
                    String append = tokens[1];
                    text += append;
                    break;
                case 2:
                    history.push(text);
                    int count = Integer.parseInt(tokens[1]);
                    for (int j = 0; j < count; j++) {
                        text = text.substring(0,text.length() - 1);
                    }
                    break;
                case 3:
                    int index = Integer.parseInt(tokens[1]) - 1;
                    String elementAtIndex = text.substring(index, index + 1);

                    System.out.println(elementAtIndex);
                    break;
                case 4:
                    // undo
                    text = history.pop();
                    break;


            }

            //• "1 [string]" - appends [string] to the end of the text
            //•	"2 [count]" - erases the last [count] elements from the text
            //•	"3 [index]" - returns the element at position [index] from the text
            //•	"4" - undoes the last not-undone command of type 1 or 2 and returns the text to the state before that operation
        }
    }
}
