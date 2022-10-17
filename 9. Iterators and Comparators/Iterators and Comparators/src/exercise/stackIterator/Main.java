package exercise.stackIterator;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Stack stack = new Stack();

        String input = scanner.nextLine();

        while (!input.equals("END")) {
            String[] tokens = input.split("\\s+");
            String command = tokens[0];

            List<Integer> numbers = Arrays.stream(tokens)
                    .skip(1)
                    .map(el -> el.replace(",", ""))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());

            switch (command) {
                case "Push":
                    for (int number : numbers) {
                        stack.push(number);
                    }

                    break;
                case "Pop":
                    stack.pop();
                    break;
                default:
                    System.out.println("No such command!");
            }

            input = scanner.nextLine();
        }

        for (Integer number : stack) {
            System.out.println(number);
        }

        for (Integer number : stack) {
            System.out.println(number);
        }
    }
}
