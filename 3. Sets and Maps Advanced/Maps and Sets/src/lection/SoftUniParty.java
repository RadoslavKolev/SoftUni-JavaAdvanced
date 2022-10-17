package lection;

import java.util.Scanner;
import java.util.TreeSet;

public class SoftUniParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TreeSet<String> guests = new TreeSet<>();
        String registrationNumber = scanner.nextLine();

        while (!registrationNumber.equals("PARTY")) {
            // The TreeSet will sort the VIPs before the regulars
            // So we don't need to create 2 Sets
            // or boolean isVip = Character.isDigit(firstSymbol);
            guests.add(registrationNumber);
            registrationNumber = scanner.nextLine();
        }

        registrationNumber = scanner.nextLine();

        while (!registrationNumber.equals("END")) {
            // if the item is not in the set... it doesn't care
            guests.remove(registrationNumber);
            registrationNumber = scanner.nextLine();
        }

        int missingGuests = guests.size();
        System.out.println(missingGuests);

        for (String guest : guests) {
            System.out.println(guest);
        }
    }
}
