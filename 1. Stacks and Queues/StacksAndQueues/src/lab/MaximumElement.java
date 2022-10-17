package lab;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class MaximumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = Integer.parseInt(scanner.nextLine());

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < count; i++) {
            int[] numbers = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            int command = numbers[0];

            if (command == 1) {
                stack.push(numbers[1]);
            } else if (command == 2) {
                stack.pop();
            } else {
                System.out.println(Collections.max(stack));
            }
        }
    }
}
