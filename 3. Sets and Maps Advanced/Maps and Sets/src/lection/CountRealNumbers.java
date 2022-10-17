package lection;

import java.util.*;

public class CountRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<Double, Integer> occurrences = new LinkedHashMap<>();

        Arrays
            .stream(scanner.nextLine().split("\\s+"))
            .mapToDouble(Double::parseDouble)
            .forEach(n -> {
                occurrences.putIfAbsent(n, 0);
                occurrences.put(n, occurrences.get(n) + 1);
            });

        for (var entry : occurrences.entrySet()) {
            System.out.println(String.format("%.1f -> %d", entry.getKey(), entry.getValue()));
        }
    }
}
