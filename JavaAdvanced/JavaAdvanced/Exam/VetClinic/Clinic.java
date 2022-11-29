package JavaAdvancedExam.VetClinic;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Clinic {
    private int capacity;
    List<Pet> data;

    public Clinic(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Pet pet) {
        if (this.capacity > this.data.size()) {
            this.data.add(pet);
        }
    }

    public boolean remove(String name) {
        return this.data.removeIf(e -> e.getName().equals(name));
    }

    public Pet getPet(String name, String owner) {
        for (Pet pet : data) {
            if (pet.getName().equals(name) && pet.getOwner().equals(owner)) {
                return pet;
            }
        }
        return null;
    }

    public Pet getOldestPet() {
      return this.data.stream().max(Comparator.comparingInt(Pet::getAge)).get();
    }

    public int getCount() {
        return this.data.size();
    }

    public String getStatistics() {
        StringBuilder output = new StringBuilder("The clinic has the following patients:").append(System.lineSeparator());

        for (Pet pet : data) {
            output.append(pet.getName()).append(" ").append(pet.getOwner()).append(System.lineSeparator());
        }

        return output.toString().trim();
    }
}
