package lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class RecursiveFibonacciQueue {
    private static long getFibonacci(ArrayDeque<Long> queue, long n) {
        if (n < 2) {
            return 1;
        }

        queue.offer(0L);
        queue.offer(1L);

        for (int i = 1; i <= n ; i++) {
            long num1 = queue.poll();
            long num2 = queue.peek();
            queue.offer(num1 + num2);
        }

        queue.poll();
        return queue.peek();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = Integer.parseInt(scanner.nextLine());
        ArrayDeque<Long> fibonacciQueue = new ArrayDeque<>();
        System.out.println(getFibonacci(fibonacciQueue, n));
    }
}
