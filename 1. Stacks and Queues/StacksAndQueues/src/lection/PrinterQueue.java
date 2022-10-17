package lection;

import java.util.ArrayDeque;
import java.util.Scanner;

public class PrinterQueue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        ArrayDeque<String> files = new ArrayDeque<>();

        // until we receive the "print" command
        while(!input.equals("print")) {
            if (input.equals("cancel")) {
                // cancel logic
                if (files.isEmpty()) {
                    // empty queue
                    System.out.println("Printer is on standby");
                } else {
                    // not empty queue
                    String fileToRemove = files.poll();
                    System.out.printf("Canceled %s%n", fileToRemove);
                }
            } else {
                // passed file
                files.offer(input);
            }

            input = scanner.nextLine();
        }

        for (String file : files) {
            System.out.println(file);
        }
    }
}
