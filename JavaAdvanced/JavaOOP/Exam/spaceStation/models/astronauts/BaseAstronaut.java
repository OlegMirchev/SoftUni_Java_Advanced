package JavaAdvanced2021.JavaOPP.Exam.spaceStation.models.astronauts;

import JavaAdvanced2021.JavaOPP.Exam.spaceStation.common.ExceptionMessages;
import JavaAdvanced2021.JavaOPP.Exam.spaceStation.models.bags.Backpack;
import JavaAdvanced2021.JavaOPP.Exam.spaceStation.models.bags.Bag;

public abstract class BaseAstronaut implements Astronaut {
    private String name;
    private double oxygen;
    private Bag bag;

    protected BaseAstronaut(String name, double oxygen) {
        this.setName(name);
        this.setOxygen(oxygen);
        this.bag = new Backpack();
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(ExceptionMessages.ASTRONAUT_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    @Override
    public double getOxygen() {
        return oxygen;
    }

    public void setOxygen(double oxygen) {
        if (oxygen < 0) {
            throw new IllegalArgumentException(ExceptionMessages.ASTRONAUT_OXYGEN_LESS_THAN_ZERO);
        }
        this.oxygen = oxygen;
    }

    @Override
    public boolean canBreath() {
        return this.oxygen > 0;
    }

    @Override
    public Bag getBag() {
        return bag;
    }

    @Override
    public void breath() {
        this.setOxygen(this.getOxygen() - 10);
    }

    public void setBag(Bag bag) {
        this.bag = bag;
    }
}
