package JavaAdvanced2021.JavaOPP.Exam.ViceCity.src.main.java.viceCity.models.players;

import JavaAdvanced2021.JavaOPP.Exam.ViceCity.src.main.java.viceCity.models.guns.Gun;
import JavaAdvanced2021.JavaOPP.Exam.ViceCity.src.main.java.viceCity.repositories.interfaces.Repository;

public interface Player {
    String getName();

    int getLifePoints();

    boolean isAlive();

    Repository<Gun> getGunRepository();

    void takeLifePoints(int points);
}
