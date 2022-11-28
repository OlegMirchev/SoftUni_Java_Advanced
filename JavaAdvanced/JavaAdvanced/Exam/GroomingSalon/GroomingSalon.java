package JavaAdvancedExam.GroomingSalon;

import java.util.ArrayList;
;
import java.util.List;

public class GroomingSalon {
    private int capacity;
    private List<Pet> data;

    public GroomingSalon(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Pet pet) {
        if (capacity > this.data.size()) {
            this.data.add(pet);
        }
    }

    public boolean remove(String name) {
        return this.data.removeIf(p -> p.getName().equals(name));
    }

    public Pet getPet(String name, String owner) {
        for (Pet pet : data) {
            if (pet.getName().equals(name) && pet.getOwner().equals(owner)) {
                return pet;
            }
        }
        return null;
    }

    public int getCount() {
        return this.data.size();
    }

    public String getStatistics() {
        StringBuilder output = new StringBuilder("The grooming salon has the following clients:").append(System.lineSeparator());

        for (Pet pet : data) {
            output.append(pet.getName()).append(" ").append(pet.getOwner()).append(System.lineSeparator());
        }

        return output.toString().trim();
    }

}
