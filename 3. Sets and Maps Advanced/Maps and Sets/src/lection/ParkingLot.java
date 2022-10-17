package lection;

import java.util.LinkedHashSet;
import java.util.Scanner;

public class ParkingLot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        LinkedHashSet<String> parkingLot = new LinkedHashSet<>();

        while (!input.equals("END")) {
            String[] tokens = input.split(", ");
            String command = tokens[0];
            String carNumber = tokens[1];

            addOrRemove(parkingLot, command, carNumber);

            input = scanner.nextLine();
        }

        if (parkingLot.isEmpty()) {
            System.out.println("Parking Lot is Empty");
            return;
        }

        printSet(parkingLot);

//        System.out.println(String.join(System.lineSeparator(), parkingLot));
    }

    private static void addOrRemove(LinkedHashSet<String> set, String command, String carNumber) {
        if (command.equals("IN")) {
            set.add(carNumber);
        } else if (command.equals("OUT")) {
            set.remove(carNumber);
        }
    }

    private static void printSet(LinkedHashSet<String> set) {
        for (String elem : set) {
            System.out.println(elem);
        }
    }
}
