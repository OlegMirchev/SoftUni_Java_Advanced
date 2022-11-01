package JavaAdvanced2021.JavaOPP.Exam.spaceStation.core;

import JavaAdvanced2021.JavaOPP.Exam.spaceStation.common.ConstantMessages;
import JavaAdvanced2021.JavaOPP.Exam.spaceStation.common.ExceptionMessages;
import JavaAdvanced2021.JavaOPP.Exam.spaceStation.models.astronauts.Astronaut;
import JavaAdvanced2021.JavaOPP.Exam.spaceStation.models.astronauts.Biologist;
import JavaAdvanced2021.JavaOPP.Exam.spaceStation.models.astronauts.Geodesist;
import JavaAdvanced2021.JavaOPP.Exam.spaceStation.models.astronauts.Meteorologist;
import JavaAdvanced2021.JavaOPP.Exam.spaceStation.models.mission.Mission;
import JavaAdvanced2021.JavaOPP.Exam.spaceStation.models.mission.MissionImpl;
import JavaAdvanced2021.JavaOPP.Exam.spaceStation.models.planets.Planet;
import JavaAdvanced2021.JavaOPP.Exam.spaceStation.models.planets.PlanetImpl;
import JavaAdvanced2021.JavaOPP.Exam.spaceStation.repositories.AstronautRepository;
import JavaAdvanced2021.JavaOPP.Exam.spaceStation.repositories.PlanetRepository;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ControllerImpl implements Controller {
    private AstronautRepository astronautRepository;
    private PlanetRepository planetRepository;
    private int exploredPlanetsCount;

    public ControllerImpl() {
        this.astronautRepository = new AstronautRepository();
        this.planetRepository = new PlanetRepository();
    }

    @Override
    public String addAstronaut(String type, String astronautName) {
        Astronaut astronaut = null;
        switch (type) {
            case "Biologist":
                astronaut = new Biologist(astronautName);
                break;
            case "Geodesist":
                astronaut = new Geodesist(astronautName);
                break;
            case "Meteorologist":
                astronaut = new Meteorologist(astronautName);
                break;
            default:
                throw new IllegalArgumentException(ExceptionMessages.ASTRONAUT_INVALID_TYPE);
        }
        this.astronautRepository.add(astronaut);
        return String.format(ConstantMessages.ASTRONAUT_ADDED, type, astronautName);
    }

    @Override
    public String addPlanet(String planetName, String... items) {
        List<String> listItems = Arrays.asList(items);
        Planet planet = new PlanetImpl(planetName);
        planet.getItems().addAll(listItems);
        this.planetRepository.add(planet);

        return String.format(ConstantMessages.PLANET_ADDED, planetName);
    }

    @Override
    public String retireAstronaut(String astronautName) {
        if (this.astronautRepository.getModels().stream().noneMatch(a -> a.getName().equals(astronautName))) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.ASTRONAUT_DOES_NOT_EXIST, astronautName));
        }
        Astronaut astronautRemove = this.astronautRepository.findByName(astronautName);
        this.astronautRepository.remove(astronautRemove);

        return String.format(ConstantMessages.ASTRONAUT_RETIRED, astronautName);
    }

    @Override
    public String explorePlanet(String planetName) {
        List<Astronaut> listAstronautOxygen = this.astronautRepository.getModels()
                .stream().filter(a -> a.getOxygen() > 60).collect(Collectors.toList());
        if (listAstronautOxygen.isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessages.PLANET_ASTRONAUTS_DOES_NOT_EXISTS);
        }
        int countBeforeMission = listAstronautOxygen.size();
        Mission mission = new MissionImpl();
        Planet planet = this.planetRepository.findByName(planetName);
        mission.explore(planet, listAstronautOxygen);
        this.exploredPlanetsCount++;
        int countAfterMission = listAstronautOxygen.size();
        return String.format(ConstantMessages.PLANET_EXPLORED, planetName, countBeforeMission - countAfterMission);
    }

    @Override
    public String report() {
        StringBuilder output = new StringBuilder(String.format(ConstantMessages.REPORT_PLANET_EXPLORED, this.exploredPlanetsCount))
                .append(System.lineSeparator()).append(ConstantMessages.REPORT_ASTRONAUT_INFO).append(System.lineSeparator());
        this.astronautRepository.getModels().forEach(a -> {
            output.append(String.format(ConstantMessages.REPORT_ASTRONAUT_NAME, a.getName())).append(System.lineSeparator())
                    .append(String.format(ConstantMessages.REPORT_ASTRONAUT_OXYGEN, a.getOxygen())).append(System.lineSeparator());
            if (a.getBag().getItems().isEmpty()) {
                output.append(String.format(ConstantMessages.REPORT_ASTRONAUT_BAG_ITEMS, "none")).append(System.lineSeparator());
            }else {
                output.append(String.format(ConstantMessages.REPORT_ASTRONAUT_BAG_ITEMS,
                       String.join(ConstantMessages.REPORT_ASTRONAUT_BAG_ITEMS_DELIMITER, a.getBag().getItems()))).append(System.lineSeparator());
            }
        });
        return output.toString().trim();
    }
}
