package exercise;

import java.util.Arrays;
import java.util.Scanner;

public class WordFilter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] filteredWords = Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .filter(word -> word.length() % 2 == 0)
                .toArray(String[]::new);

        for (String word : filteredWords) {
            System.out.println(word);
        }
    }
}
