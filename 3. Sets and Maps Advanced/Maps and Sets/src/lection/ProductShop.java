package lection;

import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.TreeMap;

public class ProductShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TreeMap<String, LinkedHashMap<String, Double>> shops = new TreeMap<>();

        String input = scanner.nextLine();

        while (!input.equals("Revision")) {
            String[] tokens = input.split(", ");
            String store = tokens[0];
            String product = tokens[1];
            Double price = Double.parseDouble(tokens[2]);

            shops.putIfAbsent(store, new LinkedHashMap<>());
            shops.get(store).put(product, price);

            input = scanner.nextLine();
        }

        for (var entry : shops.entrySet()) {
            System.out.printf("%s->%n", entry.getKey());

            for (var innerEntry : entry.getValue().entrySet()) {
                System.out.printf("Product: %s, Price: %.1f%n", innerEntry.getKey(), innerEntry.getValue());
            }
        }
    }
}
