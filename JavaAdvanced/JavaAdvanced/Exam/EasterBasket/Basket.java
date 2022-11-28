package easterBasket;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Basket {
    private String material;
    private int capacity;
    private List<Egg> data;

    public Basket(String material, int capacity) {
        this.material = material;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void addEgg(Egg egg) {
        if (this.capacity > this.data.size()) {
            this.data.add(egg);
        }
    }

    public boolean removeEgg(String color) {
        return this.data.removeIf(e -> e.getColor().equals(color));
    }

    public Egg getStrongestEgg() {
        return this.data.stream().max(Comparator.comparing(Egg::getStrength)).get();
    }

    public Egg getEgg(String color) {
        return this.data.stream().filter(e -> e.getColor().equals(color)).findFirst().orElse(null);
    }

    public int getCount() {
        return this.data.size();
    }

    public String report() {
        StringBuilder output = new StringBuilder(String.format("%s basket contains:", this.material)).append(System.lineSeparator());

        for (Egg egg : this.data) {
            output.append(egg).append(System.lineSeparator());
        }

        return output.toString().trim();
    }
}
