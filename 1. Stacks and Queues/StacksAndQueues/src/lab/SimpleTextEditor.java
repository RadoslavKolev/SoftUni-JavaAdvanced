package lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class SimpleTextEditor {
    private static String appendText(String text, String inputText, ArrayDeque<String> stack) {
        text += inputText;
        stack.push(text);
        return text;
    }

    private static String removeElements(String text, int count, ArrayDeque<String> stack) {
        text = text.substring(0, text.length() - count);
        stack.push(text);
        return text;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int operations = Integer.parseInt(scanner.nextLine());
        String text = "";

        ArrayDeque<String> memoryStack = new ArrayDeque<>();
        memoryStack.push(text);

        for (int i = 0; i < operations; i++) {
            String[] input = scanner.nextLine().split(" ");
            int command = Integer.parseInt(input[0]);

            if (command == 1) {
                String inputText = input[1];
                text = appendText(text, inputText, memoryStack);
            } else if (command == 2) {
                int count = Integer.parseInt(input[1]);
                text = removeElements(text, count, memoryStack);
            } else if (command == 3) {
                int index = Integer.parseInt(input[1]);
                System.out.println(text.charAt(index - 1));
            } else {
                memoryStack.pop();
                text = memoryStack.peek();
            }
        }
    }
}
