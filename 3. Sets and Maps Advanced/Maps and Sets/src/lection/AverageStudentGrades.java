package lection;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeMap;

public class AverageStudentGrades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TreeMap<String, ArrayList<Double>> students = new TreeMap<>();

        int numberOfStudents = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numberOfStudents; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String name = tokens[0];
            double grade = Double.parseDouble(tokens[1]);

            students.putIfAbsent(name, new ArrayList<>());
            students.get(name).add(grade);
        }

        for (var entry : students.entrySet()) {
            double average = 0.0;
            System.out.print(entry.getKey() + " -> ");

            for (Double grade : entry.getValue()) {
                System.out.printf("%.2f ", grade);
                average += grade;
            }

            average /= entry.getValue().size();
            System.out.printf("(avg: %.2f)%n", average);
        }
    }
}
