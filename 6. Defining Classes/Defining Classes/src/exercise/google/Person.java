package exercise.google;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private Car car;
    private Company company;
    private final List<Parent> parents;
    private final List<Child> children;
    private final List<Pokemon> pokemons;

    public Person() {
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();
        this.pokemons = new ArrayList<>();
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public List<Parent> getParents() {
        return parents;
    }

    public List<Child> getChildren() {
        return children;
    }

    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        // Company:
        builder.append("Company:").append("\n");
        if (company != null) {
            builder.append(company).append("\n");
        }

        // Car:
        builder.append("Car:").append("\n");
        if (car != null) {
            builder.append(car).append("\n");
        }

        // Pokemons:
        builder.append("Pokemon:").append("\n");
        for (Pokemon pokemon : pokemons) {
            builder.append(pokemon).append("\n");
        }

        // Parents:
        builder.append("Parents:").append("\n");
        for (Parent parent : parents) {
            builder.append(parent).append("\n");
        }

        // Children:
        builder.append("Children:").append("\n");
        for (Child child : children) {
            builder.append(child).append("\n");
        }

        return builder.toString();
    }
}
