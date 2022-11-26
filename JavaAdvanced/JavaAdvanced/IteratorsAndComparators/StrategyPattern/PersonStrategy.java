package IteratorsAndComparators;

public class PersonStrategy {
    private String name;
    private int age;

    public PersonStrategy(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return String.format("%s %d", this.name, this.age);
    }
}
