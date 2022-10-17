package lab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String input = scanner.nextLine();

        while (!input.equals("End")) {
            String[] elements = input.split("\\s+");
            String command = elements[0];

            switch(command) {
                case "Add":
                    int numberToAdd = Integer.parseInt(elements[1]);
                    numbers.add(numberToAdd);
                    break;
                case "Insert":
                    int numberToInsert = Integer.parseInt(elements[1]);
                    int indexToInsert = Integer.parseInt(elements[2]);

                    if (indexToInsert < 0 || indexToInsert >= numbers.size()) {
                        System.out.println("Invalid index");
                        break;
                    }

                    numbers.add(indexToInsert, numberToInsert);
                    break;
                case "Remove":
                    int indexToRemove = Integer.parseInt(elements[1]);

                    if (indexToRemove < 0 || indexToRemove >= numbers.size()) {
                        System.out.println("Invalid index");
                        break;
                    }

                    numbers.remove(indexToRemove);
                    break;
                case "Shift":
                    String command2 = elements[1];
                    int count = Integer.parseInt(elements[2]);

                    if (command2.equals("left")) {
                        int firstIndex = 0;

                        for (int i = 0; i < count; i++) {
                            int currentNum = numbers.get(firstIndex);
                            numbers.remove(firstIndex);
                            numbers.add(currentNum);
                        }
                    } else if (command2.equals("right")) {
                        int lastIndex = numbers.size() - 1;

                        for (int i = 0; i < count; i++) {
                            int currentNum = numbers.get(lastIndex);
                            numbers.remove(lastIndex);
                            numbers.add(0, currentNum);
                        }
                    }
                    break;
                default:
                    System.out.println("No such command!");
            }

            input = scanner.nextLine();
        }

        System.out.println(numbers.toString().replaceAll("[\\[\\],]", ""));
    }
}
