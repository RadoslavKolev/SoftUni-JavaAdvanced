package lection;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\s+");

        ArrayDeque<String> stack = new ArrayDeque<>();
        Collections.addAll(stack, input);   // adds all elements in the stack
        int result = 0;

        while(stack.size() > 1) {
           int firstElem = Integer.parseInt(stack.pop());
           String operator = stack.pop();
           int secondElem = Integer.parseInt(stack.pop());

           if (operator.equals("+")) {
               result = firstElem + secondElem;
           } else {
               result = firstElem - secondElem;
           }

           stack.push(String.valueOf(result));
        }

        System.out.println(stack.peek());
    }
}
