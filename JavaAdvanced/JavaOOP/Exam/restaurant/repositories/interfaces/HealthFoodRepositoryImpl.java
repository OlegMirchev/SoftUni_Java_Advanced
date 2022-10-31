package JavaAdvanced2021.JavaOPP.Exam.restaurant.repositories.interfaces;


import JavaAdvanced2021.JavaOPP.Exam.restaurant.entities.healthyFoods.interfaces.HealthyFood;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class HealthFoodRepositoryImpl implements HealthFoodRepository<HealthyFood> {
    private List<HealthyFood> listFood;

    public HealthFoodRepositoryImpl() {
        this.listFood = new ArrayList<>();
    }

    @Override
    public HealthyFood foodByName(String name) {
        HealthyFood foods = null;
        for (HealthyFood healthyFood : listFood) {
            if (healthyFood.getName().equals(name)) {
                foods = healthyFood;
            }
        }
        return foods;
    }

    @Override
    public Collection<HealthyFood> getAllEntities() {
        return Collections.unmodifiableList(listFood);
    }

    @Override
    public void add(HealthyFood entity) {
        this.listFood.add(entity);
    }
}
