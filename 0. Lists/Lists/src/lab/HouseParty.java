package lab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HouseParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int commands = Integer.parseInt(scanner.nextLine());

        List<String> guests = new ArrayList<>();

        for (int i = 0; i < commands; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            String name = input[0];

            if (input.length == 3) {
                if (guests.contains(name)) {
                    System.out.printf("%s is already in the list!\n", name);
                } else {
                    guests.add(name);
                }
            } else if (input.length == 4) {
                if (!guests.contains(name)) {
                    System.out.printf("%s is not in the list!\n", name);
                } else {
                    guests.remove(name);
                }
            }
        }

        guests.forEach(el -> System.out.println(el));
    }
}
