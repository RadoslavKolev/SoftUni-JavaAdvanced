package lection;

import java.util.*;
import java.util.stream.Collectors;

public class AcademyGraduation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfStudents = Integer.parseInt(scanner.nextLine());

        TreeMap<String, ArrayList<Double>> students = new TreeMap<>();

        for (int i = 0; i < numberOfStudents; i++) {
            String name = scanner.nextLine();

            List<Double> list = Arrays
                    .stream(scanner.nextLine().split("\\s+"))
                    .map(Double::parseDouble)
                    .collect(Collectors.toList());

            students.putIfAbsent(name, new ArrayList<>());

            for (double grade : list) {
                students.get(name).add(grade);
            }
        }

        for (var entry : students.entrySet()) {
            double average = 0.0;

            for (double grade : entry.getValue()) {
                average += grade;
            }

            average /= entry.getValue().size();

            System.out.printf("%s is graduated with %f%n", entry.getKey(), average);
        }
    }
}
