package lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BalancedParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        boolean isBalanced = true;
        int len = input.length();

        ArrayDeque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < len; i++) {
            char ch = input.charAt(i);

            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            } else if (ch == ')' || ch == ']' || ch == '}') {
                if (stack.isEmpty()) {
                    isBalanced = false;
                    break;
                }

                char lastElement = stack.pop();

                if (
                    (ch == ')' && lastElement != '(') ||
                    (ch == ']' && lastElement != '[') ||
                    (ch == '}' && lastElement != '{')
                ) {
                    isBalanced = false;
                    break;
                }
            }
        }

        System.out.println((isBalanced && stack.isEmpty()) ? "YES" : "NO");
    }
}
