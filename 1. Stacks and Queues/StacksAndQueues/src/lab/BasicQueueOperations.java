package lab;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class BasicQueueOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] input = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int countToAdd = input[0];
        int countToRemove = input[1];
        int elementToSearch = input[2];

        int[] elements = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        ArrayDeque<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < countToAdd; i++) {
            queue.offer(elements[i]);
        }

        for (int i = 0; i < countToRemove; i++) {
            queue.poll();
        }

        if (queue.isEmpty()) {
            System.out.println("0");
        } else if (queue.contains(elementToSearch)) {
            System.out.println("true");
        } else {
            System.out.println(Collections.min(queue));
        }
    }
}
