package lab;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class BasicStackOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");

        int[] elements = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int pushCount = Integer.parseInt(input[0]);
        int popCount = Integer.parseInt(input[1]);
        int elementToSearch = Integer.parseInt(input[2]);

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < pushCount; i++) {
            stack.push(elements[i]);
        }

        for (int i = 0; i < popCount; i++) {
            stack.pop();
        }

        if (stack.isEmpty()) {
            System.out.println("0");
        } else if (stack.contains(elementToSearch)) {
            System.out.println("true");
        } else {
            System.out.println(Collections.min(stack));
        }
    }
}
