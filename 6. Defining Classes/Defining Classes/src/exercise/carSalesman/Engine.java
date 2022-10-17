package exercise.carSalesman;

import java.util.Objects;

public class Engine {
    private String model;
    private int power;
    private int displacement;
    private String efficiency;

    public Engine() {}

    public Engine(String model, int power) {
        this.model = model;
        this.power = power;
    }

    public Engine(String model, int power, int displacement) {
        this(model, power);
        this.displacement = displacement;
    }

    public Engine(String model, int power, String efficiency) {
        this(model, power);
        this.efficiency = efficiency;
    }

    public Engine(String model, int power, int displacement, String efficiency) {
        this(model, power);
        this.displacement = displacement;
        this.efficiency = efficiency;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        builder.append(model).append(":\n");

        builder.append("Power: ");
        builder.append(power).append("\n");

        builder.append("Displacement: ");

        if (displacement == 0) {
            builder.append("n/a").append("\n");
        } else {
            builder.append(displacement).append("\n");
        }

        builder.append("Efficiency: ");

        builder.append(Objects.requireNonNullElse(efficiency, "n/a"));

        return builder.toString();
    }
}
