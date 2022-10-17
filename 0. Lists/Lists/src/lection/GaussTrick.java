package lection;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class GaussTrick {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

         List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" "))
                 .map(Integer::parseInt)
                 .collect(Collectors.toList());

         int size = numbers.size();

        // We need to iterate half the list
        for (int i = 0; i < size / 2; i++) {
            int currentElem = numbers.get(i);
            int lastElem = numbers.get(numbers.size() - 1);
            int sum = currentElem + lastElem;

            numbers.set(i, sum);
            numbers.remove(numbers.size() - 1);
        }

//        for (int i = 0; i < size / 2; i++) {
//            numbers.set(i, numbers.get(i) + numbers.get(numbers.size() - 1));
//            numbers.remove(numbers.size() - 1);
//        }

        System.out.println(numbers.toString().replaceAll("[\\[\\],]", ""));
    }
}
