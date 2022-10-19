package JavaAdvanced2021.JavaOPP.PolymorphismExercises1111.Problem3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        List<Animal> listAnimals = new ArrayList<>();

        while (!input.equals("End")) {
            String[] animalData = input.split("\\s+");
            Animal animal = getAnimal(animalData);
            String[] foodData = scanner.nextLine().split("\\s+");
            Food food = getFood(foodData);
            listAnimals.add(animal);

            animal.makeSound();
            try {
                animal.Eat(food);
            }catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
            input = scanner.nextLine();
        }
        listAnimals.forEach(System.out::println);
    }

    private static Animal getAnimal(String[] animalData) {
        String animalType = animalData[0];
        String animalName = animalData[1];
        double animalWeight = Double.parseDouble(animalData[2]);
        String animalLivingRegion = animalData[3];

        switch (animalType) {
            case "Tiger":
                return new Tiger(animalName, animalType, animalWeight, animalLivingRegion);
            case "Mouse":
                return new Mouse(animalName, animalType, animalWeight, animalLivingRegion);
            case "Zebra":
                return new Zebra(animalName, animalType, animalWeight, animalLivingRegion);
            case "Cat":
                return new Cat(animalName, animalType, animalWeight, animalLivingRegion, animalData[4]);
            default:
                throw new IllegalArgumentException("Don't have Animal");
        }
    }

    private static Food getFood(String[] foodData) {
        String typeFood = foodData[0];
        int quantity = Integer.parseInt(foodData[1]);

        if (typeFood.equals("Vegetable")) {
            return new Vegetable(quantity);
        }else if (typeFood.equals("Meat")) {
            return new Meat(quantity);
        }
        return null;
    }
}
