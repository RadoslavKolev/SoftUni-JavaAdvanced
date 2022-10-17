package lection.carInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Car> cars = new ArrayList<>();

        int numberOfCars = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numberOfCars; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String brand = tokens[0];
            String model = tokens[1];
            int horsePower = Integer.parseInt(tokens[2]);

            Car car = new Car();

            car.setBrand(brand);
            car.setModel(model);
            car.setHorsePower(horsePower);

            cars.add(car);
        }

        cars.forEach(car -> System.out.println(car.carInfo()));
    }
}
