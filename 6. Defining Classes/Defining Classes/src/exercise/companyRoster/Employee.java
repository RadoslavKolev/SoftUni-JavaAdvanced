package exercise.companyRoster;

public class Employee {
    private final String name;
    private final double salary;
    private final String position;
    private final String department;
    private String email = "n/a";
    private int age = -1;

    public Employee(String name, double salary, String position, String department, String email, int age) {
        this.name = name;
        this.salary = salary;
        this.position = position;
        this.department = department;
        this.email = email;
        this.age = age;
    }

    public double getSalary() {
        return this.salary;
    }

    @Override
    public String toString() {
        return String.format(
          "%s %.2f %s %d",
          this.name, this.salary, this.email, this.age
        );
    }
}
