package JavaAdvanced2021.JavaOPP.Exam.restaurant.repositories.interfaces;


import JavaAdvanced2021.JavaOPP.Exam.restaurant.entities.drinks.interfaces.Beverages;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class BeverageRepositoryImpl implements BeverageRepository<Beverages> {
    List<Beverages> listBeverage;

    public BeverageRepositoryImpl() {
        this.listBeverage = new ArrayList<>();
    }

    @Override
    public Beverages beverageByName(String drinkName, String drinkBrand) {
        Beverages beverages = null;
        for (Beverages beverage : listBeverage) {
            if (beverage.getName().equals(drinkName) && beverage.getBrand().equals(drinkBrand)) {
                beverages = beverage;
            }
        }
        return beverages;
    }

    @Override
    public Collection<Beverages> getAllEntities() {
        return Collections.unmodifiableList(listBeverage);
    }

    @Override
    public void add(Beverages entity) {
        this.listBeverage.add(entity);
    }
}
