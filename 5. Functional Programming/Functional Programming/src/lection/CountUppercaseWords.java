package lection;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class CountUppercaseWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Predicate<String> checkIfUpper = word -> Character.isUpperCase(word.charAt(0));

        String[] words = scanner.nextLine().split("\\s+");
        List<String> upperWords = new ArrayList<>();

        for (String word : words) {
            if (checkIfUpper.test(word)) {
                upperWords.add(word);
            }
        }

        System.out.println(upperWords.size());

        upperWords.forEach(System.out::println);
    }
}
