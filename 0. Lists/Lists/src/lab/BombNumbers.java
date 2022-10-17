package lab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BombNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int[] data = Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int bomb = data[0];
        int power = data[1];

        while (numbers.contains(bomb)) {
            int bombIndex = numbers.indexOf(bomb);
            int start = bombIndex - power;
            int end = bombIndex + power;

            // prevents OutOfBounds
            if (start < 0) start = 0;
            if (end >= numbers.size()) end = numbers.size() - 1;

            int index = start;

            for (int i = start; i <= end ; i++) {
                numbers.remove(index);
            }
        }

        int sum = numbers.stream().reduce(0, (a, b) -> a + b);
        System.out.println(sum);
    }
}
