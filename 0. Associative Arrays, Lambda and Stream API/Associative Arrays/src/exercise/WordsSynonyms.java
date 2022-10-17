package exercise;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class WordsSynonyms {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        LinkedHashMap<String, ArrayList<String>> words = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String word = scanner.nextLine();
            String synonym = scanner.nextLine();

            words.putIfAbsent(word, new ArrayList<>());
            words.get(word).add(synonym);
        }

        for (Map.Entry<String, ArrayList<String>> entry : words.entrySet()) {
            System.out.print(entry.getKey() + " - " + String.join(", ", entry.getValue()));
            System.out.println();
        }
    }
}
