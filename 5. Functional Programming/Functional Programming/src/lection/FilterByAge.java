package lection;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FilterByAge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> people = generateMap(scanner);

        String condition = scanner.nextLine();
        int age = Integer.parseInt(scanner.nextLine());
        String format = scanner.nextLine();

        Map<String, Integer> filtered = filterMap(people, condition, age);

        printMap(filtered, format);
    }

    private static Map<String, Integer> generateMap(Scanner scanner) {
        Map<String, Integer> map = new LinkedHashMap<>();
        int numberOfPeople = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numberOfPeople; i++) {
            String[] tokens = scanner.nextLine().split(", ");
            String name = tokens[0];
            int age = Integer.parseInt(tokens[1]);

            map.put(name, age);
        }

        return map;
    }

    private static Map<String, Integer> filterMap(Map<String, Integer> people, String condition, int age) {
        Map<String, Integer> map = new LinkedHashMap<>();

        if (condition.equals("older")) {
            for (var entry : people.entrySet()) {
                if (entry.getValue() >= age) {
                    map.put(entry.getKey(), entry.getValue());
                }
            }
        } else {
            for (var entry : people.entrySet()) {
                if (entry.getValue() <= age) {
                    map.put(entry.getKey(), entry.getValue());
                }
            }
        }

        return map;
    }

    private static void printMap(Map<String, Integer> map, String format) {
        if (format.equals("name")) {
            for (var entry : map.entrySet()) {
                System.out.println(entry.getKey());
            }
        } else if (format.equals("age")) {
            for (var entry : map.entrySet()) {
                System.out.println(entry.getValue());
            }
        } else {
            for (var entry : map.entrySet()) {
                System.out.printf("%s - %d%n", entry.getKey(), entry.getValue());
            }
        }
    }
}
