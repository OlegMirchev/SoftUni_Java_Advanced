package JavaAdvanced2021.JavaOPP.Exam.spaceStation.models.mission;

import JavaAdvanced2021.JavaOPP.Exam.spaceStation.models.astronauts.Astronaut;
import JavaAdvanced2021.JavaOPP.Exam.spaceStation.models.planets.Planet;

import java.util.List;

public class MissionImpl implements Mission {
    @Override
    public void explore(Planet planet, List<Astronaut> astronauts) {
        for (int i = 0; i < astronauts.size(); i++) {
            Astronaut currentAstronaut = astronauts.get(i);
            for (int item = 0; item < planet.getItems().size(); item++) {
                String currentItems = planet.getItems().get(item);
                currentAstronaut.getBag().getItems().add(currentItems);
                planet.getItems().remove(currentItems);
                item--;
                currentAstronaut.breath();
                if (!currentAstronaut.canBreath()) {
                    astronauts.remove(currentAstronaut);
                    i--;
                    break;
                }
            }
        }
    }
}
