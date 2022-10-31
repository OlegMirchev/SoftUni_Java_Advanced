package JavaAdvanced2021.JavaOPP.Exam.restaurant;


import JavaAdvanced2021.JavaOPP.Exam.restaurant.core.ControllerImpl;
import JavaAdvanced2021.JavaOPP.Exam.restaurant.core.EngineImpl;
import JavaAdvanced2021.JavaOPP.Exam.restaurant.core.interfaces.Controller;
import JavaAdvanced2021.JavaOPP.Exam.restaurant.entities.drinks.interfaces.Beverages;
import JavaAdvanced2021.JavaOPP.Exam.restaurant.entities.healthyFoods.interfaces.HealthyFood;
import JavaAdvanced2021.JavaOPP.Exam.restaurant.entities.tables.interfaces.Table;
import JavaAdvanced2021.JavaOPP.Exam.restaurant.io.ConsoleReader;
import JavaAdvanced2021.JavaOPP.Exam.restaurant.io.ConsoleWriter;
import JavaAdvanced2021.JavaOPP.Exam.restaurant.repositories.interfaces.BeverageRepository;
import JavaAdvanced2021.JavaOPP.Exam.restaurant.repositories.interfaces.HealthFoodRepository;
import JavaAdvanced2021.JavaOPP.Exam.restaurant.repositories.interfaces.TableRepository;

public class Main {
    public static void main(String[] args) {

        HealthFoodRepository<HealthyFood> healthFoodRepository = null;
        BeverageRepository<Beverages> beverageRepository = null;
        TableRepository<Table> tableRepository = null;


        Controller controller = new ControllerImpl(healthFoodRepository, beverageRepository, tableRepository);

        ConsoleReader reader = new ConsoleReader();
        ConsoleWriter writer = new ConsoleWriter();
        EngineImpl engine = new EngineImpl(reader, writer, controller);
        engine.run();

    }
}
