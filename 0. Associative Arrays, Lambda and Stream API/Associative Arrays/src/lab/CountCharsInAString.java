package lab;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class CountCharsInAString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] words = scanner.nextLine().split("\\s+");
        LinkedHashMap<Character, Integer> letters = new LinkedHashMap();

        for (String word : words) {
            int len = word.length();

            for (int i = 0; i < len; i++) {
                char symbol = word.charAt(i);

                if (!letters.containsKey(symbol)) {
                    letters.put(symbol, 0);
                }

                letters.put(symbol, letters.get(symbol) + 1);
            }
        }

        letters.forEach(
                (key, value) -> System.out.printf("%s -> %d%n", key, value)
        );
    }
}
