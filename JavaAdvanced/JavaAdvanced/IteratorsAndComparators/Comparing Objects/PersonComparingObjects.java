package IteratorsAndComparators;

public class PersonComparingObjects implements Comparable<PersonComparingObjects> {
    private String name;
    private int age;
    private String town;

    public PersonComparingObjects(String name, int age, String town) {
        this.name = name;
        this.age = age;
        this.town = town;
    }

    @Override
    public int compareTo(PersonComparingObjects otherPerson) {
        if (this.name.compareTo(otherPerson.name) == 0) {
           if (this.age == otherPerson.age) {
               return this.town.compareTo(otherPerson.town);
           }
           return Integer.compare(this.age, otherPerson.age);
        }
        return this.name.compareTo(otherPerson.name);
    }
}
