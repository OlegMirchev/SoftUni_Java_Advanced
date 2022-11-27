package JavaAdvancedExam.Aquarium;

import java.util.LinkedHashSet;
import java.util.Set;

public class Aquarium {
    private String name;
    private int capacity;
    private int size;
    private Set<Fish> fishInPool;

    public Aquarium(String name, int capacity, int size) {
        this.name = name;
        this.capacity = capacity;
        this.size = size;
        this.fishInPool = new LinkedHashSet<>();
    }

    public void add(Fish fish) {
        if (this.capacity > this.fishInPool.size()) {
            this.fishInPool.add(fish);
        }
    }

    public boolean remove(String name) {
       return this.fishInPool.removeIf(f -> f.getName().equals(name));
    }

    public Fish findFish(String name) {
        for (Fish fish : fishInPool) {
            if (fish.getName().equals(name)) {
                return fish;
            }
        }
        return null;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getSize() {
        return size;
    }

    public int getFishInPool() {
        return fishInPool.size();
    }

    public String report() {
        System.out.println("Aquarium Info:");

        StringBuilder output = new StringBuilder(String.format("Aquarium: %s ^ Size: %d%n", this.name, this.size));

        for (Fish fish : fishInPool) {
            output.append(fish).append(System.lineSeparator());
        }

        return output.toString().trim();
    }
}
