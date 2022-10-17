package exercise.carSalesman;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfEngines = Integer.parseInt(scanner.nextLine());

        Map<String, Engine> engines = new HashMap<>(numberOfEngines);

        for (int i = 0; i < numberOfEngines; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");

            String model = tokens[0];
            int power = Integer.parseInt(tokens[1]);

            int len = tokens.length;

            Engine engine = new Engine();

            if (len == 2) {
                engine = new Engine(model, power);
            } else if (len == 3) {
                if (tokens[2].matches("\\d+")) {
                    int displacement = Integer.parseInt(tokens[2]);
                    engine = new Engine(model, power, displacement);
                } else {
                    String efficiency = tokens[2];
                    engine = new Engine(model, power, efficiency);
                }
            } else if (len == 4) {
                int displacement = Integer.parseInt(tokens[2]);
                String efficiency = tokens[3];
                engine = new Engine(model, power, displacement, efficiency);
            }

            engines.putIfAbsent(model, engine);
        }

        int numberOfCars = Integer.parseInt(scanner.nextLine());
        List<Car> cars = new LinkedList<>();

        for (int i = 0; i < numberOfCars; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");

            String model = tokens[0];
            Engine engine = engines.get(tokens[1]);

            int len = tokens.length;

            Car car = new Car();

            if (len == 2) {
                car = new Car(model, engine);
            } else if (len == 3) {
                if (tokens[2].matches("\\d+")) {
                    int weight = Integer.parseInt(tokens[2]);
                    car = new Car(model, engine, weight);
                } else {
                    String color = tokens[2];
                    car = new Car(model, engine, color);
                }
            } else if (len == 4) {
                int weight = Integer.parseInt(tokens[2]);
                String color = tokens[3];
                car = new Car(model, engine, weight, color);
            }

            cars.add(car);
        }

        System.out.println();
        cars.forEach(System.out::println);
    }
}
