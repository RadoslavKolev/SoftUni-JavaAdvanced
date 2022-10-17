package exercise.comparingObjects;

public class Person implements Comparable<Person> {
    private final String name;
    private final int age;
    private final String town;

    public Person(String name, int age, String town) {
        this.name = name;
        this.age = age;
        this.town = town;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getTown() {
        return town;
    }

    @Override
    public int compareTo(Person person) {
        int result = this.name.compareTo(person.getName());

        if (result == 0) {
            result = Integer.compare(this.age, person.getAge());
        }

        if (result == 0) {
            result = this.town.compareTo(person.getTown());
        }

        return result;
    }
}
