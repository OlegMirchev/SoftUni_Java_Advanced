package parrots;

import java.util.ArrayList;
import java.util.List;

public class Cage {
    private String name;
    private int capacity;
    private List<Parrot> data;

    public Cage(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Parrot parrot) {
        if (this.capacity > this.data.size()) {
            this.data.add(parrot);
        }
    }

    public Boolean remove(String name) {
        return this.data.removeIf(p -> p.getName().equals(name));
    }

    public Parrot sellParrot(String name) {
        for (Parrot parrot : this.data) {
            if (parrot.getName().equals(name)) {
                parrot.setAvailable(false);
                return parrot;
            }
        }

        return null;
    }

    public List<Parrot> sellParrotBySpecies(String species) {
        List<Parrot> parrots = new ArrayList<>();

        for (Parrot parrot : this.data) {
            if (parrot.getSpecies().equals(species)) {
                parrot.setAvailable(false);
                parrots.add(parrot);
            }
        }

        return parrots;
    }

    public int count() {
        return this.data.size();
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public String report() {
        StringBuilder output = new StringBuilder(String.format("Parrots available at %s:", this.name)).append(System.lineSeparator());

        for (Parrot parrot : this.data) {
            if (parrot.isAvailable()) {
                output.append(parrot).append(System.lineSeparator());
            }
        }

        return output.toString().trim();
    }
}
