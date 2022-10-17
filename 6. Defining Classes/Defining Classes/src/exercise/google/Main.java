package exercise.google;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Person> people = new HashMap<>();

        String information = scanner.nextLine();

        while (!information.equals("End")) {
            String[] tokens = information.split("\\s+");

            String personName = tokens[0];
            String keyword = tokens[1];

            people.putIfAbsent(personName, new Person());

            switch (keyword) {
                case "company" -> {
                    String companyName = tokens[2];
                    String department = tokens[3];
                    double salary = Double.parseDouble(tokens[4]);

                    Company company = new Company(companyName, department, salary);
                    people.get(personName).setCompany(company);
                }
                case "pokemon" -> {
                    String pokemonName = tokens[2];
                    String pokemonType = tokens[3];

                    Pokemon pokemon = new Pokemon(pokemonName, pokemonType);
                    people.get(personName).getPokemons().add(pokemon);
                }
                case "parents" -> {
                    String parentName = tokens[2];
                    String parentBirthday = tokens[3];

                    Parent parent = new Parent(parentName, parentBirthday);
                    people.get(personName).getParents().add(parent);
                }
                case "children" -> {
                    String childName = tokens[2];
                    String childBirthday = tokens[3];

                    Child child = new Child(childName, childBirthday);
                    people.get(personName).getChildren().add(child);
                }
                case "car" -> {
                    String carModel = tokens[2];
                    int carSpeed = Integer.parseInt(tokens[3]);

                    Car car = new Car(carModel, carSpeed);
                    people.get(personName).setCar(car);
                }
                default -> System.out.println("No such command!");
            }

            information = scanner.nextLine();
        }

        String personToSearch = scanner.nextLine();
        System.out.println("\n" + personToSearch);

        Person currentPerson = people.get(personToSearch);
        System.out.println(currentPerson);
    }
}
