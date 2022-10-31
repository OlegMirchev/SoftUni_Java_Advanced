package JavaAdvanced2021.JavaOPP.Exam.restaurant.repositories.interfaces;


public interface HealthFoodRepository<T> extends Repository<T> {

    T foodByName(String name);
}
