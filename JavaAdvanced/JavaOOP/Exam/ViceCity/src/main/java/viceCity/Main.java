package JavaAdvanced2021.JavaOPP.Exam.ViceCity.src.main.java.viceCity;


import JavaAdvanced2021.JavaOPP.Exam.ViceCity.src.main.java.viceCity.core.ControllerImpl;
import JavaAdvanced2021.JavaOPP.Exam.ViceCity.src.main.java.viceCity.core.EngineImpl;
import JavaAdvanced2021.JavaOPP.Exam.ViceCity.src.main.java.viceCity.core.interfaces.Controller;
import JavaAdvanced2021.JavaOPP.Exam.ViceCity.src.main.java.viceCity.core.interfaces.Engine;

public class Main {
    public static void main(String[] args) {
        Controller controller = new ControllerImpl();
        Engine engine = new EngineImpl(controller);
        engine.run();
    }
}
