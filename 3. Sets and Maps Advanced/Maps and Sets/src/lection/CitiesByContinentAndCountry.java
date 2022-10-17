package lection;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class CitiesByContinentAndCountry {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int iterations = Integer.parseInt(scanner.nextLine());

        LinkedHashMap<String, LinkedHashMap<String, ArrayList<String>>> continents = new LinkedHashMap<>();

        for (int i = 0; i < iterations; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String continent = tokens[0];
            String country = tokens[1];
            String city = tokens[2];

            continents.putIfAbsent(continent, new LinkedHashMap<>());
            continents.get(continent).putIfAbsent(country, new ArrayList<>());
            continents.get(continent).get(country).add(city);
        }

        for (var entry : continents.entrySet()) {
            System.out.printf("%s:%n", entry.getKey());

            for (var innerEntry : entry.getValue().entrySet()) {
                System.out.printf("  %s -> ", innerEntry.getKey());
                System.out.println(String.join(", ", innerEntry.getValue()));
            }
        }
    }
}
