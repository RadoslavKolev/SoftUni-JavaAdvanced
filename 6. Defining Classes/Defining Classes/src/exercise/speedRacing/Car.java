package exercise.speedRacing;

public class Car {
    private final String model;
    private double fuelAmount;
    private final double consumption;
    private int distance;

    public Car(String model, double fuelAmount, double consumption) {
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.consumption = consumption;
        this.distance = 0;
    }

    public boolean hasEnoughFuel(int kilometers) {
        double fuelNeeded = calculateNeededFuel(kilometers);
        return this.fuelAmount >= fuelNeeded;
    }

    public void drive(int kilometers) {
        double fuelNeeded = calculateNeededFuel(kilometers);
        this.fuelAmount -= fuelNeeded;
        this.distance += kilometers;
    }

    public double calculateNeededFuel(int kilometers) {
        return kilometers * this.consumption;
    }

    @Override
    public String toString() {
        return String.format(
          "%s %.2f %d",
          this.model, this.fuelAmount, this.distance
        );
    }
}
