package JavaAdvanced2021.JavaOPP.Exam.restaurant.core;


import JavaAdvanced2021.JavaOPP.Exam.restaurant.common.ExceptionMessages;
import JavaAdvanced2021.JavaOPP.Exam.restaurant.common.OutputMessages;
import JavaAdvanced2021.JavaOPP.Exam.restaurant.core.interfaces.Controller;
import JavaAdvanced2021.JavaOPP.Exam.restaurant.entities.drinks.interfaces.Beverages;
import JavaAdvanced2021.JavaOPP.Exam.restaurant.entities.drinks.interfaces.Fresh;
import JavaAdvanced2021.JavaOPP.Exam.restaurant.entities.drinks.interfaces.Smoothie;
import JavaAdvanced2021.JavaOPP.Exam.restaurant.entities.healthyFoods.interfaces.HealthyFood;
import JavaAdvanced2021.JavaOPP.Exam.restaurant.entities.healthyFoods.interfaces.Salad;
import JavaAdvanced2021.JavaOPP.Exam.restaurant.entities.healthyFoods.interfaces.VeganBiscuits;
import JavaAdvanced2021.JavaOPP.Exam.restaurant.entities.tables.interfaces.InGarden;
import JavaAdvanced2021.JavaOPP.Exam.restaurant.entities.tables.interfaces.Indoors;
import JavaAdvanced2021.JavaOPP.Exam.restaurant.entities.tables.interfaces.Table;
import JavaAdvanced2021.JavaOPP.Exam.restaurant.repositories.interfaces.*;

import java.util.Collection;

public class ControllerImpl implements Controller {
    private HealthFoodRepository<HealthyFood> healthFoodRepository;
    private BeverageRepository<Beverages> beverageRepository;
    private TableRepository<Table> tableRepository;
    private double totalBill;

    public ControllerImpl(HealthFoodRepository<HealthyFood> healthFoodRepository, BeverageRepository<Beverages> beverageRepository, TableRepository<Table> tableRepository) {
        this.healthFoodRepository = new HealthFoodRepositoryImpl();
        this.beverageRepository = new BeverageRepositoryImpl();
        this.tableRepository = new TableRepositoryImpl();
        this.totalBill = 0;

    }

    @Override
    public String addHealthyFood(String type, double price, String name) {
        HealthyFood foods = null;

        if (type.equals("Salad")) {
            foods = new Salad(name, price);
        } else if (type.equals("VeganBiscuits")) {
            foods = new VeganBiscuits(name, price);
        }

        HealthyFood healthyFood = this.healthFoodRepository.foodByName(name);
        if (healthyFood == null) {
            this.healthFoodRepository.add(foods);
            return String.format(OutputMessages.FOOD_ADDED, name);
        }

//        if (this.listFoods.contains(foods)) {
//            throw new IllegalArgumentException(String.format(ExceptionMessages.FOOD_EXIST, name));
//        }

        // this.listFoods.add(foods);

        throw new IllegalArgumentException(String.format(ExceptionMessages.FOOD_EXIST, name));
    }

    @Override
    public String addBeverage(String type, int counter, String brand, String name) {
        Beverages beverages = null;

        if (type.equals("Fresh")) {
            beverages = new Fresh(name, counter, brand);
        } else if (type.equals("Smoothie")) {
            beverages = new Smoothie(name, counter, brand);
        }
        Beverages byName = this.beverageRepository.beverageByName(name, brand);
        if (byName == null) {
            this.beverageRepository.add(beverages);
            return String.format(OutputMessages.BEVERAGE_ADDED, type, brand);
        }
//        if (this.listBeverage.contains(beverages)) {
//            throw new IllegalArgumentException(String.format(ExceptionMessages.BEVERAGE_EXIST, name));
//        }
//
//        this.listBeverage.add(beverages);
        throw new IllegalArgumentException(String.format(ExceptionMessages.BEVERAGE_EXIST, name));
    }

    @Override
    public String addTable(String type, int tableNumber, int capacity) {
        Table tables = null;

        if (type.equals("InGarden")) {
            tables = new InGarden(tableNumber, capacity);
        } else if (type.equals("Indoors")) {
            tables = new Indoors(tableNumber, capacity);
        }
        Table table = this.tableRepository.byNumber(tableNumber);
        if (table == null) {
            this.tableRepository.add(tables);
            return String.format(OutputMessages.TABLE_ADDED, tableNumber);
        }
//        if (this.listTable.contains(tables)) {
//            throw new IllegalArgumentException(String.format(ExceptionMessages.TABLE_IS_ALREADY_ADDED, tableNumber));
//        }
//
//        this.listTable.add(tables);

        throw new IllegalArgumentException(String.format(ExceptionMessages.TABLE_IS_ALREADY_ADDED, tableNumber));
    }

    @Override
    public String reserve(int numberOfPeople) {
        Collection<Table> allEntitiesTable = this.tableRepository.getAllEntities();

        Table table = allEntitiesTable.stream().filter(t -> !t.isReservedTable() && t.getSize() >= numberOfPeople)
                .findFirst().orElse(null);

        if (table != null) {
            table.reserve(numberOfPeople);
        return String.format(OutputMessages.TABLE_RESERVED, table.getTableNumber(), numberOfPeople);
        }

//        for (Table table : listTable) {
//            if (!table.isReservedTable() && table.getSize() >= numberOfPeople) {
//                return String.format(OutputMessages.TABLE_RESERVED, table.getTableNumber(), numberOfPeople);
//            }
//        }
      return String.format(OutputMessages.RESERVATION_NOT_POSSIBLE, numberOfPeople);
    }

    @Override
    public String orderHealthyFood(int tableNumber, String healthyFoodName) {
        Table table = this.tableRepository.byNumber(tableNumber);
        HealthyFood healthyFood = this.healthFoodRepository.foodByName(healthyFoodName);

        if (table == null) {
            return String.format(OutputMessages.WRONG_TABLE_NUMBER, tableNumber);
        }
        if (healthyFood == null) {
            return String.format(OutputMessages.NONE_EXISTENT_FOOD, healthyFoodName);
        }

        table.orderHealthy(healthyFood);

        return String.format(OutputMessages.FOOD_ORDER_SUCCESSFUL, healthyFoodName, tableNumber);
    }

    @Override
    public String orderBeverage(int tableNumber, String name, String brand) {
        Table table = this.tableRepository.byNumber(tableNumber);
        Beverages beverageByName = this.beverageRepository.beverageByName(name, brand);

        if (table == null) {
            return String.format(OutputMessages.WRONG_TABLE_NUMBER, tableNumber);
        }
        if (beverageByName == null) {
            return String.format(OutputMessages.NON_EXISTENT_DRINK, name, brand);
        }

        table.orderBeverages(beverageByName);

        return String.format(OutputMessages.BEVERAGE_ORDER_SUCCESSFUL, name, tableNumber);
    }

    @Override
    public String closedBill(int tableNumber) {
        Table table = this.tableRepository.byNumber(tableNumber);

        double bill = table.bill();

        this.totalBill += bill;

        table.clear();

        return String.format(OutputMessages.BILL, tableNumber, bill);

    }

    @Override
    public String totalMoney() {

        return String.format(OutputMessages.TOTAL_MONEY, this.totalBill);
    }
}
