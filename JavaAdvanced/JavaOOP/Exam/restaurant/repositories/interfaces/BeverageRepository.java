package JavaAdvanced2021.JavaOPP.Exam.restaurant.repositories.interfaces;


public interface BeverageRepository<T> extends Repository<T> {

    T beverageByName(String drinkName,String drinkBrand);
}
