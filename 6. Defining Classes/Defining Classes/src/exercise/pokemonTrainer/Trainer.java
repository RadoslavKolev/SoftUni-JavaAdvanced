package exercise.pokemonTrainer;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Trainer {
    private String name;
    private int badges;
    private List<Pokemon> pokemons;

    public Trainer(String name) {
        this.name = name;
        this.badges = 0;
        pokemons = new ArrayList<>();
    }

    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    public int getBadges() {
        return badges;
    }

    public boolean hasElement(String element) {
        for (Pokemon pokemon : this.pokemons) {
            if (pokemon.getElement().equals(element)) {
                return true;
            }
        }

        return false;
    }

    public void increaseBadges() {
        this.badges++;
    }

    public void loseHealth() {
        final int LOST_HP = 10;

        for (Pokemon pokemon : pokemons) {
            int currentPokemonHealth = pokemon.getHealth();
            pokemon.setHealth(currentPokemonHealth - LOST_HP);
        }

        pokemons = pokemons.stream()
                .filter(pokemon -> pokemon.getHealth() > 0)
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return String.format(
                "%s %d %d",
                this.name, this.badges, this.pokemons.size()
        );
    }
}
