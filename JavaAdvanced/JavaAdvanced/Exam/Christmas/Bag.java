package JavaAdvancedExam.Christmas;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Bag {
    private String color;
    private int capacity;
    private List<Present> data;

    public Bag(String color, int capacity) {
        this.color = color;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Present present) {
        if (this.capacity > this.data.size()) {
            this.data.add(present);
        }
    }

    public boolean remove(String name) {
        return this.data.removeIf(p -> p.getName().equals(name));
    }

    public Present heaviestPresent() {
        return this.data.stream().max(Comparator.comparing(Present::getWeight)).get();
    }

    public Present getPresent(String name) {
        for (Present present : data) {
            if (present.getName().equals(name)) {
                return present;
            }
        }
        return null;
    }

    public int count() {
        return this.data.size();
    }

    public String getColor() {
        return color;
    }

    public int getCapacity() {
        return capacity;
    }

    public String report() {
        String colorBag = this.color.substring(0, 1).toUpperCase() + this.color.substring(1);

        StringBuilder output = new StringBuilder(String.format("%s bag contains:%n", colorBag));

        for (Present present : data) {
            output.append(present).append(System.lineSeparator());
        }

        return output.toString().trim();
    }
}
