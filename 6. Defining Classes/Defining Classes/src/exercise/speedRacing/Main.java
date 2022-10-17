package exercise.speedRacing;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, Car> cars = new LinkedHashMap<>(n);

        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");

            String model = tokens[0];
            double fuelAmount = Double.parseDouble(tokens[1]);
            double consumption = Double.parseDouble(tokens[2]);

            Car car = new Car(model, fuelAmount, consumption);
            cars.put(model, car);
        }

        String command = scanner.nextLine();

        while (!command.equals("End")) {
            String[] tokens = command.split("\\s+");

            String model = tokens[1];
            int kilometers = Integer.parseInt(tokens[2]);

            Car currentCar = cars.get(model);

            if (!currentCar.hasEnoughFuel(kilometers)) {
                System.out.println("Insufficient fuel for the drive");
            } else {
                currentCar.drive(kilometers);
            }

            command = scanner.nextLine();
        }

        for (Car car : cars.values()) {
            System.out.println(car);
        }
    }
}
