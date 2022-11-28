package JavaAdvancedExam.Hotel;

import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private String name;
    private int capacity;
    List<Person> roster;

    public Hotel(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.roster = new ArrayList<>();
    }

    public void add(Person person) {
        if (capacity > roster.size()) {
            this.roster.add(person);
        }
    }

    public boolean remove(String name) {
        for (Person person : this.roster) {
            if (person.getName().equals(name)) {
                this.roster.remove(person);
                return true;
            }
        }
        return false;
    }

    public Person getPerson(String name, String hometown) {
        for (Person person : this.roster) {
            if (person.getName().equals(name)) {
                if (person.getHometown().equals(hometown)) {
                    return person;
                }
            }
        }
        return null;
    }

    public int getCount() {
        return this.roster.size();
    }

    public String getStatistics() {
        StringBuilder output = new StringBuilder(String.format("The people in the hotel %s are:%n", this.name));

        for (Person person : this.roster) {
            output.append(person).append(System.lineSeparator());
        }
        return output.toString().trim();
    }
}
