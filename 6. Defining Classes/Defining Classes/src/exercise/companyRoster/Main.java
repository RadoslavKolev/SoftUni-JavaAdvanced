package exercise.companyRoster;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        List<Department> departments = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");

            String name = tokens[0];
            double salary = Double.parseDouble(tokens[1]);
            String position = tokens[2];
            String department = tokens[3];
            String email = "n/a";
            int age = -1;

            Employee employee;

            if (tokens.length == 5) {
                if (tokens[4].matches("\\d+")) {
                    age = Integer.parseInt(tokens[4]);
                } else {
                    email = tokens[4];
                }
            } else if (tokens.length == 6) {
                email = tokens[4];
                age = Integer.parseInt(tokens[5]);
            }

            employee = new Employee(name, salary, position, department, email, age);

            boolean departmentExists = departments.stream()
                    .anyMatch(dep -> dep.getName().equals(department));

            if (!departmentExists) {
                departments.add(new Department(department));
            }

            Department currentDepartment = departments.stream()
                    .filter(dep -> dep.getName().equals(department))
                    .findFirst()
                    .get();

            currentDepartment.getEmployees().add(employee);
        }

        Department highestPaidDepartment = departments.stream()
                .max(Comparator.comparingDouble(Department::calculateAverageSalary))
                .get();

        System.out.printf("Highest Average Salary: %s%n", highestPaidDepartment.getName());

        highestPaidDepartment.getEmployees().stream()
                .sorted((e1, e2) -> Double.compare(e2.getSalary(), e1.getSalary()))
                .forEach(System.out::println);
    }
}
