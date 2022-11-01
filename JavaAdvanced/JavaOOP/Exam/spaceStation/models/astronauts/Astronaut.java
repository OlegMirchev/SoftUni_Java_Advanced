package JavaAdvanced2021.JavaOPP.Exam.spaceStation.models.astronauts;

import JavaAdvanced2021.JavaOPP.Exam.spaceStation.models.bags.Bag;

public interface Astronaut {
    String getName();

    double getOxygen();

    boolean canBreath();

    Bag getBag();

    void breath();
}
