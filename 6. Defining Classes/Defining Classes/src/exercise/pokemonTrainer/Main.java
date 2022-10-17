package exercise.pokemonTrainer;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Trainer> trainers = new LinkedHashMap<>();

        String input = scanner.nextLine();

        while (!input.equals("Tournament")) {
            String[] tokens = input.split("\\s+");

            String trainerName = tokens[0];
            Trainer trainer = new Trainer(trainerName);

            String pokemonName = tokens[1];
            String pokemonElement = tokens[2];
            int pokemonHealth = Integer.parseInt(tokens[3]);

            Pokemon pokemon = new Pokemon(pokemonName, pokemonElement, pokemonHealth);
            trainers.putIfAbsent(trainerName, trainer);

            trainers.get(trainerName).getPokemons().add(pokemon);

            input = scanner.nextLine();
        }

        input = scanner.nextLine();

        while (!input.equals("End")) {
            checkElement(trainers, input);
            input = scanner.nextLine();
        }

        trainers.values().stream()
                .sorted((a, b) -> b.getBadges() - a.getBadges())
                .forEach(System.out::println);
    }

    private static void checkElement(Map<String, Trainer> trainers, String element) {
        for (Trainer trainer : trainers.values()) {
            if (trainer.hasElement(element)) {
                trainer.increaseBadges();
            } else {
                trainer.loseHealth();
            }
        }
    }
}
