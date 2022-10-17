package exercise.collection;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();

        List<String> data = Arrays.stream(command.split("\\s+"))
                .skip(1)    // skips the 1 element (Create)
                .collect(Collectors.toList());

        ListyIterator listyIterator = new ListyIterator(data);

        command = scanner.nextLine();

        while (!command.equals("END")) {
            switch (command) {
                case "Move":
                    System.out.println(listyIterator.move());
                    break;
                case "HasNext":
                    System.out.println(listyIterator.iterator().hasNext());
                    break;
                case "Print":
                    try {
                        listyIterator.print();
                    } catch (IllegalStateException ex) {
                        System.out.println("Invalid Operation");
                    }
                    break;
                case "PrintAll":
                    for (String element : listyIterator) {
                        System.out.print(element + " ");
                    }

                    System.out.println();
                    break;
                default:
                    System.out.println("No such command!");
            }

            command = scanner.nextLine();
        }
    }
}
