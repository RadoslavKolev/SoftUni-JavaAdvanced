package lection;

import java.util.Arrays;
import java.util.Scanner;

public class FindEvensOrOdds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] range = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int lowerBound = range[0];
        int upperBound = range[1];

        String command = scanner.nextLine();

        if (command.equals("odd")) {
            printOdd(lowerBound, upperBound);
        } else {
            printEven(lowerBound, upperBound);
        }
    }

    private static void printOdd(int start, int end) {
        for (int i = start; i <= end; i++) {
            if (i % 2 != 0) {
                System.out.print(i + " ");
            }
        }
    }

    private static void printEven(int start, int end) {
        for (int i = start; i <= end; i++) {
            if (i % 2 == 0) {
                System.out.print(i + " ");
            }
        }
    }
}
