package lection.listUtilities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        Collections.addAll(numbers, 1, 2, 18, 2, -1);
        Integer maxNumber = ListUtils.getMax(numbers);

        List<Character> letters = new ArrayList<>();
        Collections.addAll(letters, 'a', 'b', 'c');
        Character minCharacter = ListUtils.getMin(letters);

        List<String> strings = new ArrayList<>();
        Collections.addAll(strings, "Ace", "Club", "Diamond", "Spades");
        String minString = ListUtils.getMax(strings);

        System.out.println(maxNumber);
        System.out.println(minCharacter);
        System.out.println(minString);
    }
}
