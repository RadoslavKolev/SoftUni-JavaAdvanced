package lection;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LargestThreeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> sortedNumbers = Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .sorted((num1, num2) -> num2.compareTo(num1))
                .collect(Collectors.toList());

        int size = sortedNumbers.size();
        final int LIMIT = 3;

        if (size < LIMIT) {
            System.out.println(sortedNumbers.toString().replaceAll("[\\[\\],]", ""));
            return;
        }

        for (int i = 0; i < LIMIT; i++) {
            System.out.print(sortedNumbers.get(i) + " ");
        }
    }
}
