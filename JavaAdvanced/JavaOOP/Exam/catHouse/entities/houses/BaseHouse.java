package catHouse.entities.houses;

import catHouse.common.ConstantMessages;
import catHouse.common.ExceptionMessages;
import catHouse.entities.cat.Cat;
import catHouse.entities.toys.Toy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public abstract class BaseHouse implements House {
    private String name;
    private int capacity;
    private List<Toy> toys;
    private List<Cat> cats;

    protected BaseHouse(String name, int capacity) {
        this.setName(name);
        this.capacity = capacity;
        this.toys = new ArrayList<>();
        this.cats = new ArrayList<>();
    }

    @Override
    public int sumSoftness() {
        return this.toys.stream().mapToInt(Toy::getSoftness).sum();
    }

    @Override
    public void addCat(Cat cat) {
        if (this.capacity <= this.cats.size()) {
            throw new IllegalStateException(ConstantMessages.NOT_ENOUGH_CAPACITY_FOR_CAT);
        }

        this.cats.add(cat);
    }

    @Override
    public void removeCat(Cat cat) {
        this.cats.remove(cat);
    }

    @Override
    public void buyToy(Toy toy) {
        this.toys.add(toy);
    }

    @Override
    public void feeding() {
        for (Cat cat : this.cats) {
            cat.eating();
        }
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(ExceptionMessages.HOUSE_NAME_CANNOT_BE_NULL_OR_EMPTY);
        }

        this.name = name;
    }

    @Override
    public List<Cat> getCats() {
        return cats;
    }

    @Override
    public List<Toy> getToys() {
        return toys;
    }

    @Override
    public String getStatistics() {
        StringBuilder output = new StringBuilder(String.format("%s %s:%n", this.name, getClass().getSimpleName()));
        output.append("Cats: ");

        if (this.cats.isEmpty()) {
            output.append("none");
        }

        String cat = this.cats.stream().map(Cat::getName).map(String::valueOf).collect(Collectors.joining(" "));
        output.append(cat);

        output.append(System.lineSeparator());
        output.append("Toys: ").append(this.toys.size()).append(" ").append("Softness: ").append(sumSoftness());

        return output.toString().trim();
    }
}
