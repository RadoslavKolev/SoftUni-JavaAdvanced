package exercise.google;

public class Car {
    private final String model;
    private final int speed;

    public Car(String model, int speed) {
        this.model = model;
        this.speed = speed;
    }

    @Override
    public String toString() {
        return String.format(
                "%s %d",
                this.model, this.speed
        );
    }
}
