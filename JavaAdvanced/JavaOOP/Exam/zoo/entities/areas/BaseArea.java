package zoo.entities.areas;

import zoo.common.ExceptionMessages;
import zoo.entities.animals.Animal;
import zoo.entities.foods.Food;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public abstract class BaseArea implements Area {
    private String name;
    private int capacity;
    private List<Food> foods;
    private List<Animal> animals;

    protected BaseArea(String name, int capacity) {
        this.setName(name);
        this.capacity = capacity;
        this.foods = new ArrayList<>();
        this.animals = new ArrayList<>();
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(ExceptionMessages.AREA_NAME_NULL_OR_EMPTY);
        }

        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public List<Animal> getAnimals() {
        return animals;
    }

    @Override
    public List<Food> getFoods() {
        return foods;
    }

    @Override
    public int sumCalories() {
        return this.foods.stream().mapToInt(Food::getCalories).sum();
    }

    @Override
    public void addAnimal(Animal animal) {
        if (this.capacity <= this.animals.size()) {
            throw new IllegalStateException(ExceptionMessages.NOT_ENOUGH_CAPACITY);
        }

        this.animals.add(animal);
    }

    @Override
    public void removeAnimal(Animal animal) {
        this.animals.remove(animal);
    }

    @Override
    public void addFood(Food food) {
        this.foods.add(food);
    }

    @Override
    public void feed() {
        for (Animal animal : this.animals) {
            animal.eat();
        }
    }

    @Override
    public String getInfo() {
        StringBuilder output = new StringBuilder(String.format("%s (%s):", this.name, getClass().getSimpleName())).append(System.lineSeparator());
        output.append("Animals: ");

        if (this.animals.isEmpty()) {
            output.append("Animals: none").append(System.lineSeparator());
        } else {
            String listAnimals = this.animals.stream().map(Animal::getName).map(String::valueOf).collect(Collectors.joining(" "));
            output.append(listAnimals);
        }

        output.append(System.lineSeparator());

        output.append("Foods: ").append(this.foods.size()).append(System.lineSeparator());
        output.append("Calories: ").append(sumCalories()).append(System.lineSeparator());

        return output.toString().trim();
    }
}
