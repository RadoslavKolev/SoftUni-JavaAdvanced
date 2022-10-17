package exercise.rawData;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final int TIRES_COUNT = 4;

        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        List<Car> cars = new ArrayList<>(n);

        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String model = tokens[0];

            int engineSpeed = Integer.parseInt(tokens[1]);
            int enginePower = Integer.parseInt(tokens[2]);
            Engine engine = new Engine(engineSpeed, enginePower);

            int cargoWeight = Integer.parseInt(tokens[3]);
            String cargoType = tokens[4];
            Cargo cargo = new Cargo(cargoWeight, cargoType);

            List<Tire> tires = new ArrayList<>(TIRES_COUNT);

            int len = tokens.length;

            for (int j = 5; j < len; j += 2) {
                double tirePressure = Double.parseDouble(tokens[j]);
                int tireAge = Integer.parseInt(tokens[j + 1]);
                Tire tire = new Tire(tirePressure, tireAge);
                tires.add(tire);
            }

            Car car = new Car(model, engine, cargo, tires);
            cars.add(car);
        }

        String command = scanner.nextLine();

        if (command.equals("fragile")) {
            cars.stream()
                    .filter(car -> car.getCargo().getType().equals(command))
                    .filter(car -> car.getTires().stream()
                            .anyMatch(tire -> tire.getPressure() < 1.0))
                    .forEach(car -> System.out.println(car.getModel()));
        } else if (command.equals("flamable")) {
            cars.stream()
                    .filter(car -> car.getCargo().getType().equals(command))
                    .filter(car -> car.getEngine().getPower() > 250)
                    .forEach(car -> System.out.println(car.getModel()));
        }
    }
}
