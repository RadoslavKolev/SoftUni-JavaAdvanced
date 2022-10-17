package lection;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SumNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Function variable that parses String to int
        Function<String, Integer> parser = Integer::parseInt;

        List<Integer> numbers = Arrays
                .stream(scanner.nextLine().split(", "))
                .map(parser)
                .collect(Collectors.toList());

        int count = numbers.size();
        System.out.printf("Count = %d%n", count);

        // Reduces the list into 1 number, which is the sum of all numbers
        int sum = numbers.stream().reduce(0, Integer::sum);
        System.out.printf("Sum = %d%n", sum);
    }
}
