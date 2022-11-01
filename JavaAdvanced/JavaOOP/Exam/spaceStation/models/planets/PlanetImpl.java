package JavaAdvanced2021.JavaOPP.Exam.spaceStation.models.planets;

import JavaAdvanced2021.JavaOPP.Exam.spaceStation.common.ExceptionMessages;

import java.util.ArrayList;
import java.util.List;

public class PlanetImpl implements Planet {
    private String name;
    List<String> items;

    public PlanetImpl(String name) {
        this.setName(name);
        this.items = new ArrayList<>();
    }

    @Override
    public List<String> getItems() {
        return this.items;
    }

    @Override
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(ExceptionMessages.PLANET_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }
}
