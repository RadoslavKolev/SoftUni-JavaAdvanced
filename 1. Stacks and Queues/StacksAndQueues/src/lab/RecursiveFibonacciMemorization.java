package lab;

import java.util.Scanner;

public class RecursiveFibonacciMemorization {
    public static long[] memory;
    private static long getFibonacci(int n) {
        if (n == 0) {
            return 0;
        } else if (n <= 2) {
            return 1;
        }

        if (memory[n] != 0) {
            return memory[n];
        }

        memory[n] = getFibonacci(n - 1) + getFibonacci(n - 2);
        return memory[n];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        memory = new long[n + 1];
        System.out.println(getFibonacci(n));
    }
}
