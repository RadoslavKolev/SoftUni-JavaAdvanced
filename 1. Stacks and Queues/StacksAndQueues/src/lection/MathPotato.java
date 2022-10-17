package lection;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class MathPotato {
    // checks if the given number is prime or not
    public static boolean isPrime(int n) {
        if (n <= 1) return false;
        else if (n == 2) return true;
        else if (n % 2 == 0) return false;

        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            if (n % i == 0) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] children = scanner.nextLine().split(" ");
        int turns = Integer.parseInt(scanner.nextLine());

        ArrayDeque<String> queue = new ArrayDeque<>();

        // Adds all elements in the queue
        Collections.addAll(queue, children);

        // Initially starts with 1
        int cycle = 1;

        // While there is only 1 child in the queue
        while (queue.size() != 1) {
            // Pass the potato, until we reach turns
            for (int i = 1; i < turns; i++) {
                // Takes the first child and puts him in last position
                String currentChild = queue.poll();

                if (currentChild != null) {
                    queue.offer(currentChild);
                }
            }

            // if the cycle is prime number
            if (isPrime(cycle)) {
                System.out.println("Prime " + queue.peek());
            } else {
                System.out.println("Removed " + queue.pop());
            }

            cycle++;
        }

        // Last child standing
        String lastChild = queue.peek();
        System.out.printf("Last is %s", lastChild);
    }
}
