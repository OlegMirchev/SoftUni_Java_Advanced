package JavaAdvanced2021.JavaOPP.Exam.spaceStation.models.mission;

import JavaAdvanced2021.JavaOPP.Exam.spaceStation.models.astronauts.Astronaut;
import JavaAdvanced2021.JavaOPP.Exam.spaceStation.models.planets.Planet;

import java.util.List;

public interface Mission {
    void explore(Planet planet, List<Astronaut> astronauts);
}
