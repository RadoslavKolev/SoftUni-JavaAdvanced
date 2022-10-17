package exercise.carSalesman;

import java.util.Objects;

public class Car {
    private String model;
    private Engine engine;
    private int weight;
    private String color;

    public Car() {}

    public Car(String model, Engine engine) {
        this.model = model;
        this.engine = engine;
    }

    public Car(String model, Engine engine, int weight) {
        this(model, engine);
        this.weight = weight;
    }

    public Car(String model, Engine engine, String color) {
        this(model, engine);
        this.color = color;
    }

    public Car(String model, Engine engine, int weight, String color) {
        this(model, engine);
        this.weight = weight;
        this.color = color;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        builder.append(model).append(":\n");

        builder.append(engine).append("\n");

        builder.append("Weight: ");

        if (weight == 0) {
            builder.append("n/a").append("\n");
        } else {
            builder.append(weight).append("\n");
        }

        builder.append("Color: ");
        builder.append(Objects.requireNonNullElse(color, "n/a"));

        return builder.toString();
    }
}
