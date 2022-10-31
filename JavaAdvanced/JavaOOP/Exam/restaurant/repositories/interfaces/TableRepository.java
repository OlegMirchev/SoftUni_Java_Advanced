package JavaAdvanced2021.JavaOPP.Exam.restaurant.repositories.interfaces;


public interface TableRepository<T> extends Repository<T> {

    T byNumber(int number);
}
