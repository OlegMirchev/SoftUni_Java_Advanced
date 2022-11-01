package JavaAdvanced2021.JavaOPP.Exam.spaceStation;

import JavaAdvanced2021.JavaOPP.Exam.spaceStation.core.Controller;
import JavaAdvanced2021.JavaOPP.Exam.spaceStation.core.ControllerImpl;
import JavaAdvanced2021.JavaOPP.Exam.spaceStation.core.Engine;
import JavaAdvanced2021.JavaOPP.Exam.spaceStation.core.EngineImpl;

public class Main {
    public static void main(String[] args) {
        Controller controller = new ControllerImpl();
        Engine engine = new EngineImpl(controller);

        engine.run();
    }
}
