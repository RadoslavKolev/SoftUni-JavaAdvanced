package lab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ChangeList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String input = scanner.nextLine();

        while (!input.equals("end")) {
            String[] elements = input.split("\\s+");
            String command = elements[0];
            Integer element = Integer.parseInt(elements[1]);

            if (command.equals("Delete")) {
                while (numbers.contains(element)) {
                    numbers.remove(element);
                }
            } else if (command.equals("Insert")) {
                int position = Integer.parseInt(elements[2]);
                numbers.add(position, element);
            }

            input = scanner.nextLine();
        }

        System.out.println(numbers.toString().replaceAll("[\\[\\],]", ""));
    }
}
