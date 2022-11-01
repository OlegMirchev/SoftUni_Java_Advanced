package zoo.core;

import zoo.common.ConstantMessages;
import zoo.common.ExceptionMessages;
import zoo.entities.animals.Animal;
import zoo.entities.animals.AquaticAnimal;
import zoo.entities.animals.TerrestrialAnimal;
import zoo.entities.areas.Area;
import zoo.entities.areas.LandArea;
import zoo.entities.areas.WaterArea;
import zoo.entities.foods.Food;
import zoo.entities.foods.Meat;
import zoo.entities.foods.Vegetable;
import zoo.repositories.FoodRepository;
import zoo.repositories.FoodRepositoryImpl;

import java.util.LinkedHashMap;
import java.util.Map;

public class ControllerImpl implements Controller {
    private FoodRepository foodRepository;
    private Map<String, Area> areas;

    public ControllerImpl() {
        this.foodRepository = new FoodRepositoryImpl();
        this.areas = new LinkedHashMap<>();
    }

    @Override
    public String addArea(String areaType, String areaName) {
        Area area = areaType.equals("WaterArea")
                ? new WaterArea(areaName)
                : new LandArea(areaName);

        if (!area.getClass().getSimpleName().equals(areaType)) {
            throw new NullPointerException(ExceptionMessages.INVALID_AREA_TYPE);
        }

        this.areas.put(areaName, area);

        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_AREA_TYPE, areaType);
    }

    @Override
    public String buyFood(String foodType) {
        Food food = foodType.equals("Meat")
                ? new Meat()
                : new Vegetable();

        if (!food.getClass().getSimpleName().equals(foodType)) {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_FOOD_TYPE);
        }

        this.foodRepository.add(food);

        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_FOOD_TYPE, foodType);
    }

    @Override
    public String foodForArea(String areaName, String foodType) {
        Food food = this.foodRepository.findByType(foodType);
        Area area = this.areas.get(areaName);

        if (food == null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.NO_FOOD_FOUND, foodType));
        }

        area.addFood(food);
        this.foodRepository.remove(food);

        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_FOOD_IN_AREA, foodType, areaName);
    }

    @Override
    public String addAnimal(String areaName, String animalType, String animalName, String kind, double price) {
        Area area = this.areas.get(areaName);

        Animal animal = animalType.equals("AquaticAnimal")
                ? new AquaticAnimal(animalName, kind, price)
                : new TerrestrialAnimal(animalName, kind, price);

        if (!animal.getClass().getSimpleName().equals(animalType)) {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_ANIMAL_TYPE);
        }

        if (!(animal.getClass().getSimpleName().equals("AquaticAnimal") && area.getClass().getSimpleName().equals("WaterArea")) &&
                !(animal.getClass().getSimpleName().equals("TerrestrialAnimal") && area.getClass().getSimpleName().equals("LandArea"))) {

            return ConstantMessages.AREA_NOT_SUITABLE;
        }

        try {
            area.addAnimal(animal);
        } catch (IllegalStateException e) {
            return e.getMessage();
        }

        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_ANIMAL_IN_AREA, animalType, areaName);
    }

    @Override
    public String feedAnimal(String areaName) {
        int countFedAnimal = 0;

        for (Area area : this.areas.values()) {
            if (area.getName().equals(areaName)) {
                for (Animal animal : area.getAnimals()) {
                    animal.eat();
                    countFedAnimal++;
                }
            }
        }

        return String.format(ConstantMessages.ANIMALS_FED, countFedAnimal);
    }

    @Override
    public String calculateKg(String areaName) {
        double calculateValue = 0;

        for (Area area : areas.values()) {
            if (area.getName().equals(areaName)) {
                for (Animal animal : area.getAnimals()) {
                    calculateValue += animal.getKg();
                }
            }
        }

        return String.format(ConstantMessages.KILOGRAMS_AREA, areaName, calculateValue);
    }

    @Override
    public String getStatistics() {
        StringBuilder output = new StringBuilder();

        for (Area area : areas.values()) {
            output.append(area.getInfo()).append(System.lineSeparator());
        }

        return output.toString().trim();
    }
}
