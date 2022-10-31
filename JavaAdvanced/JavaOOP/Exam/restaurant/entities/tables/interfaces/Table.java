package JavaAdvanced2021.JavaOPP.Exam.restaurant.entities.tables.interfaces;


import JavaAdvanced2021.JavaOPP.Exam.restaurant.entities.drinks.interfaces.Beverages;
import JavaAdvanced2021.JavaOPP.Exam.restaurant.entities.healthyFoods.interfaces.HealthyFood;

public interface Table {

    int getTableNumber();

    int getSize();

    int numberOfPeople();

    double pricePerPerson();

    boolean isReservedTable();

    double allPeople();

    void reserve(int numberOfPeople);

    void orderHealthy(HealthyFood food);

    void orderBeverages(Beverages beverages);

    double bill();

    void clear();

    String tableInformation();
}
