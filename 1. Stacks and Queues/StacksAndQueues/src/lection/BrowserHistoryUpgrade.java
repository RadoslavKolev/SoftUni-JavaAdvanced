package lection;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistoryUpgrade {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        ArrayDeque<String> browserHistory = new ArrayDeque<>();
        ArrayDeque<String> forwardHistory = new ArrayDeque<>();

        while (!input.equals("Home")) {
            if (input.equals("back")) {
                if (browserHistory.size() <= 1) {
                    System.out.println("no previous URLs");
                } else {
                    String currentAddress = browserHistory.pop();
                    forwardHistory.push(currentAddress);
                    System.out.println(browserHistory.peek());
                }
            } else if (input.equals("forward")) {
                if (forwardHistory.isEmpty()) {
                    System.out.println("no next URLs");
                } else {
                    String currentForward = forwardHistory.pop();
                    System.out.println(currentForward);
                    browserHistory.push(currentForward);
                }
            } else {
                browserHistory.push(input);
                System.out.println(input);
                forwardHistory.clear();
            }

            input = scanner.nextLine();
        }
    }
}
