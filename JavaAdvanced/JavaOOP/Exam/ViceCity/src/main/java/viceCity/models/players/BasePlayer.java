package JavaAdvanced2021.JavaOPP.Exam.ViceCity.src.main.java.viceCity.models.players;

import JavaAdvanced2021.JavaOPP.Exam.ViceCity.src.main.java.viceCity.common.ExceptionMessages;
import JavaAdvanced2021.JavaOPP.Exam.ViceCity.src.main.java.viceCity.models.guns.Gun;
import JavaAdvanced2021.JavaOPP.Exam.ViceCity.src.main.java.viceCity.repositories.interfaces.GunRepository;
import JavaAdvanced2021.JavaOPP.Exam.ViceCity.src.main.java.viceCity.repositories.interfaces.Repository;

public abstract class BasePlayer implements Player {
    private String name;
    private int lifePoints;
    private Repository<Gun> gunRepository;

    protected BasePlayer(String name, int lifePoints) {
        this.setName(name);
        this.setLifePoints(lifePoints);
        this.gunRepository = new GunRepository();
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(ExceptionMessages.PLAYER_NULL_USERNAME);
        }
        this.name = name;
    }

    private void setLifePoints(int lifePoints) {
        if (lifePoints < 0) {
            throw new IllegalArgumentException(ExceptionMessages.PLAYER_LIFE_POINTS_LESS_THAN_ZERO);
        }
        this.lifePoints = lifePoints;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getLifePoints() {
        return this.lifePoints;
    }

    @Override
    public boolean isAlive() {
        return this.lifePoints > 0;
    }

    @Override
    public Repository<Gun> getGunRepository() {
        return this.gunRepository;
    }

    @Override
    public void takeLifePoints(int points) {
        this.lifePoints = Math.max(0, this.lifePoints - points);
    }
}
