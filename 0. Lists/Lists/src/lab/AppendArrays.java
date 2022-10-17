package lab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AppendArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> list = Arrays
                .stream(scanner.nextLine().split("\\|"))
                .collect(Collectors.toList());

        List<String> output = new ArrayList<>();

        int size = list.size() - 1;

        for (int i = size; i >= 0 ; i--) {
            String[] numbers = list.get(i).split("\\s+");

            for (String num : numbers) {
                if (!num.equals("")) {
                    output.add(num);
                }
            }
        }

        String print = output.toString().trim();
        System.out.println(print.replaceAll("\\[|,|\\]", ""));
    }
}
