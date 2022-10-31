package JavaAdvanced2021.JavaOPP.Exam.restaurant.entities.tables.interfaces;

import JavaAdvanced2021.JavaOPP.Exam.restaurant.common.ExceptionMessages;
import JavaAdvanced2021.JavaOPP.Exam.restaurant.entities.drinks.interfaces.Beverages;
import JavaAdvanced2021.JavaOPP.Exam.restaurant.entities.healthyFoods.interfaces.HealthyFood;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseTable implements Table {
    private List<HealthyFood> healthyFood;
    private List<Beverages> beverages;
    private int number;
    private int size;
    private int numberOfPeople;
    private double pricePerPerson;
    private boolean isReservedTable;
    private double allPeople;

    protected BaseTable(int number, int size, double pricePerPerson) {
        this.healthyFood = new ArrayList<>();
        this.beverages = new ArrayList<>();
        this.number = number;
        this.setSize(size);
        this.pricePerPerson = pricePerPerson;
        this.isReservedTable = false;
        this.allPeople = 0.0;
    }

    @Override
    public int getTableNumber() {
        return this.number;
    }

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public int numberOfPeople() {
        return this.numberOfPeople;
    }

    @Override
    public double pricePerPerson() {
        return this.pricePerPerson;
    }

    @Override
    public boolean isReservedTable() {
        return this.isReservedTable;
    }

    @Override
    public double allPeople() {
        return this.pricePerPerson * this.numberOfPeople;
    }

    @Override
    public void reserve(int numberOfPeople) {
        setNumberOfPeople(numberOfPeople);
        this.isReservedTable = true;
    }

    @Override
    public void orderHealthy(HealthyFood food) {
       this.healthyFood.add(food);
    }

    @Override
    public void orderBeverages(Beverages beverages) {
        this.beverages.add(beverages);
    }

    @Override
    public double bill() {
        double sumFood = this.healthyFood.stream().mapToDouble(HealthyFood::getPrice).sum();
        double sumBeverage = this.beverages.stream().mapToDouble(Beverages::getPrice).sum();

        return sumFood + sumBeverage + this.allPeople();
    }

    @Override
    public void clear() {
        this.healthyFood.clear();
        this.beverages.clear();
        this.numberOfPeople = 0;
        this.isReservedTable = false;
    }

    @Override
    public String tableInformation() {
//        "Table - {table number}"
//        "Size - {table size}"
//        "Type - {table type}"
//        "All price - {price per person for the current table}"
        StringBuilder output = new StringBuilder(String.format("Table - %d", this.number)).append(System.lineSeparator())
                .append(String.format("Size - %d", this.size)).append(System.lineSeparator())
                .append(String.format("Type - %s", this.getClass().getSimpleName())).append(System.lineSeparator())
                .append(String.format("All price - %.2f", this.allPeople));

        return output.toString().trim();
    }

    public void setSize(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_TABLE_SIZE);
        }
        this.size = size;
    }

    public void setNumberOfPeople(int numberOfPeople) {
        if (numberOfPeople <= 0) {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_NUMBER_OF_PEOPLE);
        }
        this.numberOfPeople = numberOfPeople;
    }
}
