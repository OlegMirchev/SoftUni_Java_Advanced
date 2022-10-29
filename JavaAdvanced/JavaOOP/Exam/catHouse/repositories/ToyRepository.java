package catHouse.repositories;

import catHouse.entities.toys.Toy;

import java.util.ArrayList;
import java.util.List;

public class ToyRepository implements Repository {
    private List<Toy> toys;

    public ToyRepository() {
        this.toys = new ArrayList<>();
    }

    @Override
    public void buyToy(Toy toy) {
        this.toys.add(toy);
    }

    @Override
    public boolean removeToy(Toy toy) {
        return this.toys.removeIf(t -> t.equals(toy));
    }

    @Override
    public Toy findFirst(String type) {
        return this.toys.stream().filter(t -> t.getClass().getSimpleName().equals(type)).findFirst().orElse(null);
    }
}
