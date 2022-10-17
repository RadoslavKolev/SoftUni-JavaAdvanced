package lection;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SortEvenNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> evenNumbers = Arrays
                .stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt)
                .filter(num -> num % 2 == 0)
                .collect(Collectors.toList());

        System.out.println(String.join(", ", evenNumbers.toString().replaceAll("[\\[\\]]", "")));

        evenNumbers.sort(Integer::compareTo);

        System.out.println(String.join(", ", evenNumbers.toString().replaceAll("[\\[\\]]", "")));
    }
}
