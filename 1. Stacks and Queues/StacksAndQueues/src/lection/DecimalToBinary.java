package lection;

import java.util.ArrayDeque;
import java.util.Scanner;

public class DecimalToBinary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int decimal = Integer.parseInt(scanner.nextLine());

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        if (decimal == 0) {
            System.out.print(0);
            return;
        }

        while (decimal != 0) {
            int leftover = decimal % 2;
            stack.push(leftover);
            decimal /= 2;
        }

        for (Integer digit : stack) {
            System.out.print(digit);
        }
    }
}
