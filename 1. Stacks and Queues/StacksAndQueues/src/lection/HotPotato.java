package lection;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class HotPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] children = scanner.nextLine().split(" ");
        int turns = Integer.parseInt(scanner.nextLine());

        ArrayDeque<String> queue = new ArrayDeque<>();

        // Adds all elements in the queue
        Collections.addAll(queue, children);

        // While there is only 1 child in the queue
        while (queue.size() != 1) {
            // Pass the potato, until we reach turns
            for (int i = 1; i < turns; i++) {
                // Takes the first child and puts him in last position
                String currentChild = queue.poll();
                queue.offer(currentChild);
            }

            // Removes the child on the front of the queue
            String childToRemove = queue.poll();
            System.out.println("Removed " + childToRemove);
        }

        // Last child standing
        String lastChild = queue.peek();
        System.out.println("Last is " + lastChild);
    }
}
