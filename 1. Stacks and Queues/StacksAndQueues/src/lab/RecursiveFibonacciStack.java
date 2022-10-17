package lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class RecursiveFibonacciStack {
    private static long getFibonacci(ArrayDeque<Long> stack, long n) {
        if (n < 2) {
            return 1;
        }

        stack.push(0L);
        stack.push(1L);

        for (int i = 1; i <= n ; i++) {
            long num1 = stack.pop();
            long num2 = stack.pop();
            stack.push(num1);
            stack.push(num1 + num2);
        }

        return stack.peek();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = Integer.parseInt(scanner.nextLine());
        ArrayDeque<Long> fibonacciStack = new ArrayDeque<>();
        System.out.println(getFibonacci(fibonacciStack, n));
    }
}
