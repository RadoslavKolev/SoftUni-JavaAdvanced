package lection;

import java.util.*;
import java.util.stream.Collectors;

public class MergingLists {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> list1 = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> list2 = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> result = new ArrayList<>();

        int i = 0;

        while (list1.size() != 0 && list2.size() != 0) {
            result.add(list1.get(i));
            result.add(list2.get(i));
            list1.remove(i);
            list2.remove(i);
        }

        if (list1.size() > list2.size()) {
            result.addAll(list1);
        } else if (list2.size() > list1.size()) {
            result.addAll(list2);
        }

        System.out.println(result.toString().replaceAll("[\\[\\],]", ""));
    }
}
