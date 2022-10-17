package lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class ReverseNumbersWithStack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] numbers = scanner.nextLine().split(" ");

        ArrayDeque<Integer> reversed = new ArrayDeque<>();

        for (String num : numbers) {
            reversed.push(Integer.parseInt(num));
        }

        for (Integer num : reversed) {
            System.out.print(num + " ");
        }
    }
}
