package lab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CardsGame {
    private static Scanner scanner = new Scanner(System.in);
    private static List<Integer> player1 = generateList(scanner);
    private static List<Integer> player2 = generateList(scanner);

    private static List<Integer> generateList(Scanner scanner) {
        return Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private static void roundWinner(List<Integer> winner, List<Integer> looser) {
        Integer winningCard = winner.get(0);
        Integer defeatedCard = looser.get(0);

        winner.remove(winningCard);
        looser.remove(defeatedCard);

        winner.add(winningCard);
        winner.add(defeatedCard);
    }

    private static void draw(List<Integer> player1, List<Integer> player2) {
        Integer cardToRemove1 = player1.get(0);
        Integer cardToRemove2 = player2.get(0);

        player1.remove(cardToRemove1);
        player2.remove(cardToRemove2);
    }

    private static void winner(List<Integer> player) {
        int sum = player.stream().reduce(0, (a, b) -> a + b);
        String winner = "";

        if (player.equals(player1)) {
            winner = "First";
        } else {
            winner = "Second";
        }

        System.out.printf("%s player wins! Sum: %d%n", winner, sum);
    }

    public static void main(String[] args) {
        int index = 0;

        while (!player1.isEmpty()) {
            if (player2.isEmpty()) break;

            if (player1.get(index) > player2.get(index)) {
                roundWinner(player1, player2);
            } else if (player1.get(index) < player2.get(index)) {
                roundWinner(player2, player1);
            } else {
                draw(player1, player2);
            }
        }

        if (player2.isEmpty()) {
            winner(player1);
        } else if (player1.isEmpty()) {
            winner(player2);
        }
    }
}
