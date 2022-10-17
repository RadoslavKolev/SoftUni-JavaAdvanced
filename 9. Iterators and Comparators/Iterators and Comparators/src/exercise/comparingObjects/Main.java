package exercise.comparingObjects;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Person> people = new ArrayList<>();

        String input = scanner.nextLine();

        while (!input.equals("END")) {
            String[] tokens = input.split("\\s+");

            String name = tokens[0];
            int age = Integer.parseInt(tokens[1]);
            String town = tokens[2];

            Person person = new Person(name, age, town);
            people.add(person);

            input = scanner.nextLine();
        }

        int index = Integer.parseInt(scanner.nextLine());
        Person currentPerson = people.get(index - 1);

        int equal = 0;

        for (Person person : people) {
            if (currentPerson.compareTo(person) == 0) {
                equal++;
            }
        }

        int numberOfPeople = people.size();
        int nonEqual = numberOfPeople - equal;

        System.out.println((equal > 1)
                ? String.format("%d %d %d", equal, nonEqual, numberOfPeople)
                : "No matches"
        );
    }
}
