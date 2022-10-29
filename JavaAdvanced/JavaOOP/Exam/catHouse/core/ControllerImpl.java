package catHouse.core;

import catHouse.common.ConstantMessages;
import catHouse.common.ExceptionMessages;
import catHouse.entities.cat.Cat;
import catHouse.entities.cat.LonghairCat;
import catHouse.entities.cat.ShorthairCat;
import catHouse.entities.houses.House;
import catHouse.entities.houses.LongHouse;
import catHouse.entities.houses.ShortHouse;
import catHouse.entities.toys.Ball;
import catHouse.entities.toys.Mouse;
import catHouse.entities.toys.Toy;
import catHouse.repositories.ToyRepository;

import java.util.*;
import java.util.stream.Collectors;

public class ControllerImpl implements Controller {
    private ToyRepository toys;
    private Map<String, House> houses;

    public ControllerImpl() {
        this.toys = new ToyRepository();
        this.houses = new LinkedHashMap<>();
    }

    @Override
    public String addHouse(String type, String name) {
        House house = type.equals("ShortHouse")
                ? new ShortHouse(name)
                : new LongHouse(name);

        if (!house.getClass().getSimpleName().equals(type)) {
            throw new NullPointerException(ExceptionMessages.INVALID_HOUSE_TYPE);
        }

        this.houses.put(name, house);

        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_HOUSE_TYPE, type);
    }

    @Override
    public String buyToy(String type) {
        Toy toy = type.equals("Ball")
                ? new Ball()
                : new Mouse();

        this.toys.buyToy(toy);

        Toy typeToy = this.toys.findFirst(type);

        if (typeToy == null) {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_TOY_TYPE);
        }
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_TOY_TYPE, type);
    }

    @Override
    public String toyForHouse(String houseName, String toyType) {
        Toy toy = this.toys.findFirst(toyType);
        House house = this.houses.get(houseName);

        if (toy == null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.NO_TOY_FOUND, toyType));
        }

        house.buyToy(toy);
        this.toys.removeToy(toy);

        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_TOY_IN_HOUSE, toyType, houseName);
    }

    @Override
    public String addCat(String houseName, String catType, String catName, String catBreed, double price) {
        House house = this.houses.get(houseName);
        Cat cat = catType.equals("ShorthairCat")
                ? new ShorthairCat(catName, catBreed, price)
                : new LonghairCat(catName, catBreed, price);

        if (!catType.equals("ShorthairCat") && !catType.equals("LonghairCat")) {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_CAT_TYPE);
        }

        if (!(house.getClass().getSimpleName().equals("ShortHouse") && cat.getClass().getSimpleName().equals("ShorthairCat")) &&
                !(house.getClass().getSimpleName().equals("LongHouse") && cat.getClass().getSimpleName().equals("LonghairCat"))) {

            return ConstantMessages.UNSUITABLE_HOUSE;
        }

        house.addCat(cat);

        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_CAT_IN_HOUSE, catType, houseName);
    }

    @Override
    public String feedingCat(String houseName) {
        House house = this.houses.get(houseName);

        house.feeding();

        List<Cat> cats = house.getCats().stream().collect(Collectors.toList());
        int fedCount = cats.size();

        return String.format(ConstantMessages.FEEDING_CAT, fedCount);
    }

    @Override
    public String sumOfAll(String houseName) {
        House house = this.houses.get(houseName);
        double sumCatsPrice = house.getCats().stream().mapToDouble(Cat::getPrice).sum();
        double sumToysPrice = house.getToys().stream().mapToDouble(Toy::getPrice).sum();

        double sumHouse = sumCatsPrice + sumToysPrice;

        return String.format(ConstantMessages.VALUE_HOUSE, houseName, sumHouse);
    }

    @Override
    public String getStatistics() {
        StringBuilder output = new StringBuilder();

        for (House house : houses.values()) {
            output.append(house.getStatistics()).append(System.lineSeparator());
        }

        return output.toString().trim();
    }
}
