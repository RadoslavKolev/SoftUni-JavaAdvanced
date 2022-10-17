package lection;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Voina {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<Integer> firstPlayer = generateSet(scanner);
        Set<Integer> secondPlayer = generateSet(scanner);

       int rounds = 1;

       while (!firstPlayer.isEmpty() && !secondPlayer.isEmpty()) {
           if (rounds == 50) break;

           int firstPlayerCard = firstPlayer.iterator().next();
           firstPlayer.remove(firstPlayerCard);

           int secondPlayerCard = secondPlayer.iterator().next();
           secondPlayer.remove(secondPlayerCard);

           if (firstPlayerCard > secondPlayerCard) {
               roundWinner(firstPlayer, firstPlayerCard, secondPlayerCard);
           } else if (firstPlayerCard < secondPlayerCard) {
               roundWinner(secondPlayer, firstPlayerCard, secondPlayerCard);
           }

           rounds++;
       }

        checkWhoWins(firstPlayer, secondPlayer);
    }

    private static Set<Integer> generateSet(Scanner scanner) {
        // toSet() returns new HashSet
        // We want LinkedHashSet, that's why we use toCollection()

        return Arrays
                .stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }

    private static void roundWinner(Set<Integer> set, int firstPlayerCard, int secondPlayerCard) {
        set.add(firstPlayerCard);
        set.add(secondPlayerCard);
    }

    private static void checkWhoWins(Set<Integer> firstPlayer, Set<Integer> secondPlayer) {
        if (firstPlayer.size() > secondPlayer.size()) {
            System.out.println("First player win!");
        } else if (secondPlayer.size() > firstPlayer.size()) {
            System.out.println("Second player win!");
        } else {
            System.out.println("Draw!");
        }
    }
}
